package com.capgemini.CatalogManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.CatalogManagementSystem.entity.Category;
import com.capgemini.CatalogManagementSystem.entity.Product;
import com.capgemini.CatalogManagementSystem.exception.CategoryNotFoundException;
import com.capgemini.CatalogManagementSystem.repository.CategoryRepository;
import com.capgemini.CatalogManagementSystem.repository.ProductRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Category getCategoryById(int id) {
		return categoryRepository.findById(id)
				.orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + id));
	}

	@Override
	public Category updateCategory(int id, Category category) {
		Category existing = categoryRepository.findById(id).orElse(null);
		if (existing != null) {
			existing.setCategoryName(category.getCategoryName());
			return categoryRepository.save(existing);
		}
		return null;
	}

	@Override
	public String deleteCategory(int id) {
		categoryRepository.deleteById(id);
		return "Category deleted successfully";
	}
	
	@Override
	public List<Product> getProductsByCategory(Integer categoryId) {

	    Category category = categoryRepository.findById(categoryId)
	            .orElseThrow(() -> new CategoryNotFoundException(
	                    "Category not found with id: " + categoryId));

	    return productRepository.findByCategory(category);
	}
}