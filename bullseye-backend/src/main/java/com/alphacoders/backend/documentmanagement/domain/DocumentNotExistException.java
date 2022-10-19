package com.alphacoders.backend.documentmanagement.domain;

import com.alphacoders.backend.shared.domain.DomainError;

/**
 * @author Alphacoders
 * @version v1.0
 * Error Class extends DomainError class.
 */
public class DocumentNotExistException extends DomainError{

	/**
	 * Generates serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Error format for value repetition in the database.
	 * @param String name.
	 * @return an error message.
	 */
	public DocumentNotExistException(String name) {
		super("warehouse_not_exists", String.format("The warehouse <%s> does not exists", name));
	}

}
