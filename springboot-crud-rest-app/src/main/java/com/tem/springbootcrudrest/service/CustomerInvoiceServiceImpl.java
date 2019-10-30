package com.tem.springbootcrudrest.service;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.tem.springbootcrudrest.model.Customer;
import com.tem.springbootcrudrest.model.CustomerInvoice;
import com.tem.springbootcrudrest.model.CustomerPaymentUpdateInCustomerInvoice;
import com.tem.springbootcrudrest.model.VendorInvoice;
import com.tem.springbootcrudrest.repository.CustomerInvoiceRepository;
import com.tem.springbootcrudrest.repository.VendorInvoiceRepository;

@Component
public class CustomerInvoiceServiceImpl implements CustomerInvoiceService {

	@Autowired
	CustomerInvoiceRepository customerInvoiceRepository;

	@Autowired
	VendorInvoiceRepository vendorInvoiceRepository;

	@Override
	public CustomerInvoice createCustomerInvoice(CustomerInvoice customerinvoice) {
		customerinvoice.setPaymentstatus("Pending");
		customerinvoice.setCustomerpaymentid(0);

		return customerInvoiceRepository.save(customerinvoice);

	}

	@Override
	public CustomerInvoice updateCustomerInvoice(CustomerInvoice customerInvoice) {

		return customerInvoiceRepository.save(customerInvoice);
	}

	@Override
	public String deleteById(long custInvoiceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerInvoice> getCustomerInvoiceList() {

		return customerInvoiceRepository.findAll();
	}

	@Override
	public List<Object> findVendorandCustomerList() {

		List<VendorInvoice> vendorinvoicelist = vendorInvoiceRepository.findAll();
		List<CustomerInvoice> customerinvoicelist = customerInvoiceRepository.findAll();
		List<Object> vendorCustomerList = new ArrayList<Object>();

		for (CustomerInvoice customerinvoice : customerinvoicelist) {

			vendorCustomerList.add(customerinvoice);
		}

		for (VendorInvoice vendorinvoice : vendorinvoicelist) {
			vendorCustomerList.add(vendorinvoice);
		}

		return vendorCustomerList;
	}

	@Override
	public List<CustomerInvoice> getCustomerInvoiceLists(String fromdate, String todate, String customername) {
		return customerInvoiceRepository.findInvoiceBetweenDateList(fromdate, todate, customername);
	}

	/*
	 * @Override public List<CustomerInvoice>
	 * updateCustomerPayment(List<CustomerInvoice> customerinvoices) {
	 * 
	 * List<CustomerInvoice> listCustomer = new ArrayList<CustomerInvoice>();
	 * 
	 * for (CustomerInvoice customerInvoice : customerinvoices) {
	 * 
	 * CustomerInvoice customerinvoiceobj =
	 * customerInvoiceRepository.findByCustomerinvoiceid(customerInvoice.
	 * getCustomerinvoiceid());
	 * 
	 * customerinvoiceobj.setAmount(customerInvoice.getAmount());
	 * 
	 * if(customerInvoice.getAmount().equals(customerinvoiceobj.getNetamount())) {
	 * customerinvoiceobj.setPaymentstatus("Completed"); }
	 * 
	 * customerinvoiceobj.setInstrumentno(customerInvoice.getInstrumentno());
	 * customerinvoiceobj.setPaymentdate(customerInvoice.getPaymentdate());
	 * customerinvoiceobj.setPaymenttype(customerInvoice.getPaymenttype());
	 * customerinvoiceobj.setCustomername(customerInvoice.getCustomername());
	 * 
	 * CustomerInvoice customerinvo =
	 * customerInvoiceRepository.save(customerinvoiceobj);
	 * listCustomer.add(customerinvo);
	 * 
	 * }
	 * 
	 * return listCustomer; }
	 */

	@Override
	public List<CustomerInvoice> updateCustPaymentFromCusPayment(
			CustomerPaymentUpdateInCustomerInvoice customerPaymentUpdateInCustomerInvoice) {
		List<CustomerInvoice> customerinvoice = new ArrayList<CustomerInvoice>();

		for (long invoiceid : customerPaymentUpdateInCustomerInvoice.getInvoiceid()) {

			CustomerInvoice customerIvoice = customerInvoiceRepository.findByCustomerinvoiceid(invoiceid);
			customerIvoice.setCustomerpaymentid(customerPaymentUpdateInCustomerInvoice.getPaymentid());
			customerIvoice.setPaymentstatus("Completed");
			CustomerInvoice ustomerinvoiceres = customerInvoiceRepository.save(customerIvoice);
			customerinvoice.add(ustomerinvoiceres);

		}
		return customerinvoice;
	}

	private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
	
	@Override
	public String generatePdfForCustomerInvoiceCalculated(List<CustomerInvoice> customerinvoicepdf) throws FileNotFoundException {

		Document document = new Document();

		String message = null;
		
		
		try {
			
			PdfPTable table = null;
			
			
			Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
			Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
			PdfPCell pdfWordCell = new PdfPCell();
			
			 Paragraph paragraph = new Paragraph();
			
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\\\samplepdffile/customerinvoice.pdf"));
			document.open();
			Font boldFont2 = new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.BOLD);
			Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 20,
		            Font.NORMAL, BaseColor.RED);
			
			Font normalFontaddress = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
			Font normalinvoice = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
			Font toaddress = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);

			
			
			
			
