package dtos.responses.selection;

import model.entities.Hospital;

public record HospitalSelectionDTO(Long id, String name) {
	public static HospitalSelectionDTO fromHospital(Hospital hospital) {
		return new HospitalSelectionDTO(hospital.getId(), hospital.getName());
	}
}
