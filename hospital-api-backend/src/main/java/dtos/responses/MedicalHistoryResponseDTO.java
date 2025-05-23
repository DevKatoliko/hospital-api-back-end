package dtos.responses;

import java.util.Set;
import model.entities.MedicalHistory;
import model.enums.BloodType;
public record MedicalHistoryResponseDTO(
		double weight, 
		double height, 
		BloodType bloodType, 
		boolean smoker, 
		boolean alcoholConsumer,
		boolean physicalExerciser, 
		boolean medicationUser, 
		Set<String> medicinesUsedInformation,
		String familyHealthHistory, 
		String patientHealthHistory, 
		Set<String> surgeriesHistory,
		Set<String> chronicDiseasesInformation, 
		Set<String> patientSymptoms, 
		Set<String> diagnostics,
		Set<String> hospitalizations) {
	public static MedicalHistoryResponseDTO fromMedicalHistory(MedicalHistory mH ) {
		return new MedicalHistoryResponseDTO(
				mH.getWeight(), mH.getHeight(), mH.getBloodType(),
				mH.isSmoker() , mH.isAlcoholConsumer(), mH.isPhysicalExerciser(), 
				mH.isMedicationUser(), mH.getMedicinesUsedInformation(), mH.getFamilyHealthHistory(), mH.getPatientHealthHistory(),
				mH.getSurgeriesHistory(), mH.getChronicDiseasesInformation(), mH.getPatientSymptoms(),
				mH.getDiagnostics(), mH.getHospitalizations());
	}
}
