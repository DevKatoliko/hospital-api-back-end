package model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import model.enums.HospitalServiceType;
import model.enums.ScheduleType;
@Entity
@Table(name = "schedules")
public class Schedule implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final String NULL_ERROR_DATE = "A data da consulta não pode ser nula!";
	private static final String NULL_ERROR_CONSULT_TYPE = "O tipo de consulta não pode ser nulo!";
	private static final String NULL_ERROR_PATIENT = "O paciente não pode ser nulo!";
	private static final String NULL_ERROR_DOCTOR = "O médico não pode ser nulo!";
	private static final String NULL_ERROR_HOSPITAL_SERVICE_TYPE = "O tipo de atendimento não pode ser nulo!";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	@NotNull(message = "A data da consulta não pode ser nula!")
	private LocalDate date;
	@Enumerated(value = EnumType.STRING)
	@Column(nullable = false)
	@NotNull(message = NULL_ERROR_CONSULT_TYPE)
	private ScheduleType scheduleType;
	@Enumerated(value = EnumType.STRING)
	@Column(name = "hospital_service_type",nullable = false)
	@NotNull(message = NULL_ERROR_HOSPITAL_SERVICE_TYPE)
	private HospitalServiceType hospitalServiceType;
	@Embedded
	private Address address;
	@Column(name = "teleconsultation_link")
	private String teleconsultationLink;
	@ManyToOne
	@JoinColumn(name="patient_id", referencedColumnName = "id")
	private Patient patient;
	@ManyToOne
	@JoinColumn(name="doctor_id", referencedColumnName = "id")
	private Doctor doctor;
	
	// The address or the link for tele-consultation are added after the schedule been created
	public Schedule(LocalDate date, ScheduleType scheduleType,HospitalServiceType hospitalServiceType ,Patient patient, Doctor doctor) {
	    this.date = Objects.requireNonNull(date, NULL_ERROR_DATE);
	    this.scheduleType = Objects.requireNonNull(scheduleType, NULL_ERROR_CONSULT_TYPE);
	    this.hospitalServiceType = Objects.requireNonNull(hospitalServiceType, NULL_ERROR_HOSPITAL_SERVICE_TYPE);
	    this.patient = Objects.requireNonNull(patient, NULL_ERROR_PATIENT);
	    this.doctor = Objects.requireNonNull(doctor, NULL_ERROR_DOCTOR);
	}

	public Long getId() {
		return id;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
	    this.date = Objects.requireNonNull(date, NULL_ERROR_DATE);
	}
	public ScheduleType getScheduleType() {
		return scheduleType;
	}
	public void setScheduleType(ScheduleType scheduleType) {
	    this.scheduleType = Objects.requireNonNull(scheduleType, NULL_ERROR_CONSULT_TYPE);
	}
	
	public HospitalServiceType getHospitalServiceType() {
		return hospitalServiceType;
	}

	public void setHospitalServiceType(HospitalServiceType hospitalServiceType) {
		this.hospitalServiceType = Objects.requireNonNull(hospitalServiceType, NULL_ERROR_HOSPITAL_SERVICE_TYPE);
	}

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = Objects.requireNonNull(address);
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
	    this.patient = Objects.requireNonNull(patient, NULL_ERROR_PATIENT);
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
	    this.doctor = Objects.requireNonNull(doctor, NULL_ERROR_DOCTOR);
	}
	public String getTeleconsultationLink() {
		return teleconsultationLink;
	}
	public void setTeleconsultationLink(String teleconsultationLink) {
		this.teleconsultationLink = teleconsultationLink;
	}
	public String getPresentialAddressInformation() {
		StringBuilder bd = new StringBuilder();
		bd.append(
				"Estado: " + address.getState() +
				"\nCidade: " + address.getCity() + 
				"\nBairro: "+ address.getNeighborhood() +
				"\nRua: " + address.getStreetName() +
				"\nNumero: "+ address.getNumber());
		return bd.toString();
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
		Schedule other = (Schedule) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
