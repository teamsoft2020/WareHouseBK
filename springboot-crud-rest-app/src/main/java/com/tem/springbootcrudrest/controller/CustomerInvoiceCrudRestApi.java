package com.tem.springbootcrudrest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tem.springbootcrudrest.model.CustomerInvoice;
import com.tem.springbootcrudrest.service.CustomerInvoiceService;

@RestController
@RequestMapping("/api/v1")
public class CustomerInvoiceCrudRestApi {
	
	@Autowired
	CustomerInvoiceService customerInvoiceService;
	
	@PostMapping("/createcustomerinvoice")
	public CustomerInvoice createCustomerInvoice(@Valid @RequestBody CustomerInvoice customerInvoice) {

		CustomerInvoice customerInvoiceresponse = customerInvoiceService.createCustomerInvoice(customerInvoice);
		return customerInvoiceresponse;
	}

}
