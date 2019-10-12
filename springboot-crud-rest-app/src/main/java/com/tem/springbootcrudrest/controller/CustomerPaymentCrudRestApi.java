package com.tem.springbootcrudrest.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tem.springbootcrudrest.model.Customerpayment;
import com.tem.springbootcrudrest.service.CustomerPaymentService;
import com.tem.util.UTCDateTime;

@RestController
@RequestMapping("/api/v1")
public class CustomerPaymentCrudRestApi {

	@Autowired
	CustomerPaymentService customerPaymentService;
	
	
	@PostMapping("/createcustomerpayment")
	public List<Customerpayment> createCustomerPayment(@RequestBody List<Customerpayment> customerpaymentlist) {
		
		String datetime = UTCDateTime.getCurentTimeAndDate();
		
		for(Customerpayment customerpayment:customerpaymentlist) {
		customerpayment.setCreateddate(datetime);
		
		}

		List<Customerpayment> customerPaymentresponse = customerPaymentService.createCustomerPayment(customerpaymentlist);
		
		return customerPaymentresponse;
	}
	
}
