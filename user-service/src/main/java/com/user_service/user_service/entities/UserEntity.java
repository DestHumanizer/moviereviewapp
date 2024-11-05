package com.user_service.user_service.entities;

import java.time.LocalDate;

import com.user_service.user_service.enums.GenderEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;
	
	@Column(name = "name", length = 40, nullable = false)
	private String name;
	
	@Column(name = "birthday", nullable = false)
	private LocalDate birthday;
	
	@Column(name = "email", length = 60, nullable = false)
	private String email;
	
	@Column(name = "password", length = 20, nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "gender", length = 6, nullable = false)
	private GenderEnum gender;
	
	@Column(name = "profile_photo")
	private String profilePhoto;
	

	
	

}
