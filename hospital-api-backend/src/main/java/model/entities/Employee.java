package model.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import model.enums.Gender;
import model.enums.WorkShiftType;
@Entity
@Table(name= "Employees")
public abstract class Employee extends Person{
	private BigDecimal salary;
	@OneToOne
	@JoinColumn(name="paySheet_id", referencedColumnName = "id", nullable=false)
	private PaySheet paySheet;
	public PaySheet getPaySheet() {
		return paySheet;
	}

	public void setPaySheet(PaySheet paySheet) {
		this.paySheet = paySheet;
	}

	@Enumerated(value = EnumType.STRING)
	private WorkShiftType workShift;
	@OneToOne
	@JoinColumn(name ="departament_id", referencedColumnName = "id")
	private Department department;
	
	
	protected Employee() {
		super();
	}

	public Employee(BigDecimal salary, PaySheet paySheet,WorkShiftType workShift, Department department,String name,String lastName,Gender gender,String cpf,LocalDate birthDate,String telephoneNumber,
			String cellphoneNumber,String email,Address address, Hospital hospital) {
		super(name,lastName,gender,cpf,birthDate,telephoneNumber,cellphoneNumber,email,	address, hospital);
		this.salary = salary;
		this.paySheet = paySheet;
		this.department = department;
		this.workShift = workShift;
	}

	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public PaySheet getPaysheet() {
		return paySheet;
	}
	public void setPaysheet(PaySheet PaySheet) {
		this.paySheet = PaySheet;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}

	public WorkShiftType getWorkShift() {
		return workShift;
	}

	public void setWorkShift(WorkShiftType workShift) {
		this.workShift = workShift;
	}
	
}
