package dtos.responses;

import model.entities.Hospital;

public record HospitalResponseDTO(Long id,String name, AddressResponseDTO address, String telephone) {
	public static HospitalResponseDTO fromHospital(Hospital hospital) {
		return new HospitalResponseDTO(hospital.getId(),hospital.getName(), AddressResponseDTO.fromAddress(hospital.getAddress()), hospital.getTelephone());
	}
}
