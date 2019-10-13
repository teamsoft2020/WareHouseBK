package com.tem.springbootcrudrest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tem.springbootcrudrest.model.CustomerPaymentParent;
import com.tem.springbootcrudrest.model.Customerpayment;

@Service
public interface CustomerPaymentService {
	
	public CustomerPaymentParent createCustomerPayment(CustomerPaymentParent customerpayment);
	
	public List<Customerpayment> getCustomerPaymentByStatusBalAmount();

}
