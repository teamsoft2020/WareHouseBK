package com.tem.springbootcrudrest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tem.springbootcrudrest.staticdata.model.ManpowerInvoiceStaticFeild;
import com.tem.springbootcrudrest.staticdata.model.TruckRate;

@Service
public interface StaticObjectService {

	public List<ManpowerInvoiceStaticFeild> findManpowerInvoiceStaticData();
	
	public List<TruckRate> findTruckRateStaticData();
	
}
