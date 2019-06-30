package com.tem.springbootcrudrest.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.tem.springbootcrudrest.model.Vendor;
import com.tem.springbootcrudrest.service.VendorService;

@RestController
@RequestMapping("/api/v1")
public class VendorCrudRestApi {

	@Autowired
	VendorService vendorService;

	@PostMapping("/createvendor")
	public Vendor createUser(@Valid @RequestBody Vendor vendor) {

		Vendor vendorresponse = vendorService.createVendor(vendor);
		return vendorresponse;
	}

	@GetMapping("/vendorlist")
	public List<Vendor> getAllCustomers() {
		List<Vendor> vendorList = vendorService.getVendorList();
		return vendorList;
	}

	@PutMapping("/vendorrupdate")
	public Vendor updateCustomer(@Valid @RequestBody Vendor vendor) {
		Vendor vendorresponse = vendorService.updateVendor(vendor);

		return vendorresponse;
	}

	@DeleteMapping("/vendor/{id}")
	public ResponseEntity<String> deleteVendor(@PathVariable(value = "id") Long vendorId) {
		String response=vendorService.deleteById(vendorId);

		return ResponseEntity.ok(response);

	}

}
