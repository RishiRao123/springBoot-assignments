package com.capgemini.CatalogManagementSystem.service;

import java.util.List;


import com.capgemini.CatalogManagementSystem.entity.Product;

public interface ProductService {
	Product createProduct(Product product,int categoryId);
	
	List<Product> getAllProducts();
	
	Product getProductById(int id);
	
	Product updateProduct(int id,Product product);
	
	String deleteProduct(int id);
	
	List<Product> getProductsByCategory(int categoryId);
	
	List<Product> searchProductByName(String name);
}
