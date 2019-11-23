package com.tem.springbootcrudrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tem.springbootcrudrest.model.ManPower;
import com.tem.springbootcrudrest.repository.ManPowerRepository;

@Component
public class ManPowerServiceImpl implements ManPowerService {

	@Autowired
	ManPowerRepository manPowerRepository;

	@Override
	public ManPower createManPower(ManPower manPower) {

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

}
