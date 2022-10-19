package com.alphacoders.backend.usermanagement.domain;

import java.util.ArrayList;
import java.util.List;

import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alphacoders.backend.exception.ResourceNotFoundException;
import com.alphacoders.backend.model.Admin;
import com.alphacoders.backend.model.Employee;

import com.alphacoders.backend.model.User;
import com.alphacoders.backend.productmanagement.dto.ProductDTO;
import com.alphacoders.backend.repository.UserRepository;
import com.alphacoders.backend.usermanagement.dto.*;


/**
 * Contains the services that will be used for manipulation of Users
 * @param UserDTO is a type of USER can be  ADMIN or EMPLOYEE
 * @param ID which is the User ID
 * */


@Service
public class UserDomainService implements IUserManagement, IUserAuthentication {

	@Autowired
	private UserRepository userRepository;
	
	public UserDomainService() {
		
	}

	public sessionDTO getLogin(loginDTO login) {
		List<User> users = userRepository.findAll();
		users = users.stream().filter(e->Objects.equals(e.getUserName(), login.userName)).collect(Collectors.toList());
		
		if(users.isEmpty()) {
			throw new UserNotExistsException(login.userName);
		}

		if(users.size()>1) {
			throw new UserMatchListException(login.userName);
		}

		User loggedUser = users.get(0);
		if(!loggedUser.getPassword().equals(login.password)) {
			throw new PasswordNotMatchException();
		}

		return new sessionDTO(loggedUser.getName());
	}

	/**
	 * To Get  a list of All users 
	 * @return List<User>  is a List  of all  users
	 * */
	public List<UserDTO> findAll(){
		List<UserDTO> user = new ArrayList<UserDTO>();

		userRepository.findAll().forEach(usr -> user.add(new UserDTO(usr.getId(), usr.getName(),
				usr.getLastName(), usr.getEmail(),usr.getUserName(),usr.getPassword(), usr.getType())));

		return user;
	}
	
	
	/**
	 * To Create new user  
	 * @param UserDTO is a type of USER can be  ADMIN or EMPLOYEE
	 * @return UserDTO is a type of USER can be  ADMIN or EMPLOYEE
	 *  @exception UserNameAlreadyExistsExceptio - Return information if the User Already Exist
	 * */
	public UserDTO createUser(UserDTO user) {

		List<User> users = userRepository.findAll();
		users = users.stream().filter(e->Objects.equals(e.getUserName(), user.userName)).collect(Collectors.toList());
		
		if(!users.isEmpty()) {
			throw new UserNameAlreadyExistsException(user.userName);
		}
		
		if (user.type.equals("EMPLOYEE")) {
			Employee emp = new Employee(user.name,user.lastName,user.email,user.userName,user.password);
			userRepository.save(emp);
		
		}
		if (user.type.equals("ADMIN")) {
			Admin adm = new Admin(user.name,user.lastName,user.email,user.userName,user.password);
			userRepository.save(adm);
		
		}
		
		users = userRepository.findAll().stream().filter
				(e->Objects.equals(e.getUserName(), user.userName))
				.collect(Collectors.toList());
		User loggedUser = users.get(0);
				
		return user;
	}
	
	/**
	 * To Update a User  
	 * @param ID
	 * @param UserDTO is a type of USER can be  ADMIN or EMPLOYEE
	 * @return UserDTO is a type of USER can be  ADMIN or EMPLOYEE
	 * @exception UserNotExistsException - Return information if the User Not Exist
	 * */
	public UserDTO updateUser(Long id, UserDTO userDetails) {
		User user = userRepository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("no found")); 

				if (user == null) {
					throw new UserNotExistsException(userDetails.name +" no found");
				} else {
					
					//user.setId(userDetails.id);
					user.setName(userDetails.name);
					user.setLastName(userDetails.lastName);
					user.setEmail(userDetails.email);
					user.setPassword(userDetails.password);
					user.setUserName(userDetails.userName);
					userRepository.save(user);
				}


			return userDetails;

	}
	
	/**
	 * To Return a User  
	 * @param ID
	 * @return UserDTO is a type of USER can be  ADMIN or EMPLOYEE
	 * @exception ResourceNotFoundException - Return information if the User Not Found
	 * */
	public UserDTO getUserById(Long id){
		
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("no found")); 
		
		UserDTO userFound = new UserDTO();
		
		userFound.id=user.getId();
		userFound.email=user.getEmail();
		userFound.lastName=user.getLastName();
		userFound.name=user.getName();
		userFound.password=user.getPassword();
		userFound.userName=user.getUserName();
		userFound.type=user.getType();
		
		
		return userFound;
		
	}

}
