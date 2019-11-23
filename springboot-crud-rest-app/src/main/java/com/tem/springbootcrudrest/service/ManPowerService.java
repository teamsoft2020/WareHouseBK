package com.tem.springbootcrudrest.service;

import org.springframework.stereotype.Service;

import com.tem.springbootcrudrest.model.ManPower;

@Service
public interface ManPowerService {

	ManPower createManPower(ManPower manPower);
}
