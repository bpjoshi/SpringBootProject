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
	public void initialize(PasswordMatcher arg0) {
		
		
	}
	public boolean isValid(EndUser endUser, ConstraintValidatorContext cVC) {
		if(endUser.getPlainPassword()==null || endUser.getPlainPassword().length()==0){
			return true;
			//treating this case like it's not a registration case
		}
		if(endUser==null ||(endUser.getPlainPassword().equalsIgnoreCase(endUser.getRepeatPassword()))){
			return false;
		}
		return true;
	}

}
