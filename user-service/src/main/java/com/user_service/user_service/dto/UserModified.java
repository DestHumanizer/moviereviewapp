package com.user_service.user_service.dto;

import java.time.LocalDate;

import com.user_service.user_service.enums.GenderEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModified {
	
	
	private Integer id;
	

	private String name;
	

	private LocalDate birthday;
	

	private String email;
	
	
	private String password;

	
	private GenderEnum gender;
	

	private String profilePhoto;
	



}
