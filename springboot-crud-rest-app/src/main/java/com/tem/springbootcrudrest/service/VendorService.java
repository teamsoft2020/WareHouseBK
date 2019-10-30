package com.tem.springbootcrudrest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tem.springbootcrudrest.model.Vendor;

@Service
public interface VendorService {

	public Vendor createVendor(Vendor vendor);

	public Vendor updateVendor(Vendor vendor);

	public String deleteById(long vendorId);

	public List<Vendor> getVendorList();
	
	public List<String> getVendorListByName();
	
	public List<Vendor> findVendorByName(String name);
}
