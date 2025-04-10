package dtos.creations;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import model.enums.PaySheetStatus;

public record PaySheetCreationDTO(
		@NotNull(message = "É necessário informar o funcionário!")
		Long employeeId, 
		@NotNull(message = "É necessário informar o valor do pagamento!")
		BigDecimal payValue, 
		@NotNull(message = "É necessário informar a data de pagamento!")
		LocalDate payDate,
		@NotNull(message = "É necessário informar o status da folha de pagamento!")
		PaySheetStatus paySheetStatus) {

}
