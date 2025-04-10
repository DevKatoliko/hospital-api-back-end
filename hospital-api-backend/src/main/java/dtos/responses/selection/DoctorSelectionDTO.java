package dtos.responses.selection;

import model.entities.Doctor;

public record DoctorSelectionDTO(Long id, String name, String lastName) {
	public static DoctorSelectionDTO fromDoctor(Doctor doctor) {
		return new DoctorSelectionDTO(doctor.getId(), doctor.getName(), doctor.getLastName());
	}
}
