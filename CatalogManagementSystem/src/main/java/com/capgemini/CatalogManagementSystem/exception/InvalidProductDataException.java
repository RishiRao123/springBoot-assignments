package com.capgemini.CatalogManagementSystem.exception;

public class InvalidProductDataException extends IllegalArgumentException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidProductDataException(String message) {
		super(message);
	}

}
