package dtos.responses;

import java.time.LocalDate;

import model.entities.Prescription;

public record PrescriptionResponseDTO(LocalDate prescriptionDate, DoctorResponseDTO doctor, String medicationDetail,
		String pharmacistInstruction, String usageInstruction,String additionalInformation) {
	
	public static PrescriptionResponseDTO fromPrescription(Prescription prescription) {
		return new PrescriptionResponseDTO(
				prescription.getPrescriptionDate(), 
				DoctorResponseDTO.doctorsEssentialInformation(prescription.getDoctor()), 
				prescription.getMedicationDetail(),
				prescription.getPharmacistInstruction(), 
				prescription.getUsageInstruction(), 
				prescription.getAdditionalInformation());
	}
}
