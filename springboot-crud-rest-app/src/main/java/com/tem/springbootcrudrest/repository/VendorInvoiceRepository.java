package com.tem.springbootcrudrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tem.springbootcrudrest.model.VendorInvoice;

@Repository
public interface VendorInvoiceRepository extends JpaRepository<VendorInvoice, Long>{

}
