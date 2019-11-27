package com.tem.springbootcrudrest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

		CustomerPaymentParent customerPaymentresponse = customerPaymentService
				.createCustomerPayment(customerpaymentlist);

		return customerPaymentresponse;
	}

	@RequestMapping(path = "/customerpaymentbystatusamount", method = RequestMethod.GET)
	public List<Customerpayment> getCustomerPaymentByStatusBalAmnt() {

		List<Customerpayment> customerList = customerPaymentService.getCustomerPaymentByStatusBalAmount();

		return customerList;
	}

	@RequestMapping(path = "/customerpaymentbystatus", method = RequestMethod.GET)
	public List<Customerpayment> getCustomerPaymentByStatus() {

		List<Customerpayment> customerList = customerPaymentService.getCustomerPaymentByStatus();

		return customerList;
	}
	
	@PutMapping("/updatecustomerpaymentchild")
	public List<Customerpayment> updateCustomerPaymentChild(@RequestBody List<Customerpayment> customerpaymentchild) {

		List<Customerpayment> customerPaymentchild = customerPaymentService.updateCustomerPayment(customerpaymentchild);
		

		return customerPaymentchild;

	}
	
	@RequestMapping(path = "/findcustomer/{name}", method = RequestMethod.GET)
	public List<Customerpayment> getCustomerListByName(@PathVariable(value = "name") String name) {

		List<Customerpayment> customerList = customerPaymentService.getCustomerListByName(name);

		return customerList;
	}
	
	
	@RequestMapping(path = "/customerchequelist", method = RequestMethod.GET)
	public List<Customerpayment> getCustomerChecqueManagement() {

		List<Customerpayment> customerList = customerPaymentService.getCustomerChequeManagementList();

		return customerList;
	}
	
	
	@PutMapping("/updatecutomercheques")
	public List<Customerpayment> updateCustomerChequeManagement(@RequestBody List<Customerpayment> customerpaymentchild) {

		List<Customerpayment> customerPaymentchild = customerPaymentService.updateCustomerChequeManagement(customerpaymentchild);
		

		return customerPaymentchild;

	}
	
	//create manpowerpayment on customer and vendor payment table
	
	@PostMapping("/createmanpowerpayment")
	public ResponseEntity<Map<String, Long>> createManpowerPayment(@RequestBody CustomerPaymentParent customerpaymentlist) {

		String datetime = UTCDateTime.getCurentTimeAndDate();

		customerpaymentlist.setCreateddate(datetime);

		long customerPaymentresponse = customerPaymentService
				.createManpowerPayment(customerpaymentlist);
		
		Map<String, Long> responsemap = new HashMap<String, Long>();
		responsemap.put("status", customerPaymentresponse);

		return ResponseEntity.ok(responsemap);
	}
	
	

}
