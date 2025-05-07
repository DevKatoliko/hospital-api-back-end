package validation;

import annotations.validation.PhysicalAndComplementaryExamValidation;
import dtos.creations.MedicalRecordAndExamDataDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import model.enums.ScheduleType;

public class PhysicalAndComplementaryExamValidator implements ConstraintValidator<PhysicalAndComplementaryExamValidation,MedicalRecordAndExamDataDTO>{

	@Override
	public boolean isValid(MedicalRecordAndExamDataDTO dto, ConstraintValidatorContext context) {
		if(dto.scheduleType().equals(ScheduleType.PRESENTIAL) && dto.physicalExam() == null || dto.physicalExam().equals("")) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("É necessário informar os dados do exame físico!")
			.addPropertyNode("physicalExam").addConstraintViolation();
			return false;
		}
		if(dto.scheduleType().equals(ScheduleType.PRESENTIAL) && dto.complementaryExams() == null || dto.complementaryExams().isEmpty()) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("É necessário informar os dados de exames complementares!")
			.addPropertyNode("complementaryExams").addConstraintViolation();
			return false;
		}
		return true;
	}

}
