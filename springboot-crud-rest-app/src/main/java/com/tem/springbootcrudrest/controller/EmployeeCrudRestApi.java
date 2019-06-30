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

import com.tem.springbootcrudrest.model.Employee;
import com.tem.springbootcrudrest.service.EmployeeService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeCrudRestApi {

	@Autowired
	EmployeeService employeeService;
	
	
	
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {

		Employee employeeresponse = employeeService.createEmployee(employee);

		return employeeresponse;
	}

	@PutMapping("/employeeupdate")
	public Employee updateCustomer(@Valid @RequestBody Employee employee) {
		Employee employeeresponse = employeeService.updateCustomer(employee);

		return employeeresponse;
	}

	

	@DeleteMapping("/employee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable(value = "id") Long empId) {
		String response = employeeService.deleteById(empId);

		return ResponseEntity.ok(response);

	}


	@GetMapping("/employeelist")
	public List<Employee> getEmployeeList() {
		List<Employee> employeeList = employeeService.getEmployeeList();
		return employeeList;
	}
}
