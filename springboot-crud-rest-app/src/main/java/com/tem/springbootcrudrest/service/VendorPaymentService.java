package com.tem.springbootcrudrest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tem.springbootcrudrest.model.VendorPaymentParent;
import com.tem.springbootcrudrest.model.Vendorpayment;

@Service
public interface VendorPaymentService {

	public VendorPaymentParent createVendorPayment(VendorPaymentParent vendorPaymentParent);
	
	public List<Vendorpayment> getVendorPaymentByStatusBalAmount();
	
	public List<Vendorpayment> getVendorPaymentByStatus();
	
	public List<Vendorpayment> updateVendorPaymentChild(List<Vendorpayment> vendorPaymentChild);
	
	public List<Vendorpayment> getVendorListByName(String name);
	
	public List<Vendorpayment> getVendorChequeList();
	
	public List<Vendorpayment> updateVendorCheque(List<Vendorpayment> vendorChequeList);
}
