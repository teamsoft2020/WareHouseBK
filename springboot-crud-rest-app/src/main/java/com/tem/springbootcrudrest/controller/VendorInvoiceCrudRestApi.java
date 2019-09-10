package com.tem.springbootcrudrest.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tem.springbootcrudrest.model.VendorInvoice;
import com.tem.springbootcrudrest.service.VendorInvoiceService;

@RestController
@RequestMapping("/api/v1")
public class VendorInvoiceCrudRestApi {
	
	@Autowired
	VendorInvoiceService vendorInvoiceService;
	
	@PostMapping("/createvendorinvoice")
	public VendorInvoice createVendorInvoice(@Valid @RequestBody VendorInvoice vendorInvoice) {

		VendorInvoice vendorInvoiceresponse = vendorInvoiceService.createVendorInvoice(vendorInvoice);
		return vendorInvoiceresponse;
	}

	@DeleteMapping("/vendorinvoiceupdate/{vindorinvoiceid}")
	public ResponseEntity<Map<String,String>> updateVendorInvoice(@PathVariable(value = "vindorinvoiceid") long vindorinvoiceid) {
		System.out.println("welcome...");

		String response = vendorInvoiceService.updateVendorInvoice(vindorinvoiceid);
		
		System.out.println("welcome...");
		Map<String,String>responsemap=new HashMap<String,String>();
		responsemap.put("status", response);

		return ResponseEntity.ok(responsemap);

	}

}
