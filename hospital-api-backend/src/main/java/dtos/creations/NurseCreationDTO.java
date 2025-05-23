package dtos.creations;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NurseCreationDTO(
		@Valid
		PersonCreationDTO personDTO,
		@NotBlank(message = "O registro COREN é obrigatório!")
		String corenRegister, 
		@NotNull(message = "É necessário informar qual é o médico supervisor do enfermeiro!")
		Long supervisingDoctorId) {

}
