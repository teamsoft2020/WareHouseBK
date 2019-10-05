package com.tem.springbootcrudrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tem.springbootcrudrest.model.TripSheet;
import com.tem.springbootcrudrest.model.VendorInvoice;
import com.tem.springbootcrudrest.repository.VendorInvoiceRepository;

@Component
public class VendorInvoiceServiceImpl implements VendorInvoiceService {

	@Autowired
	VendorInvoiceRepository vendorInvoiceRepository;

	@Override
	public VendorInvoice createVendorInvoice(VendorInvoice vendorInvoice) {
		vendorInvoice.setPaymentstatus("Pending");
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
		return null;
	}

	@Override
	public List<VendorInvoice> getVendorInvoiceLists(String fromdate, String todate, String vendorname) {
		return vendorInvoiceRepository.findInvoiceBetweenDateList(fromdate, todate, vendorname);
	}

}