			document.add(new Paragraph("S.SARAVANAN ENTERPRISES",redFont));
			 addEmptyLine(paragraph, 1);
			 document.add(new Paragraph("No 47, Bajanai Koil Street, Paruthapattu, Avadi Chennai - 600 071. Tamilnadu",normalFontaddress));
			 document.add(new Paragraph("E.mail : ssenterprises4358@gmail.com",normalFontaddress));
			 addEmptyLine(paragraph, 2);
			 
			 
			 table = new PdfPTable(2);
				table.setWidthPercentage(105f);
				table.setSpacingBefore(11f);
				table.setSpacingAfter(11f);
				float[] colWidths = { 2f, 2f };
				table.setWidths(colWidths);
			 
			 
				Phrase customerNameLables = new Phrase("Coca Cola ENTERPRISES,No 47, Bajanai Koil Street, Paruthapattu, Avadi Chennai - 600 071,Tamilnadu.", toaddress);
				pdfWordCell = new PdfPCell();
				pdfWordCell.addElement(customerNameLables);
				table.addCell(pdfWordCell);
				
				pdfWordCell = new PdfPCell();
				Phrase customerNameValues= new Phrase("TO :S Technologies,No 50, Bajanai Koil Street, Paruthapattu, Avadi Chennai - 600 089,Tamilnadu.", toaddress);
				pdfWordCell.addElement(customerNameValues);
				table.addCell(pdfWordCell);
				document.add(table);
			 
			 
				Paragraph preface = new Paragraph("Tax Invoice",normalinvoice); 
				preface.setAlignment(Element.ALIGN_CENTER);


			 document.add(preface);
			 
			 

