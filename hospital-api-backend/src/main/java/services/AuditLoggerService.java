package services;

import org.springframework.stereotype.Service;

@Service
public class AuditLoggerService {

	public void log(String action, String userId, String userEmail, String resourceId) {
		System.out.printf("AUDITORIA - Ação: %s | Usuário: %s (%s) | Recurso: %s%n", action, userId, userEmail, resourceId);
	}
}
