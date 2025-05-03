package dtos.responses;

import model.entities.Patient;
import model.enums.Gender;

public record PatientResponseDTO(String name, String lastName, Gender gender,String profession,String mothersName, String email,Long hospitalId) {
	public static PatientResponseDTO fromPatient(Patient patient) {
		return new PatientResponseDTO(
				patient.getName(),
				patient.getLastName(), 
				patient.getGender(),
				patient.getProfession(),
				patient.getMothersName(),
				patient.getEmail(),
				patient.getHospital().getId());
	}
	
}
