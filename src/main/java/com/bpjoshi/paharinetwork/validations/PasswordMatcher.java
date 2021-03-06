/**
 * 
 */
package com.bpjoshi.paharinetwork.validations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author Bhagwati Prasad(bpjoshi)
 *
 */
@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy=PasswordMatchValidator.class)
@Documented //helps to see values when you hover over
public @interface PasswordMatcher {
	String message() default "{error.password.mismatch}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
