package com.tem.springbootcrudrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tem.springbootcrudrest.model.CustomerInvoice;
import com.tem.springbootcrudrest.model.Customerpayment;
import com.tem.springbootcrudrest.model.VendorInvoice;
import com.tem.springbootcrudrest.model.Vendorpayment;
import com.tem.springbootcrudrest.repository.CustomerInvoiceRepository;
import com.tem.springbootcrudrest.repository.CustomerPaymentRepository;

@Component
public class CustomerPaymentServiceImpl implements CustomerPaymentService{
	
	@Autowired
	CustomerPaymentRepository customerPaymentRepository;
	
	@Autowired
	CustomerInvoiceRepository customerInvoiceRepository;

	@Override
	public List<Customerpayment> createCustomerPayment(List<Customerpayment> customerpaymentlist) {
		
		
		List<Customerpayment>customerpaymentresponse=customerPaymentRepository.saveAll(customerpaymentlist);
		
	/*	for(Customerpayment customerpayment:customerpaymentresponse) {
			CustomerInvoice customerinvoice = new CustomerInvoice();
			customerinvoice = customerInvoiceRepository.findByCustomerinvoiceid(customerpayment.getCustomerinvoiceid());
			
			customerinvoice.setPaymentstatus(customerpayment.getPaymentstatus());
			customerinvoice.setCustomerinvoiceid(customerpayment.getCustomerpaymentid());
			
			customerInvoiceRepository.save(customerinvoice);
			
		}*/
	
		return customerpaymentresponse;
		
	}

}
