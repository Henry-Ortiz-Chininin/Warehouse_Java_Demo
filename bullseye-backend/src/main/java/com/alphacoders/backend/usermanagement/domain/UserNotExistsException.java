package com.alphacoders.backend.usermanagement.domain;

import com.alphacoders.backend.shared.domain.DomainError;

public  class UserNotExistsException  extends DomainError{

	/**
	 * User not exists Exception
	 */
	private static final long serialVersionUID = 1L;

	public UserNotExistsException(String userName) {
		super("user_not_exists",String.format("The user <%s> not exists", userName));
	}

}
