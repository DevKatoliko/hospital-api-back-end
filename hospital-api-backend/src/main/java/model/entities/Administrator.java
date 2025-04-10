package model.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import model.enums.Gender;
import model.enums.NationalityType;
import model.enums.WorkShiftType;
@Entity
@Table(name = "administrators")
public class Administrator extends Employee {
	private static final long serialVersionUID = 1L;
	@ElementCollection
	@CollectionTable(name = "bill_reports", joinColumns = @JoinColumn(name = "administrator_id"))
	private Set<String> billReports = new HashSet<>();
	@ElementCollection
	@CollectionTable(name = "pay_sheet_reports", joinColumns = @JoinColumn(name = "administrator_id"))
	private Set<String> paySheetReports = new HashSet<>();
	@ElementCollection
	@CollectionTable(name = "department_reports", joinColumns = @JoinColumn(name = "administrator_id"))
	private Set<String> departmentReports = new HashSet<>();
	
	protected Administrator() {
		super();
	}
	public Administrator(BigDecimal salary, PaySheet paySheet, WorkShiftType workShift,Department department,String name,String lastName,Gender gender,String cpf,
			LocalDate birthDate,String telephoneNumber,String cellphoneNumber,String email,Address address,NationalityType nationality ,Hospital hospital) {
		super(salary,paySheet,workShift,department,name,lastName,gender,cpf,birthDate,telephoneNumber,cellphoneNumber,email,address,nationality,hospital);
	}

	public Set<String> getBillReports() {
		return Collections.unmodifiableSet(billReports);
	}

	public void addBillReport(String billReport) {
		this.billReports.add(Objects.requireNonNull(billReport));
	}

	public Set<String> getPaySheetReports() {
		return Collections.unmodifiableSet(paySheetReports);
	}

	public void addPaySheetReport(String paySheetReport) {
		this.paySheetReports.add(Objects.requireNonNull(paySheetReport)) ;
	}

	public Set<String> getDepartmentReports() {
		return Collections.unmodifiableSet(departmentReports);
	}

	public void addDepartmentReport(String departmentReport) {
		departmentReports.add(Objects.requireNonNull(departmentReport));
	}
	
	
}
