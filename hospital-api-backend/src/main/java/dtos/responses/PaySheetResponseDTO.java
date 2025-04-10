package dtos.responses;

import java.math.BigDecimal;
import java.time.LocalDate;

import model.entities.PaySheet;
import model.enums.PaySheetStatus;

public record PaySheetResponseDTO(String employeeName, BigDecimal value, LocalDate paySheetDate, PaySheetStatus status ) {
	public static PaySheetResponseDTO fromPaySheet(PaySheet paySheet) {
		return new PaySheetResponseDTO(paySheet.getEmployee().getName(), paySheet.getPayValue(), paySheet.getPayDate(), paySheet.getStatus());
	}
	
}
