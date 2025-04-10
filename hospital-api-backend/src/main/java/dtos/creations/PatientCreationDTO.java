package dtos.creations;

import jakarta.validation.constraints.NotBlank;

public record PatientCreationDTO(
		@NotBlank(message = "Profissão não pode estar em branco!")
		String profession,	
		@NotBlank(message = "O nome da mãe não pode estar em branco")
		String mothersName) {
	
}
