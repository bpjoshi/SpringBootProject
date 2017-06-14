/**
 * 
 */
package com.bpjoshi.paharinetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bpjoshi.paharinetwork.dao.ProfileDao;
import com.bpjoshi.paharinetwork.model.EndUser;
import com.bpjoshi.paharinetwork.model.Profile;

/**
 * @author Bhagwati Prasad(bpjoshi)
 *
 */
@Service
public class ProfileService {
	@Autowired
	private ProfileDao profileDao;
	public void saveProfile(Profile profile){
		profileDao.save(profile);
	}
	
	public Profile getProfile(EndUser endUser){
		return profileDao.findByEndUser(endUser);
	}
}
