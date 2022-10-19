package com.alphacoders.backend.usermanagement.api;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alphacoders.backend.dto.ResultDTO;
import com.alphacoders.backend.usermanagement.domain.IUserAuthentication;
import com.alphacoders.backend.usermanagement.dto.loginDTO;

/**
 * Controller to manage User's Login  
 */
@RestController
@CrossOrigin
@RequestMapping("/api/v1/auth")
public class AuthController {
	
	
	@Autowired
	private IUserAuthentication repository;
	
	
	@PostMapping("login")
	public ResultDTO Login(@RequestBody loginDTO login) {
		ResultDTO result = new ResultDTO();
		
		try {
			result.Data= repository.getLogin(login);
			result.Status="OK";
		}catch(Exception ex) {
			result.Status="EX";
			result.Error=ex;
		}
		
		return result;
	}
	
}
