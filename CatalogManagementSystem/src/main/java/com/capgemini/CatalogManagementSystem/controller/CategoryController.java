package com.capgemini.CatalogManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.CatalogManagementSystem.entity.Category;
import com.capgemini.CatalogManagementSystem.entity.Product;
import com.capgemini.CatalogManagementSystem.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping
	public Category createCategory(@RequestBody Category category) {
		return categoryService.createCategory(category);
	}

	@GetMapping
	public List<Category> getAllCategories() {
		return categoryService.getAllCategories();
	}

	@GetMapping("/{id}")
	public Category getCategoryById(@PathVariable int id) {
		return categoryService.getCategoryById(id);

	}

	@PutMapping("/{id}")
	public Category updateCategory(@PathVariable int id, @RequestBody Category category) {
		return categoryService.updateCategory(id, category);
	}

	@DeleteMapping("/{id}")
	public String deleteCategory(@PathVariable int id) {
		categoryService.deleteCategory(id);
		return "Category deleted successfully";

	}

	@GetMapping("/category/{categoryId}")
	public List<Product> getAllProductsByCategory(@PathVariable int categoryId) {
		return categoryService.getProductsByCategory(categoryId);
	}

}
