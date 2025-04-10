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
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import model.enums.BloodType;
@Entity
@Table(name= "medical_history_records")
public class MedicalHistory implements Serializable{
    private static final long serialVersionUID = 1L;
	private static final String NULL_ERROR_WEIGHT = "O peso não pode ser nulo!";
    private static final String NULL_ERROR_HEIGHT = "A altura não pode ser nula!";
    private static final String NULL_ERROR_BLOOD = "É necessário informar o tipo sanguíneo!";
    private static final String NULL_ERROR_FAMILY_HISTORY = "O histórico de saúde familiar não pode ser nulo!";
    private static final String NULL_ERROR_PATIENT_HISTORY = "O histórico de saúde do paciente não pode ser nulo!";
   

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private double weight;
    
    @Column(nullable = false)
    private double height;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BloodType bloodType;

    @Column(nullable = false)
    private boolean smoker;

    @Column(name = "drink_alcohol", nullable = false)
    private boolean alcoholConsumer;

    @Column(name = "practice_physical_exercise", nullable = false)
    private boolean physicalExerciser;

    @Column(name = "uses_medicine", nullable = false)
    private boolean medicationUser;

    @ElementCollection
    @CollectionTable(name = "patients_medicines_information", joinColumns = @JoinColumn(name = "medical_history_id"))
    @Column(name = "medicines")
    private Set<String> medicinesUsedInformation = new HashSet<>();

    @Column(name = "family_health_history", nullable = false)
    private String familyHealthHistory;

    @Column(name = "patient_health_history", nullable = false)
    private String patientHealthHistory;

