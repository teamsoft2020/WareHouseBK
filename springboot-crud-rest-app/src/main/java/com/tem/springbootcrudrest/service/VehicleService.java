package com.tem.springbootcrudrest.service;

import java.util.List;

import com.tem.springbootcrudrest.model.Vehicle;

public interface VehicleService {

	public Vehicle createVehicle(Vehicle vehicle);
	
	public Vehicle updateVehicle(Vehicle vehicle);
	
	public String deleteById(long vehicleId);
	
	public List<Vehicle> getVehicleList();
}
