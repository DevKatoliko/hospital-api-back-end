package model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name= "patients")
public class Patient extends Person{
	private String profession;
	@Column(name="mothers_name")
	private String mothersName;
	@OneToOne(mappedBy = "patient")
	private MedicalRecord medicalRecord;
	
	protected  Patient() {
		
	}

	public Patient(String profession, String mothersName) {
		this.profession = profession;
		this.mothersName = mothersName;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getMothersName() {
		return mothersName;
	}

	public void setMothersName(String mothersName) {
		this.mothersName = mothersName;
	}

	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}
	
	
}
