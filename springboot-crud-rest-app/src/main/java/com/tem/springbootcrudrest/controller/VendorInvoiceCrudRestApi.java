package com.tem.springbootcrudrest.controller;

import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.tem.springbootcrudrest.model.CustomerVendorInvoiceNo;
import com.tem.springbootcrudrest.model.TripSheet;
import com.tem.springbootcrudrest.model.VendorInvoice;
import com.tem.springbootcrudrest.model.VendorPaymentUpdateInCustomerInvoice;
import com.tem.springbootcrudrest.service.VendorInvoiceService;
import com.tem.util.UTCDateTime;

@RestController
@RequestMapping("/api/v1")
public class VendorInvoiceCrudRestApi {

	@Autowired
	VendorInvoiceService vendorInvoiceService;

	@PostMapping("/createvendorinvoice")
	public VendorInvoice createVendorInvoice(@Valid @RequestBody VendorInvoice vendorInvoice) {

		String datetime = UTCDateTime.getCurentTimeAndDate();
		vendorInvoice.setCreateddate(datetime);
		VendorInvoice vendorInvoiceresponse = vendorInvoiceService.createVendorInvoice(vendorInvoice);
		return vendorInvoiceresponse;
	}

	@DeleteMapping("/vendorinvoiceupdate/{vindorinvoiceid}")
	public ResponseEntity<Map<String, String>> updateVendorInvoice(
			@PathVariable(value = "vindorinvoiceid") long vindorinvoiceid) {

		String response = vendorInvoiceService.updateVendorInvoice(vindorinvoiceid);

		Map<String, String> responsemap = new HashMap<String, String>();
		responsemap.put("status", response);

		return ResponseEntity.ok(responsemap);

	}
	
	@GetMapping("/listvendorinvoice")
	public List<VendorInvoice> findVendorInvoiceList() {
		List<VendorInvoice> vendorInvoiceList = vendorInvoiceService.getVendorInvoiceList();
		return vendorInvoiceList;
	}
	
	@RequestMapping(path = "/vendorinvoicelistinvendor", method = RequestMethod.GET)

	public List<VendorInvoice> getVendorInvoiceList(@RequestParam String fromdate, @RequestParam String todate,
			@RequestParam String vendorname) {

		List<VendorInvoice> tripSheetList = vendorInvoiceService.getVendorInvoiceLists(fromdate, todate, vendorname);

		return tripSheetList;
	}
	
	/*@PutMapping("/updatevendorinvoicepayments")
	public List<VendorInvoice> updateVendorPayment(@RequestBody List<VendorInvoice> vendorInvoice) {

		List<VendorInvoice> vendorInvoiceresponse = vendorInvoiceService.updateVendorPayment(vendorInvoice);
		

		return vendorInvoiceresponse;

	}*/
	
	@PutMapping("/updatevendorpaymentid")
	public List<VendorInvoice> updateVendorPaymentFromCusPayment(@RequestBody VendorPaymentUpdateInCustomerInvoice vendpaymentupdateobj) {

		List<VendorInvoice> vendorPaymentUpdateInCustomerInvoice = vendorInvoiceService.updateVendPaymentFromCusPayment(vendpaymentupdateobj);
		

		return vendorPaymentUpdateInCustomerInvoice;

	}
	
	
	@PostMapping("/generatepdfforvendorinvoicecalculated")
	public ResponseEntity<Map<String, String>> generatePdfForCustomerInvoiceCalculated(@RequestBody List<VendorInvoice> pdfVendorInvoice) throws FileNotFoundException {

		String response = vendorInvoiceService.generatePdfForVendorInvoiceCalculated(pdfVendorInvoice);
		
		Map<String, String> responsemap = new HashMap<String, String>();
		responsemap.put("status", response);

		return ResponseEntity.ok(responsemap);

	}
	

}
