package com.alphacoders.backend.usermanagement.domain;

import com.alphacoders.backend.shared.domain.DomainError;

public class UserMatchListException extends DomainError {

	/**
	 * @exception UserMatchListException  
	 */
	private static final long serialVersionUID = 1L;

	public UserMatchListException(String userName) {
		super("user_match_list",String.format("The user <%s> match too many", userName));
	}

}
