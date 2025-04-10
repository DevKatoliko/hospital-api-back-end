package model.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="medical_records")
public class MedicalRecord implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany
	@JoinTable(name="doctors_in_medical_records", 
	joinColumns = @JoinColumn(name="medical_record_id"), inverseJoinColumns = @JoinColumn(name = "doctor_id", nullable = false))
	private Set<Doctor> doctors = new HashSet<>(); // More than one doctor can be treating a patient in the same hospital
	
	@ManyToOne
	@JoinColumn(name = "patient_id", referencedColumnName = "id", nullable = false)
	private Patient patient;
	
	@ElementCollection
	@CollectionTable(name = "symptoms", joinColumns = @JoinColumn(name = "medical_record_id"))
	private Set<String> symptoms = new HashSet<>();
	
	@OneToOne
	@JoinColumn(name="medical_exam_id", referencedColumnName = "id")
	private MedicalExam medicalExam; // Contains all the exams that are necessary to the medical record
	
	@ManyToOne
	@JoinColumn(name = "medical_history_id", referencedColumnName = "id", nullable = false)
	private MedicalHistory medicalHistory; // The medical history of the patient who's the medical record belongs
	
	@Column(name = "hypothetical_diagnostic", nullable = false)
	private String hypotheticalDiagnostic;
	
	@Column(name = "final_diagnostic")
	private String finalDiagnostic;
	
	@OneToOne
	@JoinColumn(name="prescription_id", referencedColumnName = "id")
	private Prescription prescription;
	
	protected MedicalRecord() {}
	
	public MedicalRecord(Set<Doctor> doctors, Patient patient, Set<String> symptoms, MedicalHistory medicalHistory, String hypotheticalDiagnostic ) {
		this.doctors = (doctors != null ) ? doctors : new HashSet<>();
		this.patient = Objects.requireNonNull(patient, "O paciente não pode ser nulo!");
		this.symptoms = (symptoms != null) ? symptoms : new HashSet<>();
		this.medicalHistory = Objects.requireNonNull(medicalHistory, "O histórico médico não pode ser nulo!");
		this.hypotheticalDiagnostic = Objects.requireNonNull(hypotheticalDiagnostic, "O diagnóstico hipotético não pode ser nulo!");
	}

	public Long getId() {
		return id;
	}

	public Set<Doctor> getDoctors() {
		return Collections.unmodifiableSet(doctors);
	}

	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = (doctors != null ) ? doctors : new HashSet<>();
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = Objects.requireNonNull(patient, "O paciente não pode ser nulo!");
	}

	public Set<String> getSymptoms() {
		return Collections.unmodifiableSet(symptoms);
	}

	public void setSymptoms(Set<String> symptoms) {
		this.symptoms = (symptoms != null) ? symptoms : new HashSet<>();
	}

	public MedicalExam getMedicalExam() {
		return medicalExam;
	}

	public void setMedicalExam(MedicalExam medicalExam) {
		this.medicalExam = Objects.requireNonNull(medicalExam, "O exame médico não pode ser nulo!");
	}

	public MedicalHistory getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(MedicalHistory medicalHistory) {
		this.medicalHistory = Objects.requireNonNull(medicalHistory, "O histórico médico não pode ser nulo!");
	}

	public String getHypotheticalDiagnostic() {
		return hypotheticalDiagnostic;
	}

	public void setHypotheticalDiagnostic(String hypotheticalDiagnostic) {
		this.hypotheticalDiagnostic = Objects.requireNonNull(hypotheticalDiagnostic, "O diagnóstico hipotético não pode ser nulo!");
	}

	public String getFinalDiagnostic() {
		return finalDiagnostic;
	}

	public void setFinalDiagnostic(String finalDiagnostic) {
		this.finalDiagnostic = Objects.requireNonNull(finalDiagnostic, "O diagnóstico final não pode ser nulo!");
	}
	
	
	public Prescription getPrescription() {
		return prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = Objects.requireNonNull(prescription, "A receita médica não pode ser nula!");
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
		MedicalRecord other = (MedicalRecord) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
