package com.tem.springbootcrudrest.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tem.springbootcrudrest.model.ManPower;
import com.tem.springbootcrudrest.model.TripSheet;
import com.tem.springbootcrudrest.service.ManPowerService;

@RestController
@RequestMapping("/api/v1")
public class ManPowerCrudRestApi {

	@Autowired
	ManPowerService manPowerService;
	
	@PostMapping("/manpowercreate")
	public ManPower createCustomer(@RequestBody ManPower manPower) {

		ManPower manPowerResponse = manPowerService.createManPower(manPower);

		return manPowerResponse;
	}
	
	@RequestMapping(path = "/listcustomerbydatename", method = RequestMethod.GET)
	public List<ManPower> findCustomerByFromDateToDateCustNameFromManPower(@RequestParam(required = false) String fromdate, @RequestParam(required = false) String todate,@RequestParam(required = false) String customername) {

		List<ManPower> tripSheetList = manPowerService.findCustomerByFromDateToDateCustNameFromManPower(fromdate, todate,customername);

		return tripSheetList;
	}
	
	
	@RequestMapping(path = "/listcustomerbydatenamecompletestatus", method = RequestMethod.GET)
	public List<ManPower> findCustomerByFromDateToDateCustNameFromManPowerCompleteStatus(@RequestParam(required = false) String fromdate, @RequestParam(required = false) String todate,@RequestParam(required = false) String customername) {

		List<ManPower> tripSheetList = manPowerService.findCustomerByFromDateToDateCustNameFromManPowerCompleteStatus(fromdate, todate,customername);

		return tripSheetList;
	}

	
}
