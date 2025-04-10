package dtos.creations;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import model.enums.DepartmentType;

public record DepartmentCreationDTO(
		@NotNull(message = "O tipo de departamento não pode ser nulo!")
		DepartmentType departmentType, 
		@PositiveOrZero(message = "O número do andar não pode ser negaativo!")
		int floorNumber, 
		@PositiveOrZero(message = "O número leitos não pode ser negativo!")
		int numberOfBeds, 
		@NotNull(message = "É necessário informar o hospital!")
		Long hospitalId) {

}
