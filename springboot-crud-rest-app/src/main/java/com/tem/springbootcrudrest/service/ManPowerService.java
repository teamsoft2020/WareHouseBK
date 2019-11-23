package com.tem.springbootcrudrest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tem.springbootcrudrest.model.ManPower;
import com.tem.springbootcrudrest.model.ManPowerPaymentUpdateInManPowerInvoice;

@Service
public interface ManPowerService {

	ManPower createManPower(ManPower manPower);
	
	List<ManPower> findCustomerByFromDateToDateCustNameFromManPower(String fromdate, String todate,String customername);
	
	List<ManPower> findCustomerByFromDateToDateCustNameFromManPowerCompleteStatus(String fromdate, String todate,String customername);
	
	List<ManPower> updateCustPaymentFromCusPayment(ManPowerPaymentUpdateInManPowerInvoice manPowerPaymentUpdateInManPowerInvoice);
}
