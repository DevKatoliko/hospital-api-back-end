package dtos.responses;

import model.entities.Nurse;

public record NurseResponseDTO(String name, String lastName, String corenRegister) {
	public static NurseResponseDTO fromNurse(Nurse nurse) {
		return new NurseResponseDTO(nurse.getName(), nurse.getLastName(), nurse.getCorenRegister());
	}
}
