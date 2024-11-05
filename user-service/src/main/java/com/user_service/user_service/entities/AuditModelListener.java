package com.user_service.user_service.entities;

import java.time.LocalDateTime;

import jakarta.persistence.PrePersist;

public class AuditModelListener {
	
	@PrePersist
	public void prePersist(AuditModel audit) {
		LocalDateTime now = LocalDateTime.now();
		audit.setCreationDate(now);
		audit.setModificationDate(now);
	}
	
	public void preupdate(AuditModel audit) {
		audit.setModificationDate(LocalDateTime.now());
	}
	
	

}
