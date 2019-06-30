package com.tem.springbootcrudrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tem.springbootcrudrest.model.VendorAddress;

@Repository
public interface VendorAddressRepository extends JpaRepository<VendorAddress, Long>{

}
