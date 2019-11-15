package com.tem.springbootcrudrest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tem.springbootcrudrest.model.Customer;
import com.tem.springbootcrudrest.repository.CustomerRepository;
import com.tem.springbootcrudrest.repository.VendorRepository;

@Component
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	VendorRepository vendorRepository;

	@Override
	public Customer createCustomer(Customer customer) {

		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public String deleteById(long customerId) {
		customerRepository.deleteById(customerId);
		return "Customer Deleted Successfully";
	}

	@Override
	public List<Customer> getCustomerList() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public List<String> getCustomerListByName() {

		return customerRepository.getCustomersListByName();
	}

	@Override
	public List<Object> getListOfCombineName() {

		List<Object> allobjects = new ArrayList<Object>();
		
		try {

		List<String>commonnamelist =	customerRepository.getListOfCombineNames();
			
		
		for(String commanname : commonnamelist) {
			List<Object> customervendorobject=null;
			customervendorobject = customerRepository.findCustomerByNameObject(commanname);
			Customer customer =null;
			for(Object obj : customervendorobject) {
				 customer = (Customer) obj;
			}
			
			
			if(customer==null) {
				customervendorobject = vendorRepository.findVendorNameObject(commanname);
				
			}
			allobjects.addAll(customervendorobject);
		}
			
		} catch (NullPointerException e) {

		}
		return allobjects;
		
		
		
	}

	@Override
	public List<Customer> findCustomerByName(String name) {
		
			
		
			return	customerRepository.findCustomerByNames(name);
				
	}

}
