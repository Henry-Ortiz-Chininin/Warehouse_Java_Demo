package com.alphacoders.backend.productmanagement.domain;

import com.alphacoders.backend.shared.domain.DomainError;

public class ProductNameAlreadyExistsException extends DomainError {

	
	private static final long serialVersionUID = 1L;

	public ProductNameAlreadyExistsException(String name){
		super("product_already_exists",String.format("The product <%s> already exists", name));
		
	}
}
