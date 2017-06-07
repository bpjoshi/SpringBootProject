/**
 * 
 */
package com.bpjoshi.paharinetwork.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.bpjoshi.paharinetwork.model.EndUser;

/**
 * @author Bhagwati Prasad(bpjoshi)
 *
 */
public class PasswordMatch implements ConstraintValidator<PasswordMatcher, EndUser> {
	public void initialize(PasswordMatcher arg0) {
		
		
	}
	public boolean isValid(EndUser arg0, ConstraintValidatorContext arg1) {
		
		return false;
	}

}