			List<CustomerInvoice> dataObjList = new ArrayList<CustomerInvoice>();

			

			
			for (CustomerInvoice customerInvoice : customerinvoicepdf) {

				table = new PdfPTable(2);
				table.setWidthPercentage(105f);
				table.setSpacingBefore(11f);
				table.setSpacingAfter(11f);
				float[] colWidth = { 2f, 2f };
				table.setWidths(colWidth);

				/*Phrase invoiceNoLable = new Phrase("InvoiceNo", boldFont);
				pdfWordCell = new PdfPCell();
				pdfWordCell.addElement(invoiceNoLable);
				table.addCell(pdfWordCell);
				
				pdfWordCell = new PdfPCell();
				Phrase invoiceNoValue = new Phrase(String.valueOf(customerInvoice.getCustomerinvoiceid()), normalFont);
				pdfWordCell.addElement(invoiceNoValue);
				table.addCell(pdfWordCell);*/
				
				

				Phrase customerNameLable = new Phrase("Customer Name", boldFont);
				pdfWordCell = new PdfPCell();
				pdfWordCell.addElement(customerNameLable);
				table.addCell(pdfWordCell);
				
				pdfWordCell = new PdfPCell();
				Phrase customerNameValue = new Phrase(customerInvoice.getCustomername(), normalFont);
				pdfWordCell.addElement(customerNameValue);
				table.addCell(pdfWordCell);
				
				
				Phrase totalTripLable = new Phrase("Total Trip", boldFont);
				pdfWordCell = new PdfPCell();
				pdfWordCell.addElement(totalTripLable);
				table.addCell(pdfWordCell);
				
				pdfWordCell = new PdfPCell();
				Phrase totalTripValue = new Phrase(customerInvoice.getTotaltrip(), normalFont);
				pdfWordCell.addElement(totalTripValue);
				table.addCell(pdfWordCell);
				
				
				Phrase dateLable = new Phrase("Date", boldFont);
				pdfWordCell = new PdfPCell();
				pdfWordCell.addElement(dateLable);
				table.addCell(pdfWordCell);
				
				pdfWordCell = new PdfPCell();
				Phrase dateValue = new Phrase(customerInvoice.getCreateddate(), normalFont);
				pdfWordCell.addElement(dateValue);
				table.addCell(pdfWordCell);
				
				
				
				Phrase truckTypeLable = new Phrase("Truck Type", boldFont);
				pdfWordCell = new PdfPCell();
				pdfWordCell.addElement(truckTypeLable);
				table.addCell(pdfWordCell);
				
				pdfWordCell = new PdfPCell();
				Phrase truckTypeValue = new Phrase(customerInvoice.getTrucktype(), normalFont);
				pdfWordCell.addElement(truckTypeValue);
				table.addCell(pdfWordCell);
				
				
				Phrase noOfCaseLable = new Phrase("No of case", boldFont);
				pdfWordCell = new PdfPCell();
				pdfWordCell.addElement(noOfCaseLable);
				table.addCell(pdfWordCell);
				
				pdfWordCell = new PdfPCell();
				Phrase noOfCaseValue = new Phrase(customerInvoice.getTotalcase(), normalFont);
				pdfWordCell.addElement(noOfCaseValue);
				table.addCell(pdfWordCell);
				
				//vendorInvoice.getTotalkmpercharge() != null ? vendorInvoice.getTotalkmpercharge() : ""
				
				Phrase totalkmsLable = new Phrase("Total kms", boldFont);
				pdfWordCell = new PdfPCell();
				pdfWordCell.addElement(totalkmsLable);
				table.addCell(pdfWordCell);
				
				pdfWordCell = new PdfPCell();
				Phrase totalkmsValue = new Phrase(customerInvoice.getTotalkm(), normalFont);
				pdfWordCell.addElement(totalkmsValue);
				table.addCell(pdfWordCell);
				
				
				Phrase perKmsTotalLable = new Phrase("Total Per Kms", boldFont);
				pdfWordCell = new PdfPCell();
				pdfWordCell.addElement(perKmsTotalLable);
				table.addCell(pdfWordCell);
				
				pdfWordCell = new PdfPCell();
				Phrase perKmsTotalValue = new Phrase(customerInvoice.getTotalkmpercharge() != null ? customerInvoice.getTotalkmpercharge() : "", normalFont);
				pdfWordCell.addElement(perKmsTotalValue);
				table.addCell(pdfWordCell);
				
				
				
				Phrase totalFreightAmtLable = new Phrase("Total Freight Amt", boldFont);
				pdfWordCell = new PdfPCell();
				pdfWordCell.addElement(totalFreightAmtLable);
				table.addCell(pdfWordCell);
				
				pdfWordCell = new PdfPCell();
				Phrase totalFreightAmtValue = new Phrase(customerInvoice.getTotalkmpercharge() != null ? customerInvoice.getTotalkmpercharge() : "", normalFont);
				pdfWordCell.addElement(totalFreightAmtValue);
				table.addCell(pdfWordCell);
				
				
				
				Phrase advanceLable = new Phrase("Advance", boldFont);
				pdfWordCell = new PdfPCell();
				pdfWordCell.addElement(advanceLable);
				table.addCell(pdfWordCell);
				
				pdfWordCell = new PdfPCell();
				Phrase advanceValue = new Phrase(customerInvoice.getTotaladvance(), normalFont);
				pdfWordCell.addElement(advanceValue);
				table.addCell(pdfWordCell);
				
				

				Phrase discountLable = new Phrase("Discount", boldFont);
				pdfWordCell = new PdfPCell();
				pdfWordCell.addElement(discountLable);
				table.addCell(pdfWordCell);
				
				pdfWordCell = new PdfPCell();
				Phrase discountValue = new Phrase(customerInvoice.getTotaldiscount(), normalFont);
				pdfWordCell.addElement(discountValue);
				table.addCell(pdfWordCell);
				
				
				
				Phrase breakageLable = new Phrase("Leakage/Breakage", boldFont);
				pdfWordCell = new PdfPCell();
				pdfWordCell.addElement(breakageLable);
				table.addCell(pdfWordCell);
				
				pdfWordCell = new PdfPCell();
				Phrase breakageValue = new Phrase(customerInvoice.getLeakage(), normalFont);
				pdfWordCell.addElement(breakageValue);
				table.addCell(pdfWordCell);
				
				
				
				
				Phrase grantTotalLable = new Phrase("Grant Total", boldFont);
				pdfWordCell = new PdfPCell();
				pdfWordCell.addElement(grantTotalLable);
				table.addCell(pdfWordCell);
				
				pdfWordCell = new PdfPCell();
				Phrase amountValue = new Phrase(customerInvoice.getAmount(), normalFont);
				pdfWordCell.addElement(amountValue);
				table.addCell(pdfWordCell);
				
				
				
				
				

				Phrase statusLable = new Phrase("Status", boldFont);
				pdfWordCell = new PdfPCell();
				pdfWordCell.addElement(statusLable);
				table.addCell(pdfWordCell);
				
				pdfWordCell = new PdfPCell();
				Phrase statusValue = new Phrase(customerInvoice.getPaymentstatus(), normalFont);
				pdfWordCell.addElement(statusValue);
				table.addCell(pdfWordCell);
				

				
				document.add(table);
				document.newPage();
				
			}

			

			document.close();
			writer.close();
			message = "PDF Downloaded Successfully";
			
			
			/*HttpServletRequest req = (HttpServletRequest)
			HttpServletResponse resp = (HttpServletResponse)*/
			/*try {
				HttpServletRequest request = null; HttpServletResponse response=null;
				response.ad
				downloadPDF(response);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/

		} catch (DocumentException e) {
			e.printStackTrace();
		}

		return message;
	}
	
	
	/*public static void downloadPDF(HttpServletResponse response)
		    throws IOException{
		    response.setContentType("application/pdf");
		    response.setHeader("Content-disposition","attachment;filename="+ "testPDF.pdf");
		    try {
		        File f = new File("C://New folder//itext_Test.pdf");
		        FileInputStream fis = new FileInputStream(f);
		        DataOutputStream os = new DataOutputStream(response.getOutputStream());
		        response.setHeader("Content-Length",String.valueOf(f.length()));
		        byte[] buffer = new byte[1024];
		        int len = 0;
		        while ((len = fis.read(buffer)) >= 0) {
		            os.write(buffer, 0, len);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
*/
}
