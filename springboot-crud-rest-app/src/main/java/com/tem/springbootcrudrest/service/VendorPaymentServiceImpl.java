package com.tem.springbootcrudrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tem.springbootcrudrest.model.VendorPaymentParent;
import com.tem.springbootcrudrest.model.Vendorpayment;
import com.tem.springbootcrudrest.repository.VendorPaymentParentRepository;
import com.tem.springbootcrudrest.repository.VendorPaymentRepository;

@Component
public class VendorPaymentServiceImpl implements VendorPaymentService{
	
	@Autowired
	VendorPaymentParentRepository vendorPaymentParentRepository;
	
	@Autowired
	VendorPaymentRepository vendorPaymentRepository;

	@Override
	public VendorPaymentParent createVendorPayment(VendorPaymentParent vendorpaymentparent) {
		VendorPaymentParent vendoerpaymentesponse = vendorPaymentParentRepository.save(vendorpaymentparent);
		
		return vendoerpaymentesponse;
		
	}


	@Override
	public List<Vendorpayment> getVendorPaymentByStatusBalAmount() {
		
		return vendorPaymentRepository.findVendorPaymentByStatusBalAmount();
	}

}
