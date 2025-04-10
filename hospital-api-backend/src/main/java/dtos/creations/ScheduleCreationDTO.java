package dtos.creations;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import model.enums.HospitalServiceType;
import model.enums.ScheduleType;
/*The service class will get the id of the user that is a patient and create a new schedule with this patient.
 * Then it will select a doctor that fill the hospital service required and insert him in the schedule.
 * After that, based on the schedule type it will return the hospital address as default address of a schedule or 
 * the link for a video meeting that will happens on the schedule's date.
 * */
public record ScheduleCreationDTO(
		@NotNull(message = "É necessário definir uma data para o agendamento!")
		LocalDate date,
		@NotNull(message = "É necessário informar o tipo de agendamento!")
		ScheduleType scheduleType,
		@NotNull(message = "É necessário informar qual o tipo de atendimento médico desejado!")
		HospitalServiceType hospitalServiceType) {

}
