package com.tem.springbootcrudrest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tem.springbootcrudrest.model.Customerpayment;

@Service
public interface CustomerPaymentService {
	
	public List<Customerpayment> createCustomerPayment(List<Customerpayment> customerpayment);

}
