package com.tem.springbootcrudrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tem.springbootcrudrest.model.Customer;
import com.tem.springbootcrudrest.model.CustomerInvoice;
import com.tem.springbootcrudrest.repository.CustomerInvoiceRepository;

@Component
public class CustomerInvoiceServiceImpl implements CustomerInvoiceService{

	@Autowired
	CustomerInvoiceRepository customerInvoiceRepository;
	
	@Override
	public CustomerInvoice createCustomerInvoice(CustomerInvoice customerinvoice) {
		customerinvoice.setPaymentstatus("NO");
		
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

}
