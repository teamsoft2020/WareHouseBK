package com.tem.springbootcrudrest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	public ResponseEntity<Map<String,String>> deleteVehicle(@PathVariable(value = "id") long vehicleId) {
		String response = vehicleService.deleteById(vehicleId);
		
		Map<String,String>responsemap=new HashMap<String,String>();
		responsemap.put("status", response);

		return ResponseEntity.ok(responsemap);

	}

	@GetMapping("/vehiclelist")
	@CrossOrigin(origins = { "http://localhost", "http://localhost:8080", "http://localhost:4200/", "*" })
	public List<Vehicle> getVehicleList() {
		List<Vehicle> vehicleList = vehicleService.getVehicleList();
		return vehicleList;
	}
}
