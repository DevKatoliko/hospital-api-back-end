package model.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "prescriptions")
public class Prescription {
	public static final String SUPERSCRIPTION = "℞"; //Used in the body of the prescription to indicate that is been giving to an patient
	@Id
	private Long id;
	private LocalDate prescriptionDate;
	private Doctor doctor; 
	private String medicationDetail;
	private String pharmacistInstruction;
	private String usageInstruction;
	private String additionalInformation;
	protected Prescription() {
	}
	
	public Prescription(LocalDate prescriptionDate, Doctor doctor, String medicationDetail,
			String pharmacistInstruction, String usageInstruction,String additionalInformation) {
		this.prescriptionDate = prescriptionDate;
		this.doctor = doctor;
		this.medicationDetail = medicationDetail;
		this.pharmacistInstruction = pharmacistInstruction;
		this.usageInstruction = usageInstruction;
		this.additionalInformation = additionalInformation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getPrescriptionDate() {
		return prescriptionDate;
	}

	public void setPrescriptionDate(LocalDate prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getMedicationDetail() {
		return medicationDetail;
	}

	public void setMedicationDetail(String medicationDetail) {
		this.medicationDetail = medicationDetail;
	}

	public String getPharmacistInstruction() {
		return pharmacistInstruction;
	}

	public void setPharmacistInstruction(String pharmacistInstruction) {
		this.pharmacistInstruction = pharmacistInstruction;
	}

	public String getUsageInstruction() {
		return usageInstruction;
	}

	public void setUsageInstruction(String usageInstruction) {
		this.usageInstruction = usageInstruction;
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}
	
	

	
}
