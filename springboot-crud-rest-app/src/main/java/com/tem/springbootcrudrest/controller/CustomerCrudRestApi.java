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

import com.tem.springbootcrudrest.model.Customer;
import com.tem.springbootcrudrest.service.CustomerService;

@RestController
@RequestMapping("/api/v1")
public class CustomerCrudRestApi {

	@Autowired
	CustomerService customerService;
	
	
	
	@PostMapping("/createcustomer")
	public Customer createCustomer(@Valid @RequestBody Customer customer) {

		Customer customerresponse = customerService.createCustomer(customer);

		return customerresponse;
	}

	@PutMapping("/customerupdate")
	public Customer updateCustomer(@Valid @RequestBody Customer customer) {
		Customer customerresponse = customerService.updateCustomer(customer);

		return customerresponse;
	}

	

	@DeleteMapping("/customer/{id}")
	public ResponseEntity<Map<String,String>> deleteCustomer(@PathVariable(value = "id") Long customerId) {
		String response = customerService.deleteById(customerId);
		
		Map<String,String>responsemap=new HashMap<String,String>();
		responsemap.put("status", response);

		return ResponseEntity.ok(responsemap);

	}


	@GetMapping("/customerlist")
	public List<Customer> getCustomerList() {
		List<Customer> customerList = customerService.getCustomerList();
		return customerList;
	}
	
}
