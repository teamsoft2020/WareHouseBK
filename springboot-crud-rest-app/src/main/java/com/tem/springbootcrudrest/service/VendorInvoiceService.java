package com.tem.springbootcrudrest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tem.springbootcrudrest.model.VendorInvoice;
import com.tem.springbootcrudrest.model.VendorPaymentUpdateInCustomerInvoice;

@Service
public interface VendorInvoiceService {

	public VendorInvoice createVendorInvoice(VendorInvoice vendorInvoice);

	public String updateVendorInvoice(long vindorinvoiceid);

	public String deleteById(long vendorId);

	public List<VendorInvoice> getVendorInvoiceList();
	
	public List<VendorInvoice> getVendorInvoiceLists(String fromdate,String todate,String vendorname);
	
	public List<VendorInvoice> updateVendorPayment(List<VendorInvoice> vendorInvoice);
	
	public List<VendorInvoice> updateVendPaymentFromCusPayment(VendorPaymentUpdateInCustomerInvoice vendorPaymentUpdateInCustomerInvoice);
	
	
}
