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
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import model.enums.Gender;
import model.enums.NationalityType;
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name= "persons")
public abstract class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(name = "last_name",nullable = false)
	private String lastName;
	
	@Enumerated(value= EnumType.STRING)
	@Column(nullable = false)
	private NationalityType nationality;
	
	@NotNull(message= "O gênero é obrigatório")
	@Enumerated(value= EnumType.STRING)
	@Column(nullable = false)
	private Gender gender;
	
	@Column(nullable = false)
	private String cpf;
	
	@Column(name = "birth_date",nullable = false)
	private LocalDate birthDate;
	
	@Column(name = "telephone_number")
	private String telephoneNumber;
	
	@Column(name = "cellphone_number", nullable = false)
	private String cellphoneNumber;
	
	@Column(nullable = false)
	private String email;
	
	@Embedded
	@Column(nullable = false)
	private Address address;
	
	@OneToOne
	@JoinColumn(name = "hospital_id", referencedColumnName = "id", nullable = false)
	private Hospital hospital;
	
	protected Person() {}
	
	public Person(
			String name,String lastName,Gender gender,String cpf,LocalDate birthDate,String telephoneNumber,
			String cellphoneNumber,String email,Address address, NationalityType nationality,Hospital hospital) {
		this.name = Objects.requireNonNull(name, "O nome não pode ser nulo!");
		this.lastName = Objects.requireNonNull(lastName, "O sobrenome não pode ser nulo!");
		this.gender = Objects.requireNonNull(gender, "O sexo não pode ser nulo!");
		this.cpf = Objects.requireNonNull(cpf, "O CPF não pode ser nulo");
		this.birthDate = Objects.requireNonNull(birthDate, "A data de nascimento não pode ser nula!");
		this.telephoneNumber = telephoneNumber;
		this.cellphoneNumber = Objects.requireNonNull(cellphoneNumber, "O celular não pode ser nulo!");
		this.email = Objects.requireNonNull(email, "O email não pode ser nulo!");
		this.address = Objects.requireNonNull(address, "O endereço não pode ser nulo!");
		this.nationality = Objects.requireNonNull(nationality);
		this.hospital = Objects.requireNonNull(hospital, "O hospital não pode ser nulo!");
	
	}
	

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = Objects.requireNonNull(name, "O nome não pode ser nulo!");
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = Objects.requireNonNull(lastName, "O sobrenome não pode ser nulo!");
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = Objects.requireNonNull(gender, "O sexo não pode ser nulo!");
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = Objects.requireNonNull(cpf, "O CPF não pode ser nulo");
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = Objects.requireNonNull(birthDate, "A data de nascimento não pode ser nula!");
	}
	public String getTelephoneNumber() {
		return telephoneNumber;
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	public String getCellphoneNumber() {
		return cellphoneNumber;
	}
	public void setCellphoneNumber(String cellphoneNumber) {
		this.cellphoneNumber = Objects.requireNonNull(cellphoneNumber, "O celular não pode ser nulo!");
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = Objects.requireNonNull(email, "O email não pode ser nulo!");
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = Objects.requireNonNull(address, "O endereço não pode ser nulo!");
	}
	
	public NationalityType getNationality() {
		return nationality;
	}

	public void setNationality(NationalityType nationality) {
		this.nationality = Objects.requireNonNull(nationality, "A nacionalidade não pode ser nula!");;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = Objects.requireNonNull(hospital, "O hospital não pode ser nulo!");
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
		Person other = (Person) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
