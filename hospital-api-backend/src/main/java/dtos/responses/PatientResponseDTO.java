package dtos.responses;

import model.entities.Hospital;
import model.entities.Patient;
import model.enums.Gender;

public record PatientResponseDTO(String name, String lastName, Gender gender, Hospital hospital) {
	public static PatientResponseDTO fromPatient(Patient patient) {
		return new PatientResponseDTO(
				patient.getName(),
				patient.getLastName(), 
				patient.getGender(), 
				patient.getHospital());
	}
	
}
