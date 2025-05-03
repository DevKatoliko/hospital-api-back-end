package dtos.responses;

import model.entities.Address;

public record AddressResponseDTO(String state, String city, String street,String number, String zipCode, String complement) {
	public static AddressResponseDTO fromAddress(Address address) {
		return new AddressResponseDTO(address.getState(), address.getCity(), address.getStreetName(), address.getNumber(),address.getZipCode(), address.getComplement());
	}
}
