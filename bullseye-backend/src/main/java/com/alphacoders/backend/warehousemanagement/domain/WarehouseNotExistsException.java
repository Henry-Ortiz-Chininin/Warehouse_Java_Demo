package com.alphacoders.backend.warehousemanagement.domain;

import com.alphacoders.backend.shared.domain.DomainError;

/**
 * @author Alphacoders
 * @version v1.0
 * Error Class extends DomainError class.
 */

public class WarehouseNotExistsException extends DomainError {

	/**
	 * Generats serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Error format for value non existent in the database.
	 * @param String name.
	 * @return an error message.
	 */
	public WarehouseNotExistsException(String name) {
		super("warehouse_not_found", String.format("The warehouse <%s> already exists", name));
	}

}
