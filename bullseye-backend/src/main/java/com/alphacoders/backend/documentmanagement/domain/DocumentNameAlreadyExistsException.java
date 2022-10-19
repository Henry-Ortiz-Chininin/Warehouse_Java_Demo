package com.alphacoders.backend.documentmanagement.domain;

import com.alphacoders.backend.shared.domain.DomainError;

/**
 * @author Alphacoders.
 * @version v1.0
 * Error Class extend DomainError class.
 *
 */
public class DocumentNameAlreadyExistsException extends DomainError{

	/**
	 * Generates serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Error format for value repetition in the database.
	 * @param String name.
	 * @return an error message.
	 */
	public DocumentNameAlreadyExistsException(String name) {
		super("document_already_exists", String.format("The document <%s> already exists",  name));
	}

}
