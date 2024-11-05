package com.user_service.user_service.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.user_service.user_service.dto.UserDetail;
import com.user_service.user_service.dto.UserModified;
import com.user_service.user_service.dto.UserRequest;
import com.user_service.user_service.entities.UserEntity;
import com.user_service.user_service.exception.ConflictException;
import com.user_service.user_service.exception.UserNotFoundException;
import com.user_service.user_service.mapper.UserMapper;
import com.user_service.user_service.repositories.UserRepository;
import com.user_service.user_service.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	
	private final UserRepository userRepository;
	
	private final UserMapper userMapper;
	
	@Value("${properties.messages.error.user-not-found-error}")
	private final String userNotFoundError;
	
	@Value("${properties.messages.error.user-already-exist-error}")
	private final String userAlreadyExistError;

	@Override
	public UserDetail createUser(UserRequest userRequest) {
		// TODO Auto-generated method stub
		
		if(userRepository.existsByEmail(userRequest.getEmail())) {
			throw new ConflictException(String.valueOf(
					HttpStatus.CONFLICT.value()), userAlreadyExistError);
		}
		
		UserEntity userEntity = userMapper.userRequestToUserEntity(userRequest);
		UserEntity userEntitySaved = userRepository.save(userEntity);
		
		return userMapper.userEntityToUserDetail(userEntitySaved);

	}

	@Override
	public Page<UserDetail> getAllUsers(Pageable pageable) {
		// TODO Auto-generated method stub
		
		Page<UserEntity> userEntities = userRepository.findAll(pageable);
		
		return userEntities.map(
				userMapper::userEntityToUserDetail);
				
	}

	@Override
	public UserDetail getUser(Integer userId) {
		// TODO Auto-generated method stub
		
		UserEntity userEntity = userRepository.findById(userId)
				.orElseThrow(
						() -> new UserNotFoundException(
								String.valueOf(HttpStatus.NOT_FOUND.value()), userNotFoundError));
		
		return userMapper.userEntityToUserDetail(userEntity);
	}

	@Override
	public UserDetail updateUser(Integer userId, UserModified userModified) {
		// TODO Auto-generated method stub
		
		userRepository.findById(userId)
		.orElseThrow(
				() -> new UserNotFoundException(
						String.valueOf(HttpStatus.NOT_FOUND.value()), userNotFoundError));
		
		
		UserEntity userEntityUpdated = userRepository.save(
				userMapper.userModifiedToUserEntity(userModified));
		
		return userMapper.userEntityToUserDetail(userEntityUpdated);
		
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		
		UserEntity userEntity = userRepository.findById(userId)
		.orElseThrow(
				() -> new UserNotFoundException(
						String.valueOf(HttpStatus.NOT_FOUND.value()), userNotFoundError));
		
		userRepository.delete(userEntity);
		
	}

}
