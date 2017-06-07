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
public class PasswordMatchValidator implements ConstraintValidator<PasswordMatcher, EndUser> {
	@Override
	public void initialize(PasswordMatcher p) {
		
	}

	@Override
	public boolean isValid(EndUser endUser, ConstraintValidatorContext c) {
		
		String plainPassword = endUser.getPlainPassword();
		String repeatPassword = endUser.getRepeatPassword();
		
		if(plainPassword == null || plainPassword.length() == 0) {
			return true;
		}
		
		if(plainPassword == null || !plainPassword.equals(repeatPassword)) {
			return false;
		}
			
		return true;
	}

}
