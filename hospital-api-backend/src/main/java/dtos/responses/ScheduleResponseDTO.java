package dtos.responses;

import java.time.LocalDate;

import model.entities.Schedule;
import model.enums.ScheduleType;

public record ScheduleResponseDTO(String patientName, String doctorName, LocalDate date, String address) {
	
	public static ScheduleResponseDTO presentialSchedule(Schedule s) {
		if(s.getScheduleType().equals(ScheduleType.ONLINE)) 
			throw new IllegalArgumentException("O agendamento não é presencial!");
		
		return new ScheduleResponseDTO(s.getPatient().getName(), s.getDoctor().getName(), s.getDate(),s.getPresentialAddressInformation());
	}
	
	public static ScheduleResponseDTO onlineSchedule(Schedule s) {
		if(s.getScheduleType().equals(ScheduleType.PRESENTIAL)) 
			throw new IllegalArgumentException("O agendamento não é online!"); 
		
		return new ScheduleResponseDTO(s.getPatient().getName(), s.getDoctor().getName(), s.getDate(),s.getTeleconsultationLink());
	}
}
