package com.alphacoders.backend.usermanagement.domain;

import com.alphacoders.backend.shared.domain.DomainError;

public class UserNameAlreadyExistsException  extends DomainError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNameAlreadyExistsException(String userName){
		super("user_already_exists",String.format("The user <%s> already exists", userName));
		
	}

}
