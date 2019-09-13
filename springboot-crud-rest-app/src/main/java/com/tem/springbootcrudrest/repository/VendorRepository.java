package com.tem.springbootcrudrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tem.springbootcrudrest.model.Vendor;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long>{

	@Query(value = "SELECT vendorname FROM Vendor", nativeQuery = true)
	public List<String> getVendorListByNames();
}
