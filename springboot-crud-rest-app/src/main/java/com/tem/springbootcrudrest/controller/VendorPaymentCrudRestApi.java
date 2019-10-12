package com.tem.springbootcrudrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tem.springbootcrudrest.model.Customerpayment;
import com.tem.springbootcrudrest.model.Vendorpayment;
import com.tem.springbootcrudrest.service.CustomerPaymentService;
import com.tem.springbootcrudrest.service.VendorPaymentService;
import com.tem.util.UTCDateTime;

@RestController
@RequestMapping("/api/v1")
public class VendorPaymentCrudRestApi {

	@Autowired
	VendorPaymentService vendorPaymentService;
	
	
	@PostMapping("/createvendorpayment")
	public List<Vendorpayment> createVendorPayment(@RequestBody List<Vendorpayment> vendorpaymentlist) {
		
		String datetime = UTCDateTime.getCurentTimeAndDate();
		
		for(Vendorpayment vendorpayment:vendorpaymentlist) {
			vendorpayment.setCreateddate(datetime);
		
		}

		List<Vendorpayment> vendorPaymentresponse = vendorPaymentService.createVendorPayment(vendorpaymentlist);
		
		return vendorPaymentresponse;
	}
}
