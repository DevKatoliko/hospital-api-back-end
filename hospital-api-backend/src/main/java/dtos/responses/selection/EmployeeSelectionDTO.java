package dtos.responses.selection;

import model.entities.Employee;

public record EmployeeSelectionDTO(Long id, String name, String lastName) {
	public static EmployeeSelectionDTO fromEmployee(Employee employee) {
		return new EmployeeSelectionDTO(employee.getId(), employee.getName(), employee.getLastName());
	}
}
