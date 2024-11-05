package com.user_service.user_service.dto;

import java.time.LocalDate;

import com.user_service.user_service.enums.GenderEnum;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
	

	private Integer id;
	
    @NotEmpty(message = "First name cannot be empty")
    @Size(max = 20, message = "First name cannot be longer than 20 characters")
	private String firstName;
	
    @NotEmpty(message = "Last name cannot be empty")
    @Size(max = 20, message = "Last name cannot be longer than 20 characters")
	private String lastName;
	
    @NotNull(message = "Birthday cannot be null")
	private LocalDate birthday;
	
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "The email format is incorrect")
	private String email;
	
    @NotNull(message = "Gender cannot be null")
	private GenderEnum gender;
	
    @NotEmpty(message = "Password cannot be empty")
    @Pattern(
    		regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\\\d)(?=.*[@$!%*?&])[A-Za-z\\\\d@$!%*?&]{8,15}$",
    		message = "Password does not meet the requirements")
	private String password;

}
