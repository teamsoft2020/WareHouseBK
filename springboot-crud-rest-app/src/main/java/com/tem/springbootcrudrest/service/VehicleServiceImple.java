package com.tem.springbootcrudrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tem.springbootcrudrest.model.Vehicle;
import com.tem.springbootcrudrest.repository.VehicleRepository;

@Component
public class VehicleServiceImple implements VehicleService{

	@Autowired
	VehicleRepository vehicleRepository;
	
	@Override
	public Vehicle createVehicle(Vehicle vehicle) {
		
		return vehicleRepository.save(vehicle);
		
	}

	@Override
	public Vehicle updateVehicle(Vehicle vehicle) {
		
		return vehicleRepository.save(vehicle);
	}

	@Override
	public String deleteById(long vehicleId) {
		
		vehicleRepository.deleteById(vehicleId);
		
		return "Deleted Vehicle Successfully";
	}

	@Override
	public List<Vehicle> getVehicleList() {

		List<Vehicle> listVehicle = vehicleRepository.findAll();
		return  listVehicle;
	}

}
