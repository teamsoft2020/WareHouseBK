package com.tem.springbootcrudrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tem.springbootcrudrest.model.Product;
import com.tem.springbootcrudrest.repository.ProductRepository;

@Component
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Product createProduct(Product product) {
		
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {

		return productRepository.save(product);
	}

	@Override
	public String deleteById(long productId) {
		productRepository.deleteById(productId);
		return "Deleted Product Successfully";
	}

	@Override
	public List<Product> getProuctList() {
		List<Product> productList = productRepository.findAll();
		
		return productList;
	}

}
