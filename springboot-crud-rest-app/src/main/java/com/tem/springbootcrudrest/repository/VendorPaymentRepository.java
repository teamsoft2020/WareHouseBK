package com.tem.springbootcrudrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tem.springbootcrudrest.model.Vendorpayment;


@Repository
public interface VendorPaymentRepository extends JpaRepository<Vendorpayment, Long>{

}
