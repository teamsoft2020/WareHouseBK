package com.tem.springbootcrudrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tem.springbootcrudrest.model.Customerpayment;
import com.tem.springbootcrudrest.model.VendorPaymentParent;
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
	public VendorPaymentParent createVendorPayment(@RequestBody VendorPaymentParent vendorPaymentParent) {

		String datetime = UTCDateTime.getCurentTimeAndDate();

		vendorPaymentParent.setCreateddate(datetime);

		VendorPaymentParent vendorPaymentParentresponse = vendorPaymentService.createVendorPayment(vendorPaymentParent);

		return vendorPaymentParentresponse;
	}

	@RequestMapping(path = "/vendorpaymentbystatusamount", method = RequestMethod.GET)
	public List<Vendorpayment> getVendorPaymentByStatusBalAmnt() {

		List<Vendorpayment> customerList = vendorPaymentService.getVendorPaymentByStatusBalAmount();

		return customerList;
	}

	@RequestMapping(path = "/vendorpaymentbystatus", method = RequestMethod.GET)
	public List<Vendorpayment> getVendorPaymentByStatus() {

		List<Vendorpayment> customerList = vendorPaymentService.getVendorPaymentByStatus();

		return customerList;
	}
}
