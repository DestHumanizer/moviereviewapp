package com.moviereviewapp.mar.entities;

import java.time.LocalDateTime;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class AuditModelListener {
	
	@PrePersist
	public void prepersist(AuditModel audit) {
		LocalDateTime now = LocalDateTime.now();
		audit.setCreadtionDate(now);
		audit.setModificationDate(now);
	}
	
	@PreUpdate
	public void preUpdate(AuditModel audit) {
		audit.setModificationDate(LocalDateTime.now());
	}

}
