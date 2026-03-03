package com.capgemini.CatalogManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.CatalogManagementSystem.entity.Category;
import com.capgemini.CatalogManagementSystem.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	public List<Product> findByCategory(Category category);

	public List<Product> findByProductName(String productName);


}
