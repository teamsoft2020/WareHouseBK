package com.tem.springbootcrudrest.controller;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tem.springbootcrudrest.model.CustomerInvoice;
import com.tem.springbootcrudrest.model.CustomerPaymentUpdateInCustomerInvoice;
import com.tem.springbootcrudrest.model.ManPower;
import com.tem.springbootcrudrest.model.VendorInvoice;
import com.tem.springbootcrudrest.service.CustomerInvoiceService;
import com.tem.util.UTCDateTime;

@RestController
@RequestMapping("/api/v1")
public class CustomerInvoiceCrudRestApi {
	
	@Autowired
	CustomerInvoiceService customerInvoiceService;
	
	
	@PostMapping("/createcustomerinvoice")
	public CustomerInvoice createCustomerInvoice(@Valid @RequestBody CustomerInvoice customerInvoice) {
		
		String datetime = UTCDateTime.getCurentTimeAndDate();
		
		customerInvoice.setCreateddate(datetime);

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
	
	@RequestMapping(path = "/invoicelistincustomer", method = RequestMethod.GET)
	public List<CustomerInvoice> getVendorInvoiceList(@RequestParam String fromdate, @RequestParam String todate,
			@RequestParam String customername) {

		List<CustomerInvoice> customerList = customerInvoiceService.getCustomerInvoiceLists(fromdate, todate, customername);

		return customerList;
	}
	
	/*@PutMapping("/updatecustomerinvoicepayments")
	public List<CustomerInvoice> updateCustomerPayment(@RequestBody List<CustomerInvoice> customerInvoice) {

		List<CustomerInvoice> customerInvoiceresponse = customerInvoiceService.updateCustomerPayment(customerInvoice);
		

		return customerInvoiceresponse;

	}*/
	
	
	@PutMapping("/updatecustomerpaymentid")
	public List<CustomerInvoice> updateCustomerPaymentFromCusPayment(@RequestBody CustomerPaymentUpdateInCustomerInvoice custpaymentupdateobj) {

		List<CustomerInvoice> customerPaymentUpdateInCustomerInvoice = customerInvoiceService.updateCustPaymentFromCusPayment(custpaymentupdateobj);
		

		return customerPaymentUpdateInCustomerInvoice;

	}
	
	@PostMapping("/generatepdfforcustomerinvoicecalculated")
	public ResponseEntity<Map<String, String>> generatePdfForCustomerInvoiceCalculated(@RequestBody List<CustomerInvoice> pdfCustomerInvoice) throws FileNotFoundException {

		String response = customerInvoiceService.generatePdfForCustomerInvoiceCalculated(pdfCustomerInvoice);
		
		Map<String, String> responsemap = new HashMap<String, String>();
		responsemap.put("status", response);

		return ResponseEntity.ok(responsemap);

	}
	
	@RequestMapping(path = "/customerinvoicebydatename", method = RequestMethod.GET)
	public List<CustomerInvoice> findCustomerInvoiceByCustdatename(@RequestParam(required = false) String fromdate, @RequestParam(required = false) String todate,@RequestParam(required = false) String customername) {

		List<CustomerInvoice> manpower = customerInvoiceService.findCustomerInvoiceByCustdatename(fromdate, todate,customername);

		return manpower;
	}
	
	/*
	public ResponseEntity<Map<String, String>> updateVendorInvoice(
			@PathVariable(value = "vindorinvoiceid") long vindorinvoiceid) {

		String response = vendorInvoiceService.updateVendorInvoice(vindorinvoiceid);

		Map<String, String> responsemap = new HashMap<String, String>();
		responsemap.put("status", response);

		return ResponseEntity.ok(responsemap);

	}*/


}
