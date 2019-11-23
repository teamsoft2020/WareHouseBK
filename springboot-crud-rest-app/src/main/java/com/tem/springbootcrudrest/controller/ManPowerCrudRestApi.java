package com.tem.springbootcrudrest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tem.springbootcrudrest.model.ManPower;
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

	
}
