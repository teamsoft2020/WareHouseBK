package com.tem.springbootcrudrest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tem.springbootcrudrest.model.Vehicle;
import com.tem.springbootcrudrest.service.VehicleService;

@RestController
@RequestMapping("/api/v1")
public class VehicleCrudRestApi {

	@Autowired
	VehicleService vehicleService;
	
	@PostMapping("/createvehicle")
	public Vehicle createVehicle(@Valid @RequestBody Vehicle vehicle) {

		Vehicle vehicleresponse = vehicleService.createVehicle(vehicle);

		return vehicleresponse;
	}

	@PutMapping("/vehicleupdate")
	public Vehicle updateVehicle(@Valid @RequestBody Vehicle vehicle) {
		Vehicle vehicleresponse = vehicleService.updateVehicle(vehicle);

		return vehicleresponse;
	}

	

	@DeleteMapping("/vehicle/{id}")
	public ResponseEntity<String> deleteVehicle(@PathVariable(value = "id") long vehicleId) {
		String response = vehicleService.deleteById(vehicleId);

		return ResponseEntity.ok(response);

	}

	@GetMapping("/vehiclelist")
	public List<Vehicle> getVehicleList() {
		List<Vehicle> vehicleList = vehicleService.getVehicleList();
		return vehicleList;
	}
}
