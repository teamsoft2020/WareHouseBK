package com.tem.springbootcrudrest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tem.springbootcrudrest.model.Customer;
import com.tem.springbootcrudrest.model.TripSheet;
import com.tem.springbootcrudrest.service.CustomerService;
import com.tem.springbootcrudrest.service.TripSheetService;

@RestController
@RequestMapping("/api/v1")
public class TripSheetCrudRestApi {
	

	@Autowired
	TripSheetService tripSheetService;

	
	@PostMapping("/createtripsheet")
	public TripSheet createCustomer(@Valid @RequestBody TripSheet tripSheet) {

		TripSheet tripSheetResponse = tripSheetService.createTripSheet(tripSheet);

		return tripSheetResponse;
	}

	@PutMapping("/updatetripsheet")
	public TripSheet updateCustomer(@Valid @RequestBody TripSheet tripSheet) {
		TripSheet tripSheetresponse = tripSheetService.updateTripSheet(tripSheet);

		return tripSheetresponse;
	}

	

	/*@DeleteMapping("/tripsheet/{id}")
	public ResponseEntity<Map<String,String>> deleteCustomer(@PathVariable(value = "id") Long tripId) {
		String response = tripSheetService.deleteById(tripId);
		
		Map<String,String>responsemap=new HashMap<String,String>();
		responsemap.put("status", response);

		return ResponseEntity.ok(responsemap);

	}
*/

	

	@DeleteMapping("/tripsheet/{tripid}")
	public ResponseEntity<Map<String,String>> deleteCustomer(@PathVariable(value = "tripid") long tripid) {
		String response = tripSheetService.updateTripSheetStatus(tripid);
		
		Map<String,String>responsemap=new HashMap<String,String>();
		responsemap.put("status", response);

		return ResponseEntity.ok(responsemap);

	}

	
	
	@GetMapping("/triplist")
	public List<TripSheet> getCustomerList() {
		List<TripSheet> tripSheetList = tripSheetService.getTripSheetList();
		
		
		return tripSheetList;
	}

}
