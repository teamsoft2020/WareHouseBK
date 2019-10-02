package com.tem.springbootcrudrest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/listcustomerinvoice")
	public List<CustomerInvoice> findCustomerInvoiceList() {
		List<CustomerInvoice> customerInvoiceList = customerInvoiceService.getCustomerInvoiceList();
		return customerInvoiceList;
	}
	
	@GetMapping("/vendorandcustomerlist")
	public List<Object> findVendorandCustomerList(){
		
		List<Object> customerInvoiceList = customerInvoiceService.findVendorandCustomerList();
		return customerInvoiceList;
	}

}
