package model.entities;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import model.enums.Gender;
import model.enums.NationalityType;
@Entity
@Table(name= "patients")
public class Patient extends Person{
	private static final long serialVersionUID = 1L;
	@Column(nullable = false)
	private String profession;
	@Column(name="mothers_name", nullable = false)
	private String mothersName;
	@OneToOne
	@JoinColumn(name = "medical_record_id", referencedColumnName = "id")
	private MedicalRecord medicalRecord;
	@ManyToMany(mappedBy = "patients")
	private Set<Doctor> doctors = new HashSet<>();
	@OneToMany(mappedBy = "patient")
	private Set<MedicalRecord> medicalRecordsHistory = new HashSet<>();// Here is the repository to keep all medical records of a patient
	@OneToOne(mappedBy = "patient")
	@Column(name = "medical_history")
	MedicalHistory medicalHistory;
	@OneToMany(mappedBy = "patient")
	Set<Schedule> schedules = new HashSet<>(); // A patient maybe have an appointment with more than one doctor 
	
	protected  Patient() {
		super();
	}

	// Constructor to create a patient
	public Patient(String name, String lastName, Gender gender, String cpf, LocalDate birthDate, String telephoneNumber,
			String cellphoneNumber, String email, Address address,NationalityType nationality, Hospital hospital, String profession, String mothersName) {
		super(name, lastName, gender, cpf, birthDate, telephoneNumber, cellphoneNumber, email, address, nationality ,hospital);
		this.profession = Objects.requireNonNull(profession, "A profissão não pode ser nula!");
		this.mothersName = Objects.requireNonNull(mothersName, "O nome da mãe não pode ser nulo!");
	}


	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = Objects.requireNonNull(profession, "A profissão não pode ser nula!");
	}

	public String getMothersName() {
		return mothersName;
	}

	public void setMothersName(String mothersName) {
		this.mothersName = Objects.requireNonNull(mothersName, "O nome da mãe não pode ser nulo!");
	}

	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	public Set<Doctor> getDoctors() {
		return Collections.unmodifiableSet(doctors);
	}
	
	public void addDoctor(Doctor doctor) {
		doctors.add(Objects.requireNonNull(doctor, "O médico não pode ser nulo!"));
	}
	public Set<MedicalRecord> getMedicalRecordsHistory() {
		return Collections.unmodifiableSet(medicalRecordsHistory);
	}

	public MedicalHistory getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(MedicalHistory medicalHistory) {
		this.medicalHistory = Objects.requireNonNull(medicalHistory, "O histórico médico não pode ser nulo!");
	}

	public Set<Schedule> getSchedules() {
		return Collections.unmodifiableSet(schedules);
	}

	public void addSchedule(Schedule schedule) {
		this.schedules.add(Objects.requireNonNull(schedule,"A agenda não pode ser nula"));
	}

	
	
	
	
}
