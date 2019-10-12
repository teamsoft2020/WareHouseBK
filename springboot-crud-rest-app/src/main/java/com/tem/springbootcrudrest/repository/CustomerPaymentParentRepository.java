package com.tem.springbootcrudrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tem.springbootcrudrest.model.CustomerPaymentParent;

@Repository
public interface CustomerPaymentParentRepository extends JpaRepository<CustomerPaymentParent, Long>{

}
