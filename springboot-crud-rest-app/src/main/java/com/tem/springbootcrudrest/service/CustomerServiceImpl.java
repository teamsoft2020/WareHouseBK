package com.tem.springbootcrudrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tem.springbootcrudrest.model.Customer;
import com.tem.springbootcrudrest.repository.CustomerRepository;

@Component
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

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
	public List<String> getListOfCombineName() {

		return customerRepository.getListOfCombineNames();
	}

	@Override
	public Object findCustomerVendorByName(String name) {
		//try {
			int customercount = customerRepository.findCustomerNamesCount(name);
			int vendorcount = customerRepository.findVendorNamesCount(name);
			
			
			if (customercount != 0) {
			return	customerRepository.findCustomerVendorByNames(name);
				
			}

			if (vendorcount != 0) {
			return	customerRepository.findCustomerVendorNames(name);
			}

		/*} catch (Exception ex) {
			System.out.println("exception handle");
		}*/

		return "Object Not Available";
	}

}
