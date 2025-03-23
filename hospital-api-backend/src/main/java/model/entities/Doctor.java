package model.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import model.enums.Gender;
import model.enums.Specialty;
import model.enums.WorkShiftType;
@Entity
@Table(name= "doctors")
public class Doctor extends Employee{
	@ElementCollection
	@CollectionTable(name= "doctors_patients",joinColumns = @JoinColumn(name="doctor_id"))
	private List<Patient> patients;
	@ElementCollection
	@CollectionTable(name="doctors_schedules", joinColumns = @JoinColumn(name="doctor_id"))
	private List<Schedule> schedules;
	@Column(name= "professional_registration", nullable = false, unique = true)
	private String professionalRegistration;//CRM, NPI, GMC, etc...
	@Enumerated(value=EnumType.STRING)
	private Specialty specialty;
	
	
	protected Doctor() {}
	
	
	
	public Doctor(List<Patient> patients, List<Schedule> schedules, String professionalRegistration,Specialty specialty,
			BigDecimal salary, PaySheet paySheet, WorkShiftType workShift,Department department,String name,String lastName,Gender gender,String cpf,
			LocalDate birthDate,String telephoneNumber,String cellphoneNumber,String email,Address address, Hospital hospital) {
		super(salary,paySheet,workShift,department,name,lastName,gender,cpf,birthDate,telephoneNumber,cellphoneNumber,email,address,hospital);
		this.patients = patients;
		this.schedules = schedules;
		this.professionalRegistration = professionalRegistration;
		this.specialty = specialty;
	}



	public List<Patient> getPatients() {
		return patients;
	}
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	public List<Schedule> getSchedules() {
		return schedules;
	}
	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}
	public Specialty getSpeciallty() {
		return specialty;
	}
	public void setSpeciallty(Specialty speciallty) {
		this.specialty = speciallty;
	}

	public String getProfessionalRegistration() {
		return professionalRegistration;
	}

	public void setProfessionalRegistration(String professionalRegistration) {
		this.professionalRegistration = professionalRegistration;
	}
	
	
}
