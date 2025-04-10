package validation.annotations;

import jakarta.validation.Payload;

public @interface MedicationUserValidation {
	String message() default "É necessário informar os medicamentos usados se medicationUser for verdadeiro";
	Class<?>[] group() default{};
	Class<? extends Payload>[] payload() default{};
}
