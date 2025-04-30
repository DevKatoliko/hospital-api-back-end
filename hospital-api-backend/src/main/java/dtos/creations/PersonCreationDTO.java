package dtos.creations;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import model.enums.Gender;
import model.enums.NationalityType;

public record PersonCreationDTO(
		@NotBlank(message = "O nome não pode estar em branco!")
		@Size(max=32, message="O nome pode ter apenas 32 caracteres!")
		String name,
		@NotBlank(message = "O sobrenome não pode estar em branco!")
		@Size(max=32, message="O sobrenome pode ter apenas 32 caracteres!")
		String lastName,
		@NotNull(message = "O gênero não pode ser nulo!")
		Gender gender,
		@CPF(message="Cpf inválido")
		String cpf,
		@NotNull(message="Data de nascimento é obrigatória!")
		@Past(message = "A data de nascimento deve ser no passado!")
		LocalDate birthDate,
		@Pattern(regexp = "\\(\\d{2}\\d{4,5}-\\d{4})", message ="Telefone inválido!")
		String telephoneNumber,
		@NotBlank(message= "O número de celular é obrigatório")
		@Pattern(regexp = "\\(\\d{2}\\d{4,5}-\\d{4})", message = "Telefone inválido!")
		String cellphoneNumber,
		@NotBlank(message = "O E-mail é obrigatório!")
		@Email(message = "Email inválido!")
		String email,
		@Valid
		@NotNull(message = "O endereço é obrigatório!")
		AddressCreationDTO addressDTO, 
		@NotNull(message = "A nacionalidade é obrigatória!")
		NationalityType nationality,
		@NotNull(message = "É necessário informar o hospital!")
		Long hospitalId) {

}
