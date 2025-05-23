package dtos.creations;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MedicalRecordAndExamDataFinalDTO(
		@NotNull(message = "É necessário informar os resulados medidos nos exames") Set<String> examMeasuresResult,
		@NotBlank(message = "É necessário informar quais métodos utilizados para os exames") String methods,
		@NotBlank(message = "É necessário informar o diagnóstico final!") String finalDiagnostic,
		@NotNull(message = "É necesssário informar o paciente!") Long patientId) {

}
