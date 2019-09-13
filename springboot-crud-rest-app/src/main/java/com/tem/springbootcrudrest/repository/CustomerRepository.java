package com.tem.springbootcrudrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tem.springbootcrudrest.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	
	@Query(value = "SELECT customername FROM Customer", nativeQuery = true)
	public List<String> getCustomersListByName();
}
