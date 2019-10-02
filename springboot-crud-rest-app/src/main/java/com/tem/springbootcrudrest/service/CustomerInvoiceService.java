package com.tem.springbootcrudrest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tem.springbootcrudrest.model.CustomerInvoice;

@Service
public interface CustomerInvoiceService {

	public CustomerInvoice createCustomerInvoice(CustomerInvoice customerinvoice);

	public CustomerInvoice updateCustomerInvoice(CustomerInvoice customerInvoice);

	public String deleteById(long custInvoiceId);

	public List<CustomerInvoice> getCustomerInvoiceList();
	
	public List<Object> findVendorandCustomerList();
}
