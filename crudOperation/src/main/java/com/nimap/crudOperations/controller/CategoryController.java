package com.nimap.crudOperations.controller;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.crudOperations.entity.Category;
import com.nimap.crudOperations.repository.CategoryRepostory;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	CategoryRepostory repository;

	@GetMapping
	public Object getCategories(
	    @RequestParam(required = false, defaultValue = "0") Integer page) {
	    
	    int defaultPageSize = 10;

	    Pageable pageable = PageRequest.of(page, defaultPageSize);
	    return repository.findAll(pageable);
	}
	
	//localhost:8080/api/categories
		@PostMapping
		@ResponseStatus(code = HttpStatus.CREATED)
		public List<Category> createCategories(@RequestBody List<Category>  categories) {
			return repository.saveAll(categories);
		}
	
	//localhost:8080/api/categories/1
	@GetMapping("/{id}")
	public Category getCategory(@PathVariable int id) {
	Category category = repository.findById(id).get();
		return category;
	}
	
	//localhost:8080/categories/1
	@PutMapping("/{id}")
	public Category updateCategory(@PathVariable int id ,@RequestBody Category categoryDetails) {
		Category category = repository.findById(id).get();
		category.setName(categoryDetails.getName());
        category.setDescription(categoryDetails.getDescription());
        return repository.save(category);
	}
	
	//localhost:8080/categories/1
	@DeleteMapping("/{id}")
	public void removeCategory(@PathVariable int id) {
		repository.deleteById(id);
	}
}
