package com.user_service.user_service.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.user_service.user_service.dto.UserDetail;
import com.user_service.user_service.dto.UserModified;
import com.user_service.user_service.dto.UserRequest;

public interface UserService {
	
	//POST
	public UserDetail createUser(UserRequest userRequest);
	
	//GET ALL USERS
	public Page<UserDetail> getAllUsers(Pageable pageable);
	
	//GET A SPECIFIC USER
	public UserDetail getUser(Integer userId);
	
	//PUT
	public UserDetail updateUser(Integer userId, UserModified userModified);
	
	//DELETE
	public void deleteUser(Integer userId);
	

}
