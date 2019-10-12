package com.tem.springbootcrudrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tem.springbootcrudrest.model.VendorInvoice;
import com.tem.springbootcrudrest.model.Vendorpayment;
import com.tem.springbootcrudrest.repository.VendorInvoiceRepository;
import com.tem.springbootcrudrest.repository.VendorPaymentRepository;

@Component
public class VendorPaymentServiceImpl implements VendorPaymentService{
	
	@Autowired
	VendorPaymentRepository vendorPaymentRepository;
	
	//findByVendorinvoiceid
	@Autowired
	VendorInvoiceRepository vendorInvoiceRepository;
	
	

	@Override
	public List<Vendorpayment> createVendorPayment(List<Vendorpayment> vendorpaymentlist) {
		List<Vendorpayment> vendoerpaymentesponse = vendorPaymentRepository.saveAll(vendorpaymentlist);
		
	/*	for(Vendorpayment vendorpayment:vendoerpaymentesponse) {
			VendorInvoice vendorInvoice = new VendorInvoice();
			vendorInvoice = vendorInvoiceRepository.findByVendorinvoiceid(vendorpayment.getVendorinvoiceid());
			
			vendorInvoice.setPaymentstatus(vendorpayment.getPaymentstatus());
			vendorInvoice.setVendorinvoiceid(vendorpayment.getVendorinvoiceid());
			
			vendorInvoiceRepository.save(vendorInvoice);
			
		}*/
		
		
		return vendoerpaymentesponse;
	}

}
