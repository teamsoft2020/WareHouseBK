package com.tem.springbootcrudrest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tem.springbootcrudrest.model.ManPower;
import com.tem.springbootcrudrest.model.ManPowerPaymentUpdateInManPowerInvoice;
import com.tem.springbootcrudrest.repository.ManPowerRepository;

@Component
public class ManPowerServiceImpl implements ManPowerService {

	@Autowired
	ManPowerRepository manPowerRepository;

	@Override
	public ManPower createManPower(ManPower manPower) {
		manPower.setStatus("Pending");

		return manPowerRepository.save(manPower);
	}

	@Override
	public List<ManPower> findCustomerByFromDateToDateCustNameFromManPower(String fromdate, String todate,
			String customername) {
		if (fromdate != null && todate != null && customername != null) {
			return manPowerRepository.findManPowerCustomerByFromDateToDateAndCustomerName(customername, fromdate,
					todate);
		} else if (fromdate != null && todate != null) {
			return manPowerRepository.findManPowerCustomerByFromDateToDate(fromdate, todate);
		} else {
			return manPowerRepository.findManPowerCustomerByCustomerName(customername);
		}
	}

	@Override
	public List<ManPower> findCustomerByFromDateToDateCustNameFromManPowerCompleteStatus(String fromdate, String todate,
			String customername) {
		if (fromdate != null && todate != null && customername != null) {
			return manPowerRepository.findManPowerCustomerByFromDateToDateAndCustomerNameCompletedStatus(customername, fromdate,
					todate);
		} else if (fromdate != null && todate != null) {
			return manPowerRepository.findManPowerCustomerByFromDateToDateCompletedStatus(fromdate, todate);
		} else {
			return manPowerRepository.findManPowerCustomerByCustomerNameCompletedStatus(customername);
		}
	}

	@Override
	public List<ManPower> updateCustPaymentFromCusPayment(
			ManPowerPaymentUpdateInManPowerInvoice manPowerPaymentUpdateInManPowerInvoice) {
		
		List<ManPower> vendorcustomerinvoice = new ArrayList<ManPower>();

		for (long invoiceid : manPowerPaymentUpdateInManPowerInvoice.getInvoiceid()) {

			ManPower manpower = manPowerRepository.findBymanpowerid(invoiceid);
			manpower.setCustomervendorpaymentid(manPowerPaymentUpdateInManPowerInvoice.getPaymentid());
			manpower.setStatus("Completed");
			ManPower manpowerinvoice = manPowerRepository.save(manpower);
			vendorcustomerinvoice.add(manpowerinvoice);

		}
		return vendorcustomerinvoice;
		
	}

}
