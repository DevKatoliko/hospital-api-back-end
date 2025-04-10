package dtos.creations;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PrescriptionCreationDTO(
		@NotBlank(message = "É necessário informar os detalhes sobre a medicação prescrita!") String medicationDetail,
		@NotBlank(message = "É necessário informar as instruções para o farmacêutico!") String pharmacistInstruction,
		@NotBlank(message = "É necessário informar as instruções de uso!") String usageInstruction,
		String additionalInformation,
		@NotNull(message = "É necessário informar a data da prescrição!") LocalDate prescriptionDate,
		@NotBlank(message = "É necessário informar para qual paciente é a prescrição!") Long patientId) {

}
