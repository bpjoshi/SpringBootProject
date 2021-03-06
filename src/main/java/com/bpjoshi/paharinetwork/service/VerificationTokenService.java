/**
 * 
 */
package com.bpjoshi.paharinetwork.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bpjoshi.paharinetwork.dao.VerificationTokenDao;
import com.bpjoshi.paharinetwork.model.EndUser;
import com.bpjoshi.paharinetwork.model.VerificationToken;
import com.bpjoshi.paharinetwork.model.VerificationTokenType;

/**
 * @author Bhagwati Prasad(bpjoshi)
 *
 */
@Service
public class VerificationTokenService {
	@Autowired
	private VerificationTokenDao verificationTokenDao;
	
	public String createEmailVerificationToken(EndUser endUser){
		VerificationToken verificationToken=new VerificationToken(UUID.randomUUID().toString(), endUser, VerificationTokenType.REGISTRATION);
		verificationTokenDao.save(verificationToken);
		
		return verificationToken.getTokenString();
	}
	
	public VerificationToken getVerificationToken(String tokenString){
		return verificationTokenDao.findByTokenString(tokenString);
	}

	/**
	 * @param verificationToken
	 */
	public void delete(VerificationToken verificationToken) {
		verificationTokenDao.delete(verificationToken);
		
	}
}
