/**
 * 
 */
package com.bpjoshi.paharinetwork.validations;

import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Payload;

/**
 * @author Bhagwati Prasad(bpjoshi)
 *
 */
@Target({TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented //helps to see values when you hover over
public @interface PasswordMatcher {
	
	String message() default "{error.password.mismatch}";
	
	Class<?>[] group() default{};
	
	Class <? extends Payload>[] payload() default {};
}
