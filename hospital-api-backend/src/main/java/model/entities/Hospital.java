package model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="hospitals")
public class Hospital implements Serializable{
	private static final long serialVersionUID = 1L;
	public static final String NULL_ERROR_NAME = "O nome do hospital não pode ser nulo!";
	public static final String NULL_ERROR_ADDRESS= "O endereço do hospital não pode ser nulo!";
	public static final String NULL_ERROR_TELEPHONE= "O telefone do hospital não pode ser nulo!";
	public static final String NULL_ERROR_CONSULTATION_PRICE= "O valor da consulta não pode ser nulo!";
	public static final String NULL_ERROR_HOSPITALIZATION_PRICE= "O valor da internação não pode ser nulo!";
	public static final String NULL_ERROR_HOSPITAL_CASH= "O valor em caixa do hospital não pode ser nulo!";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@OneToOne
	@JoinColumn(name= "address_id", referencedColumnName = "id", nullable = false)
	private Address address;
	@Column(length = 15, nullable =false)
	private String telephone;
	@Column(nullable = false)
	@OneToMany(mappedBy = "hospital")
	private Set<Department> departments = new HashSet<>();
	private BigDecimal consultationPrice = BigDecimal.ZERO;
	@Column(nullable = false)
	private BigDecimal hospitalizationPrice = BigDecimal.ZERO;
	@Column(nullable = false)
	private BigDecimal hospitalCash = BigDecimal.ZERO;
	
	protected Hospital() {}
	
	public Hospital(String name,Address address,String telephone,BigDecimal consultationPrice, BigDecimal hospitalizationPrice,	BigDecimal hospitalCash) {
		this.name = Objects.requireNonNull(name, NULL_ERROR_NAME);
		this.address = Objects.requireNonNull(address, NULL_ERROR_ADDRESS);
		this.telephone = Objects.requireNonNull(telephone, NULL_ERROR_TELEPHONE);
		this.consultationPrice = Objects.requireNonNull(consultationPrice, NULL_ERROR_CONSULTATION_PRICE);
		this.hospitalizationPrice = Objects.requireNonNull(hospitalizationPrice, NULL_ERROR_HOSPITALIZATION_PRICE);
		this.hospitalCash = Objects.requireNonNull(hospitalCash, NULL_ERROR_HOSPITAL_CASH);
	}
	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = Objects.requireNonNull(name, NULL_ERROR_NAME);
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address =Objects.requireNonNull(address, NULL_ERROR_ADDRESS);
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = Objects.requireNonNull(telephone, NULL_ERROR_TELEPHONE);
	}
	
	
	public Set<Department> getDepartments() {
		return Collections.unmodifiableSet(departments);
	}

	public void addDepartments(Set<Department> departments) {
		if(departments == null || departments.isEmpty()) {
			throw new IllegalArgumentException("Os departamentos não podem ser nulos ou vazios!");
		}
		this.departments.addAll(departments);
	}
	
	public void addDepartment(Department department) {
		Objects.requireNonNull(department, "O departamento não pode ser nulo!");
		this.departments.add(department);
	}
	
	public BigDecimal getConsultationPrice() {
		return consultationPrice;
	}
	
	public void setConsultationPrice(BigDecimal consultationPrice) {
		this.consultationPrice = Objects.requireNonNull(consultationPrice, NULL_ERROR_CONSULTATION_PRICE);
	}
	
	public BigDecimal getHospitalizationPrice() {
		return hospitalizationPrice;
	}
	
	public void setHospitalizationPrice(BigDecimal hospitalizationPrice) {
		this.hospitalizationPrice = Objects.requireNonNull(hospitalizationPrice, NULL_ERROR_HOSPITALIZATION_PRICE);
	}
	
	public BigDecimal getHospitalCash() {
		return hospitalCash;
	}
	
	public void addHospitalCash(BigDecimal hospitalCash) {
		this.hospitalCash.add(Objects.requireNonNull(hospitalCash, NULL_ERROR_HOSPITAL_CASH));
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
		Hospital other = (Hospital) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
