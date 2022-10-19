package com.alphacoders.backend.usermanagement.dto;

public class sessionDTO {

	public String sessionID;
	public String UserName;
	
	public sessionDTO(String UserName) {
		this.UserName=UserName;
	}
}
