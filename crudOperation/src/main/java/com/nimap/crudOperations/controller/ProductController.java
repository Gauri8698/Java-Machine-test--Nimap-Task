package com.nimap.crudOperations.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.nimap.crudOperations.entity.Product;
import com.nimap.crudOperations.repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	
	@GetMapping
	public Object getProducts(
	    @RequestParam(required = false, defaultValue = "0") Integer page) {
	    
	    int defaultPageSize = 10;

	    Pageable pageable = PageRequest.of(page, defaultPageSize);
	    return productRepository.findAll(pageable);
	} 
	
	//localhost:8080/api/products
    @PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public List<Product> createProducts(@RequestBody List<Product> product) {
        return productRepository.saveAll(product);
	}
	
	//localhost:8080/api/products/1
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable int id) {
		Product product = productRepository.findById(id).orElseThrow(()->new RuntimeException("product not found"));
		return product;
	}
	//localhost:8080/api/products/1
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable int id , @RequestBody Product productDetails) {
		Product product = productRepository.findById(id).get();
		product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setQuantity(productDetails.getQuantity());
        product.setStatus(productDetails.getStatus());
		productRepository.save(product);
		return product;
		
	}
	//localhost:8080/api/products/1
	@DeleteMapping("/{id}")
	public void removeProduct(@PathVariable int id) {
		productRepository.deleteById(id);
	}
	

}
