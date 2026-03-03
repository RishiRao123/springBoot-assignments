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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.CatalogManagementSystem.entity.Product;
import com.capgemini.CatalogManagementSystem.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping
	public Product createProduct(@RequestBody Product product,@RequestParam int categoryId) {
		return productService.createProduct(product,categoryId);
	}

	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/{id}")
	public Product getProductById(@PathVariable int id) {
		return productService.getProductById(id);
	}

	@PutMapping("{id}")
	public Product updateProduct(@PathVariable int id, Product product) {
		return productService.updateProduct(id, product);
	}

	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable int id) {
		return productService.deleteProduct(id);
	}

	@GetMapping("/category/{categoryId}")
	public List<Product> getProductsByCategory(@PathVariable int categoryId) {
		return productService.getProductsByCategory(categoryId);
	}

	@GetMapping("/search")
	public List<Product> searchProductByName(@RequestParam String name) {
		return productService.searchProductByName(name);
	}

}
