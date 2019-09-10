package com.tem.springbootcrudrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tem.springbootcrudrest.model.CustomerInvoice;

public interface CustomerInvoiceRepository extends JpaRepository<CustomerInvoice, Long>{

}
