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
	public ResponseEntity<String> deleteCustomer(@PathVariable(value = "id") Long customerId) {
		String response = customerService.deleteById(customerId);

		return ResponseEntity.ok(response);

	}


	@GetMapping("/customerlist")
	public List<Customer> getCustomerList() {
		List<Customer> customerList = customerService.getCustomerList();
		return customerList;
	}
	
}
