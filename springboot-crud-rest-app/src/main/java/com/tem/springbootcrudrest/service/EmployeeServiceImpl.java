package com.tem.springbootcrudrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tem.springbootcrudrest.model.Employee;
import com.tem.springbootcrudrest.repository.EmployeeRepository;

@Component
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee createEmployee(Employee employee) {

		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateCustomer(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public String deleteById(long empid) {

		employeeRepository.deleteById(empid);
		
		return "Employee Deleted Successfully";
	}

	@Override
	public List<Employee> getEmployeeList() {

		List<Employee> employeeList = employeeRepository.findAll();
		return employeeList;
	}

}
