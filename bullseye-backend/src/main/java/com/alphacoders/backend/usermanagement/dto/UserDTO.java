package com.alphacoders.backend.usermanagement.dto;

/**
 * Data transfer object 
 * */
public class UserDTO {
	public Long id;
	public String name;
	public String lastName;
	public String email;
	public String userName;
	public String password;
	public String type;



	public UserDTO(Long id, String name, String lastName, String email, String userName, String password, String type) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.type = type;
	}



	public UserDTO() {
		super();
	}
	

}
