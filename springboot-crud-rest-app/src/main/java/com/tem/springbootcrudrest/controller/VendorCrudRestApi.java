package com.tem.springbootcrudrest.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.tem.springbootcrudrest.model.Vehicle;
import com.tem.springbootcrudrest.model.Vendor;
import com.tem.springbootcrudrest.service.VendorService;
import com.tem.util.UTCDateTime;

@RestController
@RequestMapping("/api/v1")
public class VendorCrudRestApi {

	@Autowired
	VendorService vendorService;

	@PostMapping("/createvendor")
	public Vendor createUser(@Valid @RequestBody Vendor vendor) {
		String datetime = UTCDateTime.getCurentTimeAndDate();
		vendor.setCreatedDate(datetime);
		
		for(Vehicle vehicle:vendor.getVendorvehicle()) {
			vehicle.setCreatedDate(datetime);
		}
		
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
	

	@GetMapping("/vendorlistbyname")
	public List<String> getVendorListByName() {
		List<String> vendorList = vendorService.getVendorListByName();
		return vendorList;
	}

	@DeleteMapping("/vendor/{id}")
	public ResponseEntity<Map<String,String>> deleteVendor(@PathVariable(value = "id") Long vendorId) {
		String response=vendorService.deleteById(vendorId);

		Map<String,String>responsemap=new HashMap<String,String>();
		responsemap.put("status", response);
		
		return ResponseEntity.ok(responsemap);

	}

}
