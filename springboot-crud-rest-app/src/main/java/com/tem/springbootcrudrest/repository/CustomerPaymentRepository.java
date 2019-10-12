package com.tem.springbootcrudrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tem.springbootcrudrest.model.Customerpayment;

public interface CustomerPaymentRepository extends JpaRepository<Customerpayment, Long> {

}
