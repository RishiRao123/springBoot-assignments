package com.capgemini.CatalogManagementSystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.CatalogManagementSystem.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
