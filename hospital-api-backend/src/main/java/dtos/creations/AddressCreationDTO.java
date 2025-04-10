package dtos.creations;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AddressCreationDTO(
		@Size(max= 32, message = "O nome da cidade deve ter no máximo 32 caracteres")
		@NotBlank(message = "O nome da cidade não pode estar em branco!")
		String city,
		@Size(max= 32, message = "O nome do estado deve ter no máximo 32 caracteres")
		@NotBlank(message = "O nome do estado não pode estar em branco!")
		String state,
		@Size(max= 32, message = "O nome da rua deve ter no máximo 32 caracteres")
		@NotBlank(message = "O nome da rua não pode estar em branco!")
		String streetName,
		@Size(max= 32, message = "O nome do bairro deve ter no máximo 32 caracteres")
		@NotBlank(message = "O nome do bairro não pode estar em branco!")
		String neighborhood,		
		@Pattern(regexp = "^[0-9A-Za-z/-]+$", message = "Número de residência inválido!")
		@NotBlank(message="O número não pode estar em branco")
		String number,
		@Pattern(regexp = "^\\d{5}-?\\d{3}$", message = "CEP inválido! Por favor digite o CEP no formato 12345-678 ou 12345678")
		@NotBlank(message="O CEP não pode estar em branco")
		String zipCode,
		@Size(max = 300, message= "Complemento deve ter no máximo 300 caracteres!")
		String complement) {

}
