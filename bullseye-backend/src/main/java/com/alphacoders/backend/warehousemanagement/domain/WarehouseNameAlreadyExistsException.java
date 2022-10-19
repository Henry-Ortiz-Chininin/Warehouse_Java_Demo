package com.alphacoders.backend.warehousemanagement.domain;

import com.alphacoders.backend.shared.domain.DomainError;



/**
 * @author Alphacoders
 * @version v1.0
 * Error Class extends DomainError class.
 */
public class WarehouseNameAlreadyExistsException extends DomainError{
	
	/**
	 * Generates serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Error format for value repetition in the database.
	 * @param String name.
	 * @return an error message.
	 */
	public WarehouseNameAlreadyExistsException(String name){
		super("warehouse_already_exists",String.format("The warehouse <%s> already exists", name));
		
	}

}
