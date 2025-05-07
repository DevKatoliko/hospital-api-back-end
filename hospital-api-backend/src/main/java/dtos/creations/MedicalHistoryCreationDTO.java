package dtos.creations;

import java.util.Set;

import annotations.validation.MedicationUserValidation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import model.enums.BloodType;

@MedicationUserValidation
public record MedicalHistoryCreationDTO(
		@Positive(message = "O peso não pode ser zero ou negativo!")
		double weight, 
		@Positive(message = "A altura não pode ser zero ou negativa!")
		double height, 
		@NotNull(message = "O tipo sanguíneo é obrigatório!")
		BloodType bloodType, 
		boolean smoker, 
		boolean alcoholConsumer,
		boolean physicalExerciser, 
		boolean medicationUser, 
		Set<String> medicinesUsedInformation,
		@NotBlank(message = "É necessário informar o histórico médico familiar!")
		String familyHealthHistory, 
		@NotBlank(message = "É necessário informar o histórico pessoal!")
		String patientHealthHistory, 
		@NotNull(message = "É necessário informar as cirurgias que já realizou!")
		Set<String> surgeriesHistory,
		@NotNull(message = "É necessário informar doenças crônicas se as tiver!")
		Set<String> chronicDiseasesInformation, 
		@NotNull(message = "É necessário informar os sintomoas que já teve!")
		Set<String> patientSymptoms, 
		@NotNull(message = "É necessário informar os diagnósticos já feitos!")
		Set<String> diagnostics,
		@NotNull(message = "É necessário dar as informações de internações que passou!")
		Set<String> hospitalizations) {

}
