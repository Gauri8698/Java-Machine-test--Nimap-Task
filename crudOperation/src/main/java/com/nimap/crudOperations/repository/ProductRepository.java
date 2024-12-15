package com.nimap.crudOperations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimap.crudOperations.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
