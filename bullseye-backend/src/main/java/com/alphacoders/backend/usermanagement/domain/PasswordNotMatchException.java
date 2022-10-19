package com.alphacoders.backend.usermanagement.domain;

import com.alphacoders.backend.shared.domain.DomainError;

public class PasswordNotMatchException extends DomainError {

	private static final long serialVersionUID = 1L;

	public PasswordNotMatchException() {
		super("user_password_not_match","The user password not match.");
	}

}
