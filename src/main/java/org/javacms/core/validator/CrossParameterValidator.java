package org.javacms.core.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.javacms.core.validator.impl.CrossParameterValidatorImpl;

@Constraint(validatedBy = CrossParameterValidatorImpl.class)
@Target(value = { ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER })
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface CrossParameterValidator {
	String message() default "{password.confirm_password.checking.error}";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
	
	/*String field();
	
	String verifyField();*/
}
