package com.tem.springbootcrudrest.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tem.springbootcrudrest.model.CustomerInvoice;
import com.tem.springbootcrudrest.model.CustomerPaymentParent;
import com.tem.springbootcrudrest.model.Customerpayment;
import com.tem.springbootcrudrest.service.CustomerPaymentService;
import com.tem.util.UTCDateTime;

@RestController
@RequestMapping("/api/v1")
public class CustomerPaymentCrudRestApi {

	@Autowired
	CustomerPaymentService customerPaymentService;
	
	
	@PostMapping("/createcustomerpayment")
	public CustomerPaymentParent createCustomerPayment(@RequestBody CustomerPaymentParent customerpaymentlist) {
		
		String datetime = UTCDateTime.getCurentTimeAndDate();
		
		customerpaymentlist.setCreateddate(datetime);
		
		CustomerPaymentParent customerPaymentresponse = customerPaymentService.createCustomerPayment(customerpaymentlist);
		
		return customerPaymentresponse;
	}
	
	@RequestMapping(path = "/customerpaymentbystatusamount", method = RequestMethod.GET)
	public List<Customerpayment> getCustomerPaymentByStatusBalAmnt() {

		List<Customerpayment> customerList = customerPaymentService.getCustomerPaymentByStatusBalAmount();

		return customerList;
	}
	
}
