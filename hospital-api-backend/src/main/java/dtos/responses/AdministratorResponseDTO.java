package dtos.responses;

import model.entities.Administrator;

public record AdministratorResponseDTO(String name, String lastName) {
	public static AdministratorResponseDTO fromAdministrator(Administrator administrator) {
		return new AdministratorResponseDTO(administrator.getName(),administrator.getLastName());
	}
}
