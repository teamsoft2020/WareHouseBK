package com.tem.springbootcrudrest.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.tem.springbootcrudrest.model.CustomerInvoice;
import com.tem.springbootcrudrest.model.VendorInvoice;
import com.tem.springbootcrudrest.model.VendorPaymentUpdateInCustomerInvoice;
import com.tem.springbootcrudrest.repository.VendorInvoiceRepository;

@Component
public class VendorInvoiceServiceImpl implements VendorInvoiceService {

	@Autowired
	VendorInvoiceRepository vendorInvoiceRepository;

	@Override
	public VendorInvoice createVendorInvoice(VendorInvoice vendorInvoice) {
		vendorInvoice.setPaymentstatus("Pending");
		vendorInvoice.setVendpaymentid(0);
		return vendorInvoiceRepository.save(vendorInvoice);

	}

	@Override
	public String updateVendorInvoice(long vindorinvoiceid) {

		VendorInvoice vendorInvoice = new VendorInvoice();
		// tripSeet.setTripid(tripid);
		Optional<VendorInvoice> VendorInvoiceresults = vendorInvoiceRepository.findById(vindorinvoiceid);

		vendorInvoice = VendorInvoiceresults.get();

		vendorInvoice.setPaymentstatus("NO");

		VendorInvoice finalvendorinvoice = vendorInvoiceRepository.save(vendorInvoice);

		return "Status Successfully Updated";
	}

	@Override
	public String deleteById(long vendorId) {
		return null;
	}

	@Override
	public List<VendorInvoice> getVendorInvoiceList() {
		return vendorInvoiceRepository.findAll();
	}

	@Override
	public List<VendorInvoice> getVendorInvoiceLists(String fromdate, String todate, String vendorname) {
		return vendorInvoiceRepository.findInvoiceBetweenDateList(fromdate, todate, vendorname);
	}

	/*@Override
	public List<VendorInvoice> updateVendorPayment(List<VendorInvoice> vendorInvoice) {

		List<VendorInvoice> listVendor = new ArrayList<VendorInvoice>();

		for (VendorInvoice vendorInvoices : vendorInvoice) {

			VendorInvoice vendorinvoice = vendorInvoiceRepository
					.findByVendorInvoiceId(vendorInvoices.getVendorinvoiceid());

			vendorinvoice.setAmount(vendorInvoices.getAmount());

			if (vendorInvoices.getAmount().equals(vendorinvoice.getNetamount())) {
				vendorinvoice.setPaymentstatus("Completed");
			}

			vendorinvoice.setInstrumentno(vendorInvoices.getInstrumentno());
			vendorinvoice.setPaymentdate(vendorInvoices.getPaymentdate());
			vendorinvoice.setPaymenttype(vendorInvoices.getPaymenttype());
			vendorinvoice.setVendorname(vendorInvoices.getVendorname());

			VendorInvoice vendorinvo = vendorInvoiceRepository.save(vendorinvoice);
			listVendor.add(vendorinvo);

		}

		return listVendor;
	}*/

	@Override
	public List<VendorInvoice> updateVendPaymentFromCusPayment(
			VendorPaymentUpdateInCustomerInvoice vendorPaymentUpdateInCustomerInvoice) {
		List<VendorInvoice> venlist = new ArrayList<VendorInvoice>();

		for (long vendorinvoiceid : vendorPaymentUpdateInCustomerInvoice.getInvoiceid()) {
			VendorInvoice vendinvoice = new VendorInvoice();

			VendorInvoice vendInvoice =new VendorInvoice();
			
			vendInvoice = vendorInvoiceRepository.findByVendorInvoiceId(vendorinvoiceid);
			
			vendInvoice.setVendpaymentid(vendorPaymentUpdateInCustomerInvoice.getPaymentid());
			vendInvoice.setPaymentstatus("Completed");
			
			vendinvoice = vendorInvoiceRepository.save(vendInvoice);
			venlist.add(vendinvoice);
		}

		return venlist;
	}
	
	
	
