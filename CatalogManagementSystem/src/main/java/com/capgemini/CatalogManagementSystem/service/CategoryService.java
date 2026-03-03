package com.capgemini.CatalogManagementSystem.service;

import java.util.List;

import com.capgemini.CatalogManagementSystem.entity.Category;
import com.capgemini.CatalogManagementSystem.entity.Product;


public interface CategoryService {

	Category createCategory(Category category);
	
	List<Category> getAllCategories();
	
	Category getCategoryById(int id);
	
	Category updateCategory(int id,Category category);
	
	String deleteCategory(int id);
	
	List<Product> getProductsByCategory(Integer categoryId);

}
