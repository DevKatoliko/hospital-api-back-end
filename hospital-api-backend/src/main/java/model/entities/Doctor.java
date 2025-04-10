package model.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import model.enums.Gender;
import model.enums.NationalityType;
import model.enums.Specialty;
import model.enums.WorkShiftType;
@Entity
@Table(name= "doctors")
public class Doctor extends Employee {
	private static final long serialVersionUID = 1L;
	public static final String NULL_ERROR_PROFESSIONAL_RESGISTRATION = "Registro médico profissional não pode ser nulo!";
	public static final String NULL_ERROR_SPECIALTY= "A especialidade não pode ser nula!";
	
	@ManyToMany
	@JoinTable(name="doctors_and_patients", 
	joinColumns = @JoinColumn(name = "doctor_id"), inverseJoinColumns = @JoinColumn(name= "patient_id"))
	private Set<Patient> patients = new HashSet<>();
	
	@OneToMany(mappedBy = "doctor")
	private Set<Schedule> schedules = new HashSet<>();
	
	@Column(name= "professional_registration", nullable = false, unique = true)
	private String professionalRegistration;//CRM, NPI, GMC, etc...
	
	@Enumerated(value=EnumType.STRING)
	private Specialty specialty;
	
	protected Doctor() {
		super();
	}
	
	public Doctor(
			String professionalRegistration,
			Specialty specialty,
			BigDecimal salary, 
			PaySheet paySheet, 
			WorkShiftType workShift,
			Department department,
			String name,
			String lastName,
			Gender gender,
			String cpf,
  		  	LocalDate birthDate,
  		  	String telephoneNumber,
  		  	String cellphoneNumber,
  		  	String email,
  		  	Address address, 
  		  	NationalityType nationality, 
  		  	Hospital hospital) {
		super(salary,paySheet,workShift,department,name,lastName,gender,cpf,birthDate,telephoneNumber,cellphoneNumber,email,address,nationality,hospital);
		this.professionalRegistration = Objects.requireNonNull(professionalRegistration, NULL_ERROR_PROFESSIONAL_RESGISTRATION);
		this.specialty = Objects.requireNonNull(specialty, NULL_ERROR_SPECIALTY);
	}



	public Set<Patient> getPatients() {
		return Collections.unmodifiableSet(patients);
	}
	public void addPatient(Patient patient) {
		patients.add(Objects.requireNonNull(patient, "O paciente não pode ser nulo!"));
	}
	public Set<Schedule> getSchedules() {
		return Collections.unmodifiableSet(schedules);
	}
	public void addSchedule(Schedule schedule) {
		schedules.add(Objects.requireNonNull(schedule, "A agenda não pode ser nula!")); 
	}
	
	public Specialty getSpecialty() {
		return specialty;
	}
	public void setSpecialty(Specialty specialty) {
		this.specialty = Objects.requireNonNull(specialty,NULL_ERROR_SPECIALTY);
	}

	public String getProfessionalRegistration() {
		return professionalRegistration;
	}

	public void setProfessionalRegistration(String professionalRegistration) {
		this.professionalRegistration = Objects.requireNonNull(professionalRegistration, NULL_ERROR_PROFESSIONAL_RESGISTRATION);
	}
	
	
}
