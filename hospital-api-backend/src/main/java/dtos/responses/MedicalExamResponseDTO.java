package dtos.responses;

import java.time.LocalDate;
import java.util.Set;

import model.entities.MedicalExam;

public record MedicalExamResponseDTO(String patientName, String physicalExam, Set<String> complementaryExams,
		Set<String> examMeasuresResult, String methods, String doctorsObservations, LocalDate examDate) {
	public static MedicalExamResponseDTO completeMedicalExam(MedicalExam medicalExam) {
		String patientName = medicalExam.getMedicalRecord().getPatient().getName();
		return new MedicalExamResponseDTO(patientName, medicalExam.getPhysicalExam(),
				medicalExam.getComplementaryExams(), medicalExam.getExamMeasuresResult(), medicalExam.getMethods(),
				medicalExam.getDoctorObservations(), medicalExam.getExamDate());
	}

	public static MedicalExamResponseDTO basicMedicalExam(MedicalExam medicalExam) {
		String patientName = medicalExam.getMedicalRecord().getPatient().getName();
		return new MedicalExamResponseDTO(patientName, medicalExam.getPhysicalExam(),
				medicalExam.getComplementaryExams(), null, null, medicalExam.getDoctorObservations(),
				medicalExam.getExamDate());
	}

}
