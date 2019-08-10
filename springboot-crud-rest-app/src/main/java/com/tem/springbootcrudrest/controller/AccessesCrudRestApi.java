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
import org.springframework.web.bind.annotation.RestController;

import com.tem.springbootcrudrest.model.Accesses;
import com.tem.springbootcrudrest.service.AccessesService;

@RestController
@RequestMapping("/api/v1")
public class AccessesCrudRestApi {

	@Autowired
	AccessesService accessesService;
	
	@PostMapping("/createaccesses")
	public Accesses createAccesses(@Valid @RequestBody Accesses accesses) {

		Accesses accessesresponse = accessesService.createAccesses(accesses);

		return accessesresponse;
	}

	@PutMapping("/accessestupdate")
	public Accesses updateAccesses(@Valid @RequestBody Accesses product) {
		Accesses accessesresponse = accessesService.updateAccesses(product);

		return accessesresponse;
	}

	

	@DeleteMapping("/accesses/{id}")
	public ResponseEntity<Map<String,String>> deleteAccesses(@PathVariable(value = "id") long accessesid) {
		String response = accessesService.deleteById(accessesid);
		
		Map<String,String>responsemap=new HashMap<String,String>();
		responsemap.put("status", response);

		return ResponseEntity.ok(responsemap);

	}

	@GetMapping("/accesseslist")
	public List<Accesses> getAccessesList() {
		List<Accesses> accessesList = accessesService.getAccessesList();
		return accessesList;
	}
}
