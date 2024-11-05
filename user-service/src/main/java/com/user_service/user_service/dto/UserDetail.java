package com.user_service.user_service.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.user_service.user_service.enums.GenderEnum;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail {
	
    @NotNull(message = "Id cannot be null")
	private Integer id;
	

	private String name;
	

	private LocalDate birthday;
	

	private String email;
	

	private String password;
	

	private GenderEnum gender;
	

	private String profilePhoto;
	
	
	private LocalDateTime creationDate;
	
	
	private LocalDateTime modificationDate;
	



}
