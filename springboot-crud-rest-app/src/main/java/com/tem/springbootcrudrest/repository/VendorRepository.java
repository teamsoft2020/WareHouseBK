package com.tem.springbootcrudrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tem.springbootcrudrest.model.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long>{

}
