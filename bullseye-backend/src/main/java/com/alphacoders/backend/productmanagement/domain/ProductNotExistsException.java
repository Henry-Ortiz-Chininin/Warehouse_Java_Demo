package com.alphacoders.backend.productmanagement.domain;

import com.alphacoders.backend.shared.domain.DomainError;

public class ProductNotExistsException extends DomainError{
	
	private static final long serialVersionUID = 1L;

	public ProductNotExistsException(String name) {
		super("product_not_exists",String.format("The product <%s> not exists", name));
	}


}
