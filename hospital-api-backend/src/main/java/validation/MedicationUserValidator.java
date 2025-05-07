package validation;

import annotations.validation.MedicationUserValidation;
import dtos.creations.MedicalHistoryCreationDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MedicationUserValidator implements ConstraintValidator<MedicationUserValidation,MedicalHistoryCreationDTO >{

	@Override
	public boolean isValid(MedicalHistoryCreationDTO dto, ConstraintValidatorContext context) {
		if(dto.medicationUser() && dto.medicinesUsedInformation() == null || dto.medicinesUsedInformation().isEmpty()) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("É necessário informar os medicamentos que utiliza!")
			.addPropertyNode("medicinesUsedInformation")
			.addConstraintViolation();
			return false;
		}
		return true;
	}

}
