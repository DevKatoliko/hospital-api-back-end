package dtos.updates.forms;

import dtos.responses.AddressResponseDTO;
import model.entities.Patient;

public record PatientUpdateFormDTO(
		PersonUpdateFormDTO personUpdateResponseDTO, 
		AddressResponseDTO address,
		String profession, 
		String mothersName) {
	public static PatientUpdateFormDTO fromPatient(Patient p) {
		return new PatientUpdateFormDTO(
				PersonUpdateFormDTO.fromPerson(p),
				AddressResponseDTO.fromAddress(p.getAddress()),
				p.getProfession(),
				p.getMothersName()
				);
	}
}
