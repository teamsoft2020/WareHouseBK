package com.tem.springbootcrudrest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

}
