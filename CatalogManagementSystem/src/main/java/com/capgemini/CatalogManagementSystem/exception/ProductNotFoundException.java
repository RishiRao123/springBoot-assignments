package com.capgemini.CatalogManagementSystem.exception;

public class ProductNotFoundException extends RuntimeException {
	
	public ProductNotFoundException(String message) {
		super(message);
	}

}
