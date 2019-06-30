package com.tem.springbootcrudrest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tem.springbootcrudrest.model.Vendor;
import com.tem.springbootcrudrest.repository.VendorRepository;

@RestController
@RequestMapping("/api/v2")
public class VendorCrudRestApi {

	@Autowired
	VendorRepository vendorRepository;

	@PostMapping("/createvendor")
	public Vendor createUser(@Valid @RequestBody Vendor vendor) {

		Vendor vendorresponse = vendorRepository.save(vendor);
		return vendorresponse;
	}

	@GetMapping("/vendorlist")
	public List<Vendor> getAllCustomers() {
		List<Vendor> vendorList = vendorRepository.findAll();
		return vendorList;
	}

	@PutMapping("/vendorrupdate")
	public Vendor updateCustomer(@Valid @RequestBody Vendor vendor) {
		Vendor vendorresponse = vendorRepository.save(vendor);

		return vendorresponse;
	}
	

	@DeleteMapping("/vendor/{id}")
	public String deleteVendor(@PathVariable(value = "id") Long vendorId) {
		vendorRepository.deleteById(vendorId);
		
		return "deleteSuccessfuly";
		
	}

}
