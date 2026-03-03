package com.capgemini.CatalogManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.CatalogManagementSystem.entity.Category;
import com.capgemini.CatalogManagementSystem.entity.Product;
import com.capgemini.CatalogManagementSystem.exception.CategoryNotFoundException;
import com.capgemini.CatalogManagementSystem.exception.ProductNotFoundException;
import com.capgemini.CatalogManagementSystem.repository.CategoryRepository;
import com.capgemini.CatalogManagementSystem.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Product createProduct(Product product, int categoryId) {

		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + categoryId));
		product.setCategory(category);

		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(int id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));

	}

	@Override
	public Product updateProduct(int id, Product product) {
		Product existingProduct = getProductById(id);
		if (existingProduct != null) {
			existingProduct.setProductName(product.getProductName());
			return productRepository.save(existingProduct);

		} else {
			throw new ProductNotFoundException("Product Not Found!");
		}
	}

	@Override
	public String deleteProduct(int id) {
		Product product = getProductById(id);
		if (product != null) {
			productRepository.delete(product);
			return "Product Deleted Successfully!";
		} else {
			throw new ProductNotFoundException("Product Not Found With Id: " + id);
		}
	}

	@Override
	public List<Product> getProductsByCategory(int categoryId) {
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + categoryId));

		return productRepository.findByCategory(category);
	}

	@Override
	public List<Product> searchProductByName(String name) {
		return productRepository.findByProductName(name);
	}

}
