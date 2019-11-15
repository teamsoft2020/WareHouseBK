package com.tem.springbootcrudrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tem.springbootcrudrest.service.StaticObjectService;
import com.tem.springbootcrudrest.staticdata.model.ManpowerInvoiceStaticFeild;
import com.tem.springbootcrudrest.staticdata.model.TruckRate;

@RestController
@RequestMapping("/api/v1")
public class StaticObjectCrudRestApi {
	
	@Autowired
	StaticObjectService staticObjectService;
	
	@GetMapping("/manpowerinvoicestaticfeild")
	public List<ManpowerInvoiceStaticFeild> findManpowerInvoiceStaticData() {
		List<ManpowerInvoiceStaticFeild> manpowerInvoiceStaticFeildList = staticObjectService.findManpowerInvoiceStaticData();
		return manpowerInvoiceStaticFeildList;
	}
	
	
	@GetMapping("/truckratestaticdata")
	public List<TruckRate> findTruckRateStaticData() {
		List<TruckRate> findTruckRateData = staticObjectService.findTruckRateStaticData();
		
		return findTruckRateData;
	}

}
