package com.review_service.review_service.entities;

import java.time.LocalDateTime;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class AuditModelListener {
	
	@PrePersist
	public void prePersist(AuditModel audit) {
		LocalDateTime now = LocalDateTime.now();
		
		audit.setCreationDate(now);
		
		audit.setModificationDate(now);
	}
	
	@PreUpdate
	public void preUpdate(AuditModel audit) {
		audit.setModificationDate(LocalDateTime.now());
	}

}
