package com.alphacoders.backend.usermanagement.domain;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import com.alphacoders.backend.model.User;
import com.alphacoders.backend.usermanagement.dto.*;

/**
 * An interface that shows us what will be implemented in our Domain Service.
 * @param UserDTO is a type of USER can be  ADMIN or EMPLOYEE
 * @param ID which is the User ID
 * */

@NoRepositoryBean
public interface IUserManagement {
	
	List<UserDTO> findAll();
	UserDTO createUser(UserDTO user);
	UserDTO updateUser(Long id ,UserDTO user);
	UserDTO getUserById(Long id );
	
}
