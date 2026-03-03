package com.capgemini.CatalogManagementSystem.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CategoryNotFoundException.class)
    public String handleCategoryNotFound(CategoryNotFoundException ex) {
    	return ex.getMessage();
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public String handleProductNotFound(ProductNotFoundException ex) {
    	return ex.getMessage();
    }

    @ExceptionHandler(InvalidProductDataException.class)
    public String handleInvalidProduct(InvalidProductDataException ex) {
    	return ex.getMessage();
    }

    @ExceptionHandler(Exception.class)
    public String handleGenericException(Exception ex) {
    	return ex.getMessage();

    }
}