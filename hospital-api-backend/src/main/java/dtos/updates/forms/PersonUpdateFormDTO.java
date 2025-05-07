package dtos.updates.forms;

import java.time.LocalDate;

import model.entities.Person;
import model.enums.Gender;
import model.enums.NationalityType;

public record PersonUpdateFormDTO(
		 String name,
		 String lastName,
		 Gender gender,
		 LocalDate birthDate,
		 String telephoneNumber,
		 String cellphoneNumber,
		 String email,
		 NationalityType nationality, 
		 Long hospitalId 
		 ) {
	public static PersonUpdateFormDTO fromPerson(Person person) {
		return new PersonUpdateFormDTO(
				person.getName(),
				person.getLastName(),
				person.getGender(),
				person.getBirthDate(),
				person.getTelephoneNumber(),
				person.getCellphoneNumber(),
				person.getEmail(), 
				person.getNationality(),
				person.getHospital().getId());
	}
}
