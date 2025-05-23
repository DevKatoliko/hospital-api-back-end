package dtos.responses;

import java.util.ArrayList;
import java.util.List;
import model.entities.MedicalRecord;

public record MedicalRecordResponseDTO(
		List<DoctorResponseDTO> doctors,PatientResponseDTO patient,List<String> symptoms,
		MedicalHistoryResponseDTO medicalHistory,MedicalExamResponseDTO medicalExam,String hypotheticalDiagnostic,
		String finalDiagnostic,PrescriptionResponseDTO prescription) {
		
	public static MedicalRecordResponseDTO fromMedicalRecord(MedicalRecord medicalRecord) {
			List<DoctorResponseDTO> doctors = DoctorResponseDTO.doctorsEssentialInformationList(medicalRecord.getDoctors());
			PatientResponseDTO patient = PatientResponseDTO.fromPatient(medicalRecord.getPatient());
			MedicalHistoryResponseDTO medicalHistory = MedicalHistoryResponseDTO.fromMedicalHistory(medicalRecord.getMedicalHistory());
			MedicalExamResponseDTO medicalExam = MedicalExamResponseDTO.completeMedicalExam(medicalRecord.getMedicalExam());
			PrescriptionResponseDTO prescription = PrescriptionResponseDTO.fromPrescription(medicalRecord.getPrescription());
			
			return new MedicalRecordResponseDTO(
					doctors, 
					patient, 
					new ArrayList<>(medicalRecord.getSymptoms()),
					medicalHistory, 
					medicalExam, 
					medicalRecord.getHypotheticalDiagnostic(),
					medicalRecord.getFinalDiagnostic(), 
					prescription);
		}
}
