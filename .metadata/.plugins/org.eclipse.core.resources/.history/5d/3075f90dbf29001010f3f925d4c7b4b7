package validation.annotations;

import jakarta.validation.Payload;

public @interface PhysicalAndComplementaryExamValidation {
	String message() default "É necessário informar os resultados do exame físico se o ScheduleType for PRESENTIAL";
	Class<?>[] group() default{};
	Class<? extends Payload>[] Payload() default{};
}
