package com.tem.springbootcrudrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tem.springbootcrudrest.model.VendorPaymentParent;

import com.tem.springbootcrudrest.repository.VendorPaymentParentRepository;

@Component
public class VendorPaymentServiceImpl implements VendorPaymentService{
	
	@Autowired
	VendorPaymentParentRepository vendorPaymentParentRepository;
	

	@Override
	public VendorPaymentParent createVendorPayment(VendorPaymentParent vendorpaymentparent) {
		VendorPaymentParent vendoerpaymentesponse = vendorPaymentParentRepository.save(vendorpaymentparent);
		
		return vendoerpaymentesponse;
		
	}

}
