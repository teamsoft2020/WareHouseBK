package com.tem.springbootcrudrest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tem.springbootcrudrest.model.Employee;

@Service
public interface EmployeeService {

	public Employee createEmployee(Employee employee);
	
	public Employee updateCustomer(Employee employee);
	
	public String deleteById(long empid);
	
	public List<Employee>getEmployeeList();
	
}
