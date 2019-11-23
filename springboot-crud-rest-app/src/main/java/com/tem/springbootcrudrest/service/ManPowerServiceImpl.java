package com.tem.springbootcrudrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tem.springbootcrudrest.model.ManPower;
import com.tem.springbootcrudrest.repository.ManPowerRepository;

@Component
public class ManPowerServiceImpl implements ManPowerService{

	@Autowired
	ManPowerRepository manPowerRepository;
	
	@Override
	public ManPower createManPower(ManPower manPower) {
		
		return manPowerRepository.save(manPower);
	}

}