    @ElementCollection
    @CollectionTable(name = "surgeries_history", joinColumns = @JoinColumn(name = "medical_history_id"))
    @Column(name = "surgeries")
    private Set<String> surgeriesHistory = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "patients_chronic_diseases_information", joinColumns = @JoinColumn(name = "medical_history_id"))
    @Column(name = "chronic_diseases")
    private Set<String> chronicDiseasesInformation = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "patients_symptoms", joinColumns = @JoinColumn(name = "medical_history_id"))
    @Column(name = "symptoms")
    private Set<String> patientSymptoms = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "patients_diagnostics", joinColumns = @JoinColumn(name = "medical_history_id"))
    @Column(name = "diagnostics")
    private Set<String> diagnostics = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "patients_hospitalizations", joinColumns = @JoinColumn(name = "medical_history_id"))
    @Column(name = "hospitalizations")
    private Set<String> hospitalizations = new HashSet<>(); // Describe the circumstances, for how long and other details 

    @OneToOne
    @JoinColumn(name = "patient", referencedColumnName = "id")
    private Patient patient;

	protected MedicalHistory() {}
	
	
	public MedicalHistory(double weight, double height, BloodType bloodType, boolean smoker, boolean alcoholConsumer,
			boolean physicalExerciser, boolean medicationUser, Set<String> medicinesUsedInformation,
			String familyHealthHistory, String patientHealthHistory, Set<String> surgeriesHistory,
			Set<String> chronicDiseasesInformation, Set<String> patientSymptoms, Set<String> diagnostics,
			Set<String> hospitalizations) {
		 this.weight = Objects.requireNonNull(weight, NULL_ERROR_WEIGHT);
		    this.height = Objects.requireNonNull(height, NULL_ERROR_HEIGHT);
		    this.bloodType = Objects.requireNonNull(bloodType, NULL_ERROR_BLOOD);
		    this.smoker = smoker;
		    this.alcoholConsumer = alcoholConsumer;
		    this.physicalExerciser = physicalExerciser;
		    this.medicationUser = medicationUser;
		    this.medicinesUsedInformation = (medicinesUsedInformation != null) ? new HashSet<>(medicinesUsedInformation) : new HashSet<>();
		    this.familyHealthHistory = Objects.requireNonNull(familyHealthHistory, NULL_ERROR_FAMILY_HISTORY);
		    this.patientHealthHistory = Objects.requireNonNull(patientHealthHistory, NULL_ERROR_PATIENT_HISTORY);
		    this.surgeriesHistory = (surgeriesHistory != null) ? new HashSet<>(surgeriesHistory) : new HashSet<>();
		    this.chronicDiseasesInformation = (chronicDiseasesInformation != null) ? new HashSet<>(chronicDiseasesInformation) : new HashSet<>();
		    this.patientSymptoms = (patientSymptoms != null) ? new HashSet<>(patientSymptoms) : new HashSet<>();
		    this.diagnostics = (diagnostics != null) ? new HashSet<>(diagnostics) : new HashSet<>();
		    this.hospitalizations = (hospitalizations != null) ? new HashSet<>(hospitalizations) : new HashSet<>();
	}


	public Long getId() {
		return id;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public BloodType getBloodType() {
		return bloodType;
	}
	public void setBloodType(BloodType bloodType) {
		this.bloodType = bloodType;
	}
	public boolean isSmoker() {
		return smoker;
	}
	public void setSmoker(boolean smoker) {
		this.smoker = smoker;
	}
	public boolean isAlcoholConsumer() {
		return alcoholConsumer;
	}
	public void setAlcoholConsumer(boolean alcoholConsumer) {
		this.alcoholConsumer = alcoholConsumer;
	}
	public boolean isPhysicalExerciser() {
		return physicalExerciser;
	}
	public void setPhysicalExerciser(boolean physicalExerciser) {
		this.physicalExerciser = physicalExerciser;
	}
	public boolean isMedicationUser() {
		return medicationUser;
	}
	public void setMedicationUser(boolean medicationUser) {
		this.medicationUser = medicationUser;
	}
	public Set<String> getMedicinesUsedInformation() {
		return  Collections.unmodifiableSet(medicinesUsedInformation);
	}
	public void setMedicinesUsedInformation(Set<String> medicinesUsedInformation) {
		this.medicinesUsedInformation = (medicinesUsedInformation != null) ? new HashSet<>(medicinesUsedInformation): new HashSet<>();
	}
	public String getFamilyHealthHistory() {
		return familyHealthHistory;
	}
	public void setFamilyHealthHistory(String familyHealthHistory) {
		this.familyHealthHistory = familyHealthHistory;
	}
	public String getPatientHealthHistory() {
		return patientHealthHistory;
	}
	public void setPatientHealthHistory(String patientHealthHistory) {
		this.patientHealthHistory = patientHealthHistory;
	}
	public Set<String> getSurgeriesHistory() {
		return Collections.unmodifiableSet(surgeriesHistory);
	}
	public void setSurgeriesHistory(Set<String> surgeriesHistory) {
		this.surgeriesHistory = (surgeriesHistory != null) ? new HashSet<>(surgeriesHistory): new HashSet<>();
	}
	public Set<String> getChronicDiseasesInformation() {
		return Collections.unmodifiableSet(chronicDiseasesInformation);
	}
	public void setChronicDiseasesInformation(Set<String> chronicDiseasesInformation) {
		this.chronicDiseasesInformation = (chronicDiseasesInformation != null) ? new HashSet<>(chronicDiseasesInformation) : new HashSet<>();
	}
	public Set<String> getPatientSymptoms() {
		return Collections.unmodifiableSet(patientSymptoms);
	}
	public void setPatientSymptoms(Set<String> patientSymptoms) {
		this.patientSymptoms = (patientSymptoms != null) ?  new HashSet<>(patientSymptoms) : new HashSet<>();
	}
	public Set<String> getDiagnostics() {
		return Collections.unmodifiableSet(diagnostics);
	}
	public void setDiagnostics(Set<String> diagnostics) {
		this.diagnostics = (diagnostics != null) ? new HashSet<>(diagnostics) : new HashSet<>();
	}
	public Set<String> getHospitalizations() {
		return Collections.unmodifiableSet(hospitalizations);
	}
	public void setHospitalizations(Set<String> hospitalizations) {
		this.hospitalizations = (hospitalizations != null) ? new HashSet<>(hospitalizations) : new HashSet<>();
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
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
		MedicalHistory other = (MedicalHistory) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
