package com.tem.springbootcrudrest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tem.springbootcrudrest.model.Product;

@Service
public interface ProductService {

	public Product createProduct(Product product);
	
	public Product updateProduct(Product product);
	
	public String deleteById(long productId);
	
	public List<Product> getProuctList();
	
}
