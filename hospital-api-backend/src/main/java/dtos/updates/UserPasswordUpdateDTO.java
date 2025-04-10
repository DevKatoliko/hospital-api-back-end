package dtos.updates;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UserPasswordUpdateDTO(
		@NotBlank(message = "Senha não pode ser em branco") 
		@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)(?=.*[!@#$%¨&*()_\\\\-+=§])[A-Za-z\\\\d!@#$%¨&*()_\\\\-+=§]{8,64}$", 
		message = "A senha deve conter pelo menos uma letra minúscula, uma maiúscula, um número e um caractere especial.") 
		String newPassword) {

}
