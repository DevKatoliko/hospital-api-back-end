package dtos.creations;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import model.enums.Specialty;

public record DoctorCreationDTO(
		@Valid
		PersonCreationDTO personDTO,
		@NotBlank(message = "É necessário informar o documento de regitro profissional do médico!")
		String professionalRegistration,
		@NotNull(message = "É necessário informar a especialidade do médico!")
		Specialty specialty) {

}
