package model.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import model.enums.Gender;
import model.enums.NationalityType;
import model.enums.WorkShiftType;
@Entity
@Table(name= "employees")
public abstract class Employee extends Person{
	private static final long serialVersionUID = 1L;
	public static final String NULL_ERROR_SALARY = "O salario não pode ser nulo!";
	public static final String NULL_ERROR_PAY_SHEET= "A folha de pagamento não pode ser nula!";
	public static final String NULL_ERROR_WORK_SHIFT = "O periodo de trabalho não pode ser nulo!";
	public static final String NULL_ERROR_DEPARTMENT = "O departamento não pode ser nulo!";
	@Column(nullable = false)
	
	private BigDecimal salary = BigDecimal.ZERO;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="paySheet_id", referencedColumnName = "id", nullable = false)
	@NotNull(message = NULL_ERROR_PAY_SHEET)
	private PaySheet paySheet;
	@Enumerated(value = EnumType.STRING)
	@NotNull(message = NULL_ERROR_DEPARTMENT)
	private WorkShiftType workShift;
	@ManyToOne
	@JoinColumn(name ="departament_id", referencedColumnName = "id")
	private Department department;
	
	protected Employee() {
		super();
	}

	public Employee(BigDecimal salary, PaySheet paySheet,WorkShiftType workShift, Department department,String name,String lastName,Gender gender,String cpf,LocalDate birthDate,String telephoneNumber,
			String cellphoneNumber,String email,Address address, NationalityType nationality, Hospital hospital) {
		super(name,lastName,gender,cpf,birthDate,telephoneNumber,cellphoneNumber,email,	address, nationality, hospital);
		this.salary = Objects.requireNonNull(salary,NULL_ERROR_SALARY);
		this.paySheet = Objects.requireNonNull(paySheet,NULL_ERROR_PAY_SHEET);
		this.department = Objects.requireNonNull(department, NULL_ERROR_DEPARTMENT);
		this.workShift = Objects.requireNonNull(workShift, NULL_ERROR_WORK_SHIFT);
	}
	
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = Objects.requireNonNull(salary,NULL_ERROR_SALARY);
	}
	public PaySheet getPaysheet() {
		return paySheet;
	}
	public void setPaysheet(PaySheet PaySheet) {
		this.paySheet = Objects.requireNonNull(paySheet,NULL_ERROR_PAY_SHEET);
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = Objects.requireNonNull(department, NULL_ERROR_DEPARTMENT);
	}

	public WorkShiftType getWorkShift() {
		return workShift;
	}

	public void setWorkShift(WorkShiftType workShift) {
		this.workShift = Objects.requireNonNull(workShift, NULL_ERROR_WORK_SHIFT);
	}
	
}
