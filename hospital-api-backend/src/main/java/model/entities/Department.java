package model.entities;

import java.util.List;

import model.enums.DepartmentType;

public class Department {
	private Long id;
	private DepartmentType departmentType;
	private String floorNumber;
	private int numberOfBeds;
	private List<Nurse> nurses;
	private List<Doctor> doctors;
	private List<Patient> hospitalizedPatients;
	private Doctor responsableDoctor;
	private Administrator administrator;
}
