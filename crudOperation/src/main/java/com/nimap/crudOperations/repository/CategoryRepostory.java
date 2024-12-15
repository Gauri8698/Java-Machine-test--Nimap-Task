package com.nimap.crudOperations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimap.crudOperations.entity.Category;

public interface CategoryRepostory extends JpaRepository<Category, Integer> {

}
