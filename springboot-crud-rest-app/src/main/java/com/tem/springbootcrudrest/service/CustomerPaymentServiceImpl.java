package com.tem.springbootcrudrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tem.springbootcrudrest.model.CustomerInvoice;
import com.tem.springbootcrudrest.model.CustomerPaymentParent;
import com.tem.springbootcrudrest.model.Customerpayment;
import com.tem.springbootcrudrest.model.VendorInvoice;
import com.tem.springbootcrudrest.model.Vendorpayment;
import com.tem.springbootcrudrest.repository.CustomerInvoiceRepository;
import com.tem.springbootcrudrest.repository.CustomerPaymentParentRepository;
import com.tem.springbootcrudrest.repository.CustomerPaymentRepository;

@Component
public class CustomerPaymentServiceImpl implements CustomerPaymentService{
	
	
	@Autowired
	CustomerPaymentParentRepository customerPaymentParentRepository;
	

	@Override
	public CustomerPaymentParent createCustomerPayment(CustomerPaymentParent customerpaymentlist) {
		
		
		CustomerPaymentParent customerpaymentresponse=customerPaymentParentRepository.save(customerpaymentlist);
		
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
