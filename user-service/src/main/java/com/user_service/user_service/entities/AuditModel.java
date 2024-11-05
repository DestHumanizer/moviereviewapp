package com.user_service.user_service.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
@EntityListeners(AuditModelListener.class)
public class AuditModel {
	
	@Column(name = "modification_date", nullable = false)
	private LocalDateTime modificationDate;
	
	@Column(name = "creation_date", nullable = false, updatable = false)
	private LocalDateTime creationDate;

}
