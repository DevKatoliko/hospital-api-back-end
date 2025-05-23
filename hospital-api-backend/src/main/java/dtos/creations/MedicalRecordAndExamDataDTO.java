package dtos.creations;

import java.time.LocalDate;
import java.util.Set;

import annotations.validation.PhysicalAndComplementaryExamValidation;
import jakarta.validation.constraints.NotNull;
import model.enums.ScheduleType;

/*This DTO class will contain the basic information for creating a Medical record that will be created by a service class.
 * The final medical record DTO will contain the information for the creation of a prescription and the final diagnostic that will be
 * inserted in the MedicalRecord class*/
@PhysicalAndComplementaryExamValidation
public record MedicalRecordAndExamDataDTO(
		/*
		 * The ScheduleType is required to know if a physical exam was done or not. If
		 * even with a in person meeting there was no physical exam, the doctor must
		 * inform that.
		 */
		@NotNull(message = "É necessário informar qual o tipo de agendamento!") ScheduleType scheduleType,
		@NotNull(message = "É necessário informar quais são os sintomas do paciente!") Set<String> symptoms,
		String physicalExam,
		@NotNull(message = "É necesssário informar qual o diagnóstico hipotético!") String hypotheticalDiagnostic,
		@NotNull(message = "É necesssário informar a data da consulta!") LocalDate examDate,
		Set<String> complementaryExams,
		@NotNull(message = "É necessário informar as observações médicas")String doctorObservations,
		@NotNull(message = "É necesssário informar o paciente!") Long patientId) {

}
