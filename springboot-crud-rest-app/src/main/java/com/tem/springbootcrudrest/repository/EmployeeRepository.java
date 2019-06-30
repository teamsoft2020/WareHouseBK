package com.tem.springbootcrudrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tem.springbootcrudrest.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
