package com.alphacoders.backend.usermanagement.domain;

public final class UserDomain {

	private Long ID;
	private String Name;
	private String UserName;
	private String Password;
	private String UserType;
	
	public UserDomain(Long ID, String Name, String UserName, String Password, String UserType) {
		this.ID=ID;
		this.Name = Name;
		this.UserName = UserName;
		this.Password = Password;
		this.UserType=UserType;		
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getUserType() {
		return UserType;
	}

	public void setUserType(String userType) {
		UserType = userType;
	}
	


}
