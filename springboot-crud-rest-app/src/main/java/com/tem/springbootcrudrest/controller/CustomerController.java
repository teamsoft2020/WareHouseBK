/*package com.tem.springbootcrudrest.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.tem.springbootcrudrest.exception.ResourceNotFoundException;
import com.tem.springbootcrudrest.model.Customer;
import com.tem.springbootcrudrest.model.CustomerDetails;
import com.tem.springbootcrudrest.repository.CustomerDetailsRepository;
import com.tem.springbootcrudrest.repository.CustomerRepository;


@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	CustomerDetailsRepository customerDetailsRepository;
	
	@GetMapping("/createcustomer")
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@GetMapping("/customers/{customerId}")
	public ResponseEntity<Customer> getUserById(
			@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
		Customer user = customerRepository.findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("User not found :: " + userId));
		return ResponseEntity.ok().body(user);
	}

	@PostMapping("/customers")
	public Customer createUser(@Valid @RequestBody Customer customer) {
		
		Customer customerresponse=	customerRepository.save(customer);

		
		return customerresponse;
	}
	
	@PutMapping("/customerupdate")
	public Customer updateCustomer(@Valid @RequestBody Customer customer){
Customer customerresponse=	customerRepository.save(customer);
		
		
		return customerresponse;
	}

	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateUser(
			@PathVariable(value = "id") Long userId,
			@Valid @RequestBody Customer userDetails) throws ResourceNotFoundException {
		Customer user = customerRepository.findById(userId)
		        .orElseThrow(() -> new ResourceNotFoundException("User not found :: " + userId));
		
		
		final Customer updatedUser = customerRepository.save(user);
		return ResponseEntity.ok(updatedUser);
	}
	
	@DeleteMapping("/customer/{id}")
	public String deleteCustomer(@PathVariable(value = "id") Long userId) {
		customerRepository.deleteById(userId);
		
		return "deleteSuccessfuly";
		
	}

	@DeleteMapping("/customers/{id}")
	public Map<String, Boolean> deleteUser(
			@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
		Customer user = customerRepository.findById(userId)
		        .orElseThrow(() -> new ResourceNotFoundException("User not found :: " + userId));

		customerRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@GetMapping("/customerlist")
	public List<Customer>getCustomers(){
		List<Customer>customerList = customerRepository.findAll();
		return customerList;
	}
	
}
*/