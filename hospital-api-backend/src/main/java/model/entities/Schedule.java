package model.entities;

import java.time.LocalDate;

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
import model.enums.ConsultType;
@Entity
@Table(name = "schedules")
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate date;
	@Enumerated(value = EnumType.STRING)
	private ConsultType consultType;
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
	
	public Schedule(LocalDate date, ConsultType consultTipe, Address address, Patient patient, Doctor doctor) {
		this.date = date;
		this.consultType = consultTipe;
		this.address = address;
		this.patient = patient;
		this.doctor = doctor;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public ConsultType getConsultType() {
		return consultType;
	}
	public void setConsultType(ConsultType consultType) {
		this.consultType = consultType;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public String getTeleconsultationLink() {
		return teleconsultationLink;
	}
	public void setTeleconsultationLink(String teleconsultationLink) {
		this.teleconsultationLink = teleconsultationLink;
	}
	
	
}
