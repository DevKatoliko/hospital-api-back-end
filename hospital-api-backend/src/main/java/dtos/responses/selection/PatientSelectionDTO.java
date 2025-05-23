package dtos.responses.selection;

import model.entities.Patient;

public record PatientSelectionDTO(Long patientId, String patientName, String patientLastName) {
	public static PatientSelectionDTO fromPatient(Patient p) {
		return new PatientSelectionDTO(p.getId(), p.getName(), p.getLastName());
	}
}
