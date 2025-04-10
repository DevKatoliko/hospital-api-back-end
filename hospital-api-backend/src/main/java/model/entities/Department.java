package model.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import model.enums.DepartmentType;
@Entity
@Table(name = "departments")
public class Department implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final String NULL_ERROR_MESSAGE_DEPARTMENT_TYPE = "O tipo de departamento não pode ser nulo!";
	private static final String NULL_ERROR_MESSAGE_FLOOR_NUMBER = "O numero do andar não pode ser nulo!";
	private static final String NULL_ERROR_MESSAGE_NUMBER_OF_BEDS = "O numero de leitos não pode ser nulo!";
	private static final String NULL_ERROR_MESSAGE_RESPONSABLE_DOCTOR = "O numero de leitos não pode ser nulo!";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "Hospital", referencedColumnName = "id")
	private Hospital hospital;
	
	@Enumerated(value = EnumType.STRING)
	@Column(nullable = false)
	private DepartmentType departmentType;
	
	@Column(name = "floor_number", nullable = false)
	private int floorNumber;
	
	@Column(name = "number_of_beds", nullable = false)
	private int numberOfBeds;
	
	@OneToMany(mappedBy = "department")
	private Set<Nurse> nurses = new HashSet<>();
	
	@OneToMany(mappedBy = "department")
	private Set<Doctor> doctors = new HashSet<>();
	
	@OneToMany(mappedBy = "department")
	private Set<Patient> hospitalizedPatients = new HashSet<>();	
	
	@OneToOne
	@JoinColumn(name="responsable_doctor_id", referencedColumnName = "id")
	private Doctor responsableDoctor;
	
	protected Department() {}
	
	public Department(DepartmentType departmentType, int floorNumber, int numberOfBeds, Set<Nurse> nurses,
			Set<Doctor> doctors, Set<Patient> hospitalizedPatients, Doctor responsableDoctor) {
		this.departmentType = Objects.requireNonNull(departmentType, NULL_ERROR_MESSAGE_DEPARTMENT_TYPE);
		this.floorNumber = Objects.requireNonNull(floorNumber, NULL_ERROR_MESSAGE_FLOOR_NUMBER);
		if(floorNumber < 0) throw new IllegalArgumentException("O número do andar não pode ser negativo!");
		this.numberOfBeds = Objects.requireNonNull(numberOfBeds, NULL_ERROR_MESSAGE_NUMBER_OF_BEDS);
		if(numberOfBeds <= 0) throw new IllegalArgumentException("O número de leitos não pode ser negativo!");
	}
	public Long getId() {
		return id;
	}

	public DepartmentType getDepartmentType() {
		return departmentType;
	}
	public void setDepartmentType(DepartmentType departmentType) {
		this.departmentType =  Objects.requireNonNull(departmentType, NULL_ERROR_MESSAGE_DEPARTMENT_TYPE);
	}
	public int getFloorNumber() {
		return floorNumber;
	}
	public void setFloorNumber(int floorNumber) {
		this.floorNumber = Objects.requireNonNull(floorNumber, NULL_ERROR_MESSAGE_FLOOR_NUMBER);
		if(floorNumber < 0) throw new IllegalArgumentException("O número do andar não pode ser negativo!");
	}
	public int getNumberOfBeds() {
		return numberOfBeds;
	}
	public void setNumberOfBeds(int numberOfBeds) {
		this.numberOfBeds = Objects.requireNonNull(numberOfBeds, NULL_ERROR_MESSAGE_NUMBER_OF_BEDS);;
	}
	public Set<Nurse> getNurses() {
		return Collections.unmodifiableSet(nurses);
	}
	public void addNurse(Nurse nurse) {
		nurses.add(Objects.requireNonNull(nurse));
	}
	public Set<Doctor> getDoctors() {
		return Collections.unmodifiableSet(doctors);
	}
	public void addDoctor(Doctor doctor) {
		doctors.add(Objects.requireNonNull(doctor, "O médico não pode ser nulo!")) ;
	}
	public Set<Patient> getHospitalizedPatients() {
		return Collections.unmodifiableSet(hospitalizedPatients);
	}
	public void addHospitalizedPatient(Patient hospitalizedPatient) {
		hospitalizedPatients.add(Objects.requireNonNull(hospitalizedPatient, "O paciente não pode ser nulo"));
	}
	public Doctor getResponsableDoctor() {
		return responsableDoctor;
	}
	public void setResponsableDoctor(Doctor responsableDoctor) {
		this.responsableDoctor = Objects.requireNonNull(responsableDoctor, NULL_ERROR_MESSAGE_RESPONSABLE_DOCTOR);
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
		Department other = (Department) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
