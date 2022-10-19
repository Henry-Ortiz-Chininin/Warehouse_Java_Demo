package com.alphacoders.backend.usermanagement.domain;

import org.springframework.data.repository.NoRepositoryBean;

import com.alphacoders.backend.usermanagement.dto.loginDTO;
import com.alphacoders.backend.usermanagement.dto.sessionDTO;

@NoRepositoryBean
public interface IUserAuthentication {
	sessionDTO getLogin(loginDTO login);
}
