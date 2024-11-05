package com.user_service.user_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.user_service.user_service.dto.UserDetail;
import com.user_service.user_service.dto.UserModified;
import com.user_service.user_service.dto.UserRequest;
import com.user_service.user_service.entities.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {
	
	public UserDetail userEntityToUserDetail(UserEntity userEntity);
	
	@Mapping(target = "name", expression = "java(userRequest.getFirstName() + \" \" + userRequest.getLastName())")
	public UserEntity userRequestToUserEntity(UserRequest userRequest);
	
	
	public UserEntity userModifiedToUserEntity(UserModified userModified);
	
	
	
	

}
