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

import com.tem.springbootcrudrest.model.Employee;
import com.tem.springbootcrudrest.model.Product;
import com.tem.springbootcrudrest.service.ProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductCrudRestApi {

	@Autowired
	ProductService productService;
	
	@PostMapping("/createproduct")
	public Product createProduct(@Valid @RequestBody Product product) {

		Product productresponse = productService.createProduct(product);

		return productresponse;
	}

	@PutMapping("/productupdate")
	public Product updateProduct(@Valid @RequestBody Product product) {
		Product productresponse = productService.updateProduct(product);

		return productresponse;
	}

	

	@DeleteMapping("/product/{id}")
	public ResponseEntity<Map<String,String>> deleteProduct(@PathVariable(value = "id") long empId) {
		String response = productService.deleteById(empId);
		
		Map<String,String>responsemap=new HashMap<String,String>();
		responsemap.put("status", response);

		return ResponseEntity.ok(responsemap);

	}

	@GetMapping("/productlist")
	public List<Product> getProductList() {
		List<Product> productList = productService.getProuctList();
		return productList;
	}
}