	@Override
	public String generatePdfForVendorInvoiceCalculated(List<VendorInvoice> vendorinvoicepdf) {

		Document document = new Document();

		String message = null;
		
		
		try {
			
			
			PdfWriter writer = null;
			try {
				writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\\\samplepdffile/vendorinvoice.pdf"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			document.open();
			document.add(new Paragraph("Saravanan Enterprises"));

			List<CustomerInvoice> dataObjList = new ArrayList<CustomerInvoice>();

			PdfPTable table = null;

			Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
			Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.NORMAL);
			PdfPCell pdfWordCell = new PdfPCell();
			for (VendorInvoice vendorInvoice : vendorinvoicepdf) {

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
				
				

				Phrase customerNameLable = new Phrase("Vendor Name", boldFont);
				pdfWordCell = new PdfPCell();
				pdfWordCell.addElement(customerNameLable);
				table.addCell(pdfWordCell);
				
				pdfWordCell = new PdfPCell();
				Phrase customerNameValue = new Phrase(vendorInvoice.getVendorname(), normalFont);
				pdfWordCell.addElement(customerNameValue);
				table.addCell(pdfWordCell);
				
				
				Phrase totalTripLable = new Phrase("Total Trip", boldFont);
				pdfWordCell = new PdfPCell();
				pdfWordCell.addElement(totalTripLable);
				table.addCell(pdfWordCell);
				
				pdfWordCell = new PdfPCell();
				Phrase totalTripValue = new Phrase(vendorInvoice.getTotaltrip(), normalFont);
				pdfWordCell.addElement(totalTripValue);
				table.addCell(pdfWordCell);
				
				
				Phrase dateLable = new Phrase("Date", boldFont);
				pdfWordCell = new PdfPCell();
				pdfWordCell.addElement(dateLable);
				table.addCell(pdfWordCell);
				
				pdfWordCell = new PdfPCell();
				Phrase dateValue = new Phrase(vendorInvoice.getCreateddate(), normalFont);
				pdfWordCell.addElement(dateValue);
				table.addCell(pdfWordCell);
				
				
				
				Phrase truckTypeLable = new Phrase("Truck Type", boldFont);
				pdfWordCell = new PdfPCell();
				pdfWordCell.addElement(truckTypeLable);
				table.addCell(pdfWordCell);
				
				pdfWordCell = new PdfPCell();
				Phrase truckTypeValue = new Phrase(vendorInvoice.getTrucktype(), normalFont);
				pdfWordCell.addElement(truckTypeValue);
				table.addCell(pdfWordCell);
				
				
				Phrase noOfCaseLable = new Phrase("No of case", boldFont);
				pdfWordCell = new PdfPCell();
				pdfWordCell.addElement(noOfCaseLable);
				table.addCell(pdfWordCell);
				
				pdfWordCell = new PdfPCell();
				Phrase noOfCaseValue = new Phrase(vendorInvoice.getTotalcase(), normalFont);
				pdfWordCell.addElement(noOfCaseValue);
				table.addCell(pdfWordCell);
				
				
				Phrase totalkmsLable = new Phrase("Total kms", boldFont);
				pdfWordCell = new PdfPCell();
				pdfWordCell.addElement(noOfCaseLable);
				table.addCell(pdfWordCell);
				
				pdfWordCell = new PdfPCell();
				Phrase totalkmsValue = new Phrase(vendorInvoice.getTotalkm(), normalFont);
				pdfWordCell.addElement(totalkmsValue);
				table.addCell(pdfWordCell);
				
				
				Phrase perKmsTotalLable = new Phrase("Total Per Kms", boldFont);
				pdfWordCell = new PdfPCell();
				pdfWordCell.addElement(perKmsTotalLable);
				table.addCell(pdfWordCell);
				
				pdfWordCell = new PdfPCell();
				Phrase perKmsTotalValue = new Phrase( vendorInvoice.getTotalkmpercharge() != null ? vendorInvoice.getTotalkmpercharge() : "", normalFont);
				pdfWordCell.addElement(perKmsTotalValue);
				table.addCell(pdfWordCell);
				
				
				
				Phrase totalFreightAmtLable = new Phrase("Total Freight Amt", boldFont);
				pdfWordCell = new PdfPCell();
				pdfWordCell.addElement(totalFreightAmtLable);
				table.addCell(pdfWordCell);
				
				pdfWordCell = new PdfPCell();
				Phrase totalFreightAmtValue = new Phrase( vendorInvoice.getTotalfreightamt() != null ? String.valueOf(vendorInvoice.getTotalfreightamt()) : "", normalFont);
				pdfWordCell.addElement(totalFreightAmtValue);
				table.addCell(pdfWordCell);
				
				
				
				Phrase advanceLable = new Phrase("Advance", boldFont);
				pdfWordCell = new PdfPCell();
				pdfWordCell.addElement(advanceLable);
				table.addCell(pdfWordCell);
				
				pdfWordCell = new PdfPCell();
				Phrase advanceValue = new Phrase(vendorInvoice.getTotaladvance(), normalFont);
				pdfWordCell.addElement(advanceValue);
				table.addCell(pdfWordCell);
				
				

				Phrase discountLable = new Phrase("Discount", boldFont);
				pdfWordCell = new PdfPCell();
				pdfWordCell.addElement(discountLable);
				table.addCell(pdfWordCell);
				
				pdfWordCell = new PdfPCell();
				Phrase discountValue = new Phrase(vendorInvoice.getTotaldiscount(), normalFont);
				pdfWordCell.addElement(discountValue);
				table.addCell(pdfWordCell);
				
				
				
				Phrase breakageLable = new Phrase("Leakage/Breakage", boldFont);
				pdfWordCell = new PdfPCell();
				pdfWordCell.addElement(breakageLable);
				table.addCell(pdfWordCell);
				
				pdfWordCell = new PdfPCell();
				Phrase breakageValue = new Phrase(vendorInvoice.getLeakage(), normalFont);
				pdfWordCell.addElement(breakageValue);
				table.addCell(pdfWordCell);
				
				
				
				
				Phrase grantTotalLable = new Phrase("Grant Total", boldFont);
				pdfWordCell = new PdfPCell();
				pdfWordCell.addElement(grantTotalLable);
				table.addCell(pdfWordCell);
				
				pdfWordCell = new PdfPCell();
				Phrase amountValue = new Phrase(vendorInvoice.getAmount(), normalFont);
				pdfWordCell.addElement(amountValue);
				table.addCell(pdfWordCell);
				
				
				
				
				

				Phrase statusLable = new Phrase("Status", boldFont);
				pdfWordCell = new PdfPCell();
				pdfWordCell.addElement(statusLable);
				table.addCell(pdfWordCell);
				
				pdfWordCell = new PdfPCell();
				Phrase statusValue = new Phrase(vendorInvoice.getPaymentstatus(), normalFont);
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

}
