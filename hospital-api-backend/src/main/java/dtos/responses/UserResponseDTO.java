package dtos.responses;

import model.entities.User;

public record UserResponseDTO(String name, String login, String email) {
	public static UserResponseDTO fromUser(User user) {
		
		return new UserResponseDTO(user.getPerson().getName(), user.getLogin(), user.getEmail() );
	};
	
}
