package com.user_service.user_service.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.user_service.user_service.dto.UserDetail;
import com.user_service.user_service.dto.UserModified;
import com.user_service.user_service.dto.UserRequest;
import com.user_service.user_service.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	@PostMapping("/users")
	public UserDetail createUser(
			@RequestBody @Valid UserRequest userRequest) {
		return userService.createUser(userRequest);
		
	}
	
	@GetMapping("/users")
	public Page<UserDetail> getUsers(
			@RequestParam(defaultValue = "0")  int page,
			@RequestParam(defaultValue = "10") int size) {
		
		PageRequest pageable = PageRequest.of(page, size);
		
		return userService.getAllUsers(pageable);
		
	}
	
	@GetMapping("/users/{userId}")
	public UserDetail getUserById(
			@PathVariable @Valid Integer id) {
		
		return userService.getUser(id);	
	}
	
	@PutMapping("/users/{userId}")
	public  UserDetail updateUser(
			@PathVariable @Valid Integer userId,
			@RequestBody @Valid UserModified userModified) {
		return userService.updateUser(userId, userModified);
	}
	
	@DeleteMapping("/users/{userId}")
	public void deleteUser(
			@PathVariable @Valid Integer id) {
		userService.deleteUser(id);
	}
	
	

}
