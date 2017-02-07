package org.javacms.core.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import org.javacms.core.validator.impl.PasswordCompareValidatorImpl;

/**
 * The validator implemented on validating the password and confirm password on a method validator, if you want to using
 * that on a Bean validation, you should to updating the parameters Object[] value to the method isValid of PasswordCompareValidatorImpl 
 * to using that on a Bean validation.
 * And this is a combined validation annotation
 * 
 * @author David.Lv
 *
 */
@Target(value = { ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER })
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PasswordCompareValidatorImpl.class)
public @interface PasswordCompareValidator {
	String message() default "{password.compare.illegal}";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
	//ConstraintTarget validationAppliesTo() default ConstraintTarget.IMPLICIT;
}
