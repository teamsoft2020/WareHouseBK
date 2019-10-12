package com.tem.springbootcrudrest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tem.springbootcrudrest.model.Vendorpayment;

@Service
public interface VendorPaymentService {

	public List<Vendorpayment> createVendorPayment(List<Vendorpayment> vendorpaymentlist);
}
