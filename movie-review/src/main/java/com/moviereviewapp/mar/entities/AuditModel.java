package com.moviereviewapp.mar.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
@EntityListeners(AuditModelListener.class)
public class AuditModel {
	@Column(name = "modificationDate", nullable = false, updatable = false)
	private LocalDateTime modificationDate;
	
	@Column(name = "creationDate", nullable = false, updatable = false)
	private LocalDateTime creadtionDate;

}
