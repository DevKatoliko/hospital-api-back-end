package model.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import model.enums.BillType;
@Entity
@Table(name = "bills")
public class Bill implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	@JoinColumn(name ="hospital_id", referencedColumnName = "id", nullable = false)
	@NotNull(message = "O hospital não pode ser nulo!")
	private Hospital hospital;
	@Enumerated(value = EnumType.STRING)
	@Column(nullable = false)
	@NotNull(message = "O tipo de conta não pode ser nulo!")
	private BillType billType;
	@Column(nullable = false)
	@NotNull(message = "O status da conta não pode ser nulo!")
	private boolean paid;
	@Column(nullable = false)
	@NotNull(message = "O valor da conta não pode ser nulo!")
	@Digits(integer = 10, fraction = 2)
	private BigDecimal value;
	@Column(name ="due_date", nullable = false)
	@NotNull(message = "A data de vencimento da conta não pode ser nula!")
	private LocalDate dueDate;
	
	protected Bill() {
		
	}
	
	public Bill(Hospital hospital, BillType billType, boolean paid, BigDecimal value, LocalDate dueDate) {
		this.hospital = Objects.requireNonNull(hospital, "O hospital não pode ser nulo!");
		this.billType = Objects.requireNonNull(billType, "O tipo de conta não pode ser nulo!");
		this.paid = Objects.requireNonNull(paid, "O status da conta não pode ser nulo!");
		this.value = Objects.requireNonNull(value, "O valor da conta não pode ser nulo!");
		if (this.value.compareTo(BigDecimal.ZERO) < 0) {
		    throw new IllegalArgumentException("O valor da conta não pode ser negativo!");
		}
		this.dueDate = Objects.requireNonNull(dueDate, "A data de vencimento da conta não pode ser nula!");
	}
	public Long getId() {
		return id;
	}

	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = Objects.requireNonNull(hospital,"O hospital não pode ser nulo!");
	}
	public BillType getBillType() {
		return billType;
	}
	public void setBillType(BillType billType) {
		this.billType = Objects.requireNonNull(billType, "O tipo de conta não pode ser nulo!");
	}
	public boolean isPaid() {
		return paid;
	}
	public void markAsPaid(boolean paid) {
		this.paid = Objects.requireNonNull(paid,"O status da conta não pode ser nulo!");
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setBillValue(BigDecimal value) {
		this.value = Objects.requireNonNull(value, "O valor da conta não pode ser nulo!");
		if (this.value.compareTo(BigDecimal.ZERO) < 0) {
		    throw new IllegalArgumentException("O valor da conta não pode ser negativo!");
		}
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = Objects.requireNonNull(dueDate, "A data de vencimento da conta não pode ser nula!");
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
		Bill other = (Bill) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
