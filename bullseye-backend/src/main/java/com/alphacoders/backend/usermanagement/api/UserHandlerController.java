package com.alphacoders.backend.usermanagement.api;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alphacoders.backend.dto.ResultDTO;
import com.alphacoders.backend.usermanagement.dto.*;
import com.alphacoders.backend.model.User;
import com.alphacoders.backend.usermanagement.domain.IUserAuthentication;
import com.alphacoders.backend.usermanagement.domain.IUserManagement;

/** 
 * @author Alphacoders
 * @version  v1.0
 * All mapping and transactions according the Interface 
 * */


@CrossOrigin
@RestController    
@RequestMapping("/api/v1/userhandler") 
public class UserHandlerController {


	@Autowired
	private IUserManagement repository;
	
	
	/**
	 * To Get  a list of All users 
	 * @return List<User>  is a List  of all  users
	 * */

	@GetMapping("users")
	public List<UserDTO> getAllUsers(){
		return repository.findAll();
	}
	
	/**
	 * To Create new user  
	 * @param UserDTO is a type of USER can be  ADMIN or EMPLOYEE
	 * @return ResultDTO It is a class that contains attributes that will indicate
	 *  the Status of the return or any Exception, it also contains the USER object inside. 
	 * */

	@PostMapping("newuser")
	public ResultDTO addUser(@RequestBody UserDTO user) {
		ResultDTO result = new ResultDTO();

		try {		
			result.Data = repository.createUser(user);
			result.Status="OK";
		}catch(Exception ex) {
			result.Status="EX";
			result.Error=ex;
		}			
		return result;
		
	}
	
	
	/**
	 * To Update a User  
	 * @param ID
	 * @param UserDTO is a type of USER can be  ADMIN or EMPLOYEE
	 *  @return ResultDTO It is a class that contains attributes that will indicate 
	 *  the Status of the return or any Exception, it also contains the USER object inside. 
	 * */

	@PutMapping("/users/{id}")
	public ResultDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDetails) {
			ResultDTO result = new ResultDTO();

				try {
					result.Data = repository.updateUser(id,userDetails);
					result.Status="OK";


				} catch (Exception ex) {
					result.Status="EX";
					result.Error=ex;
				}

				return result;

		}
	

	/**
	 * To Return a User  
	 * @param ID
	 *  @return ResultDTO It is a class that contains attributes that will indicate 
	 *  the Status of the return or any Exception, it also contains the USER object inside.
	 * */
	
	@GetMapping("/users/{id}")
	public ResultDTO getUserById (@PathVariable Long id) {
			ResultDTO result = new ResultDTO();

				try {
					result.Data = repository.getUserById(id);
					result.Status="OK";


				} catch (Exception ex) {
					result.Status="EX";
					result.Error=ex;
				}

				return result;

		}
	

}
