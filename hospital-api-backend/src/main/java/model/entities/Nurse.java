package model.entities;

import java.math.BigDecimal;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import model.enums.Gender;
import model.enums.NationalityType;
import model.enums.WorkShiftType;

@Entity
@Table(name = "nurses")
public class Nurse extends Employee {
	private static final long serialVersionUID = 1L;
	@Column(name = "coren_register", nullable= false, unique = true)
	private String corenRegister;
	@OneToOne
	@JoinColumn(name ="doctor_id", referencedColumnName = "id", nullable = false)
	private Doctor supervisingDoctor;
	
	protected Nurse() {
		super();
	}
	public Nurse(String corenRegister, Doctor supervisingDoctor, BigDecimal salary, PaySheet paySheet, WorkShiftType workShift,Department department,String name,String lastName,Gender gender,String cpf,
			LocalDate birthDate,String telephoneNumber,String cellphoneNumber,String email,Address address, NationalityType nationality,Hospital hospital) {
		super(salary,paySheet,workShift,department,name,lastName,gender,cpf,birthDate,telephoneNumber,cellphoneNumber,email,address,nationality,hospital);
		this.corenRegister = Objects.requireNonNull(corenRegister, "O registro COREN não pode ser nulo!");
		this.supervisingDoctor = Objects.requireNonNull(supervisingDoctor, "O médico supervisor não pode ser nulo!");
	}

	public String getCorenRegister() {
		return corenRegister;
	}

	public void setCorenRegister(String corenRegister) {
		this.corenRegister = Objects.requireNonNull(corenRegister,"O registro COREN não pode ser nulo!");
	}

	public Doctor getSupervisingDoctor() {
		return supervisingDoctor;
	}

	public void setSupervisingDoctor(Doctor supervisingDoctor) {
		this.supervisingDoctor = Objects.requireNonNull(supervisingDoctor,"O médico supervisor não pode ser nulo!");
	}
	
	
}
