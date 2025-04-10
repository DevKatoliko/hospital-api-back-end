package model.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address implements Serializable{

	private static final long serialVersionUID = 1L;

	private String city;
	
	private String state;
	
	private String streetName;
	
	private String neighborhood;
	
	private String number;
	
	private String zipCode;
	
	private String complement;
	
	protected Address() {
	}
	
	public Address(
			String city,
			String state,
			String streetName,
			String neighborhood,
			String number,
			String zipCode,
			String complement) {
		this.city = city;
		this.state = state;
		this.streetName = streetName;
		this.neighborhood = neighborhood;
		this.number = number;
		this.zipCode = zipCode;
		this.complement = complement;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, complement, neighborhood, number, state, streetName, zipCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(city, other.city) && Objects.equals(complement, other.complement)
				&& Objects.equals(neighborhood, other.neighborhood) && Objects.equals(number, other.number)
				&& Objects.equals(state, other.state) && Objects.equals(streetName, other.streetName)
				&& Objects.equals(zipCode, other.zipCode);
	}

	
}
