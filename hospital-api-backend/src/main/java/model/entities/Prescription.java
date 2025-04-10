package model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
@Entity
@Table(name = "prescriptions")
public class Prescription implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final String NULL_ERROR_PRESCRIPTION_DATE = "A data da prescrição não pode ser nula!";
	private static final String NULL_ERROR_DOCTOR = "O médico responsável não pode ser nulo!";
	private static final String NULL_ERROR_MEDICATION_DETAIL = "Os detalhes da medicação não podem ser nulos!";
	private static final String NULL_ERROR_PHARMACIST_INSTRUCTION = "As instruções do farmacêutico não podem ser nulas!";
	private static final String NULL_ERROR_USAGE_INSTRUCTION = "As instruções de uso não podem ser nulas!";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "prescription_date", nullable = false)
	@PastOrPresent(message = "A data da prescrição não pode ser futura!")
	@NotNull(message = NULL_ERROR_PRESCRIPTION_DATE)
	private LocalDate prescriptionDate;
	@OneToOne
	@JoinColumn(name = "doctor_id", referencedColumnName = "id", nullable = false)
	@NotNull(message = NULL_ERROR_DOCTOR)
	private Doctor doctor; 
	@Column(name = "medication_detail", nullable = false)
	@NotBlank(message = "Os detalhes da medicação devem ser informados!")
	@NotNull(message = NULL_ERROR_MEDICATION_DETAIL)
	private String medicationDetail;
	@Column(name = "pharmacist_instruction", nullable = false)
	@NotBlank(message = "A instrução farmacêutica não pode ser em branco!")
	@NotNull(message = NULL_ERROR_PHARMACIST_INSTRUCTION)
	private String pharmacistInstruction;
	@Column(name = "usage_instruction", nullable = false)
	@NotBlank(message = "A instrução de uso não pode ser em branco!")
	@NotNull(message = NULL_ERROR_USAGE_INSTRUCTION)
	private String usageInstruction;
	@Column(name = "additional_information")
	private String additionalInformation; //  The doctor can add some comments or additional information to the prescription
	
	protected Prescription() {
	}
	
	public Prescription(LocalDate prescriptionDate, Doctor doctor, String medicationDetail,
			String pharmacistInstruction, String usageInstruction,String additionalInformation) {
		this.prescriptionDate = Objects.requireNonNull(prescriptionDate, NULL_ERROR_PRESCRIPTION_DATE);
		this.doctor = Objects.requireNonNull(doctor, NULL_ERROR_DOCTOR);
		this.medicationDetail = Objects.requireNonNull(medicationDetail,NULL_ERROR_MEDICATION_DETAIL);
		this.pharmacistInstruction = Objects.requireNonNull(pharmacistInstruction, NULL_ERROR_PHARMACIST_INSTRUCTION);
		this.usageInstruction = Objects.requireNonNull(usageInstruction, NULL_ERROR_USAGE_INSTRUCTION);
		this.additionalInformation = additionalInformation;
	}

	public Long getId() {
		return id;
	}

	public LocalDate getPrescriptionDate() {
		return prescriptionDate;
	}

	public void setPrescriptionDate(LocalDate prescriptionDate) {
		this.prescriptionDate = Objects.requireNonNull(prescriptionDate, NULL_ERROR_PRESCRIPTION_DATE);
	}

	public Doctor getDoctor() {
		return doctor;
	}
	 
	public void setDoctor(Doctor doctor) {
		this.doctor = Objects.requireNonNull(doctor, NULL_ERROR_DOCTOR);
	}

	public String getMedicationDetail() {
		return medicationDetail;
	}

	public void setMedicationDetail(String medicationDetail) {
		this.medicationDetail = Objects.requireNonNull(medicationDetail,NULL_ERROR_MEDICATION_DETAIL);
	}

	public String getPharmacistInstruction() {
		return pharmacistInstruction;
	}

	public void setPharmacistInstruction(String pharmacistInstruction) {
		this.pharmacistInstruction = Objects.requireNonNull(pharmacistInstruction, NULL_ERROR_PHARMACIST_INSTRUCTION);
	}

	public String getUsageInstruction() {
		return usageInstruction;
	}

	public void setUsageInstruction(String usageInstruction) {
		this.usageInstruction = Objects.requireNonNull(usageInstruction, NULL_ERROR_USAGE_INSTRUCTION);
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prescription other = (Prescription) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
