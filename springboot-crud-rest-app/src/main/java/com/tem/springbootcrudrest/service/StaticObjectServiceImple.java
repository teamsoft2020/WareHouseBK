package com.tem.springbootcrudrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tem.springbootcrudrest.model.State;
import com.tem.springbootcrudrest.repository.ManpowerInvoiceStaticFeildRepository;
import com.tem.springbootcrudrest.repository.StateRepository;
import com.tem.springbootcrudrest.repository.TruckRateRepository;
import com.tem.springbootcrudrest.staticdata.model.ManpowerInvoiceStaticFeild;
import com.tem.springbootcrudrest.staticdata.model.TruckRate;

@Component
public class StaticObjectServiceImple implements StaticObjectService{
	
	@Autowired
	ManpowerInvoiceStaticFeildRepository manpowerInvoiceStaticFeildRepository;
	
	@Autowired
	TruckRateRepository truckRateRepository;
	
	@Autowired
	StateRepository stateRepository;

	@Override
	public List<ManpowerInvoiceStaticFeild> findManpowerInvoiceStaticData() {
		
		return manpowerInvoiceStaticFeildRepository.findAll();
	}

	@Override
	public List<TruckRate> findTruckRateStaticData() {
		
		return truckRateRepository.findAll();
	}

	@Override
	public List<State> findStateStaticData() {
		
		return stateRepository.findAll();
	}
}
