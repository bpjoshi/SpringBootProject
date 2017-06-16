/**
 * 
 */
package com.bpjoshi.paharinetwork.profiletest;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bpjoshi.paharinetwork.model.EndUser;
import com.bpjoshi.paharinetwork.model.Profile;
import com.bpjoshi.paharinetwork.service.EndUserService;
import com.bpjoshi.paharinetwork.service.ProfileService;
/**
 * @author Bhagwati Prasad(bpjoshi)
 *
 */
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class ProfileTest {
	@Autowired
	private ProfileService profileService;
	@Autowired
	private EndUserService endUserService;
	/*
	 * This method is used just to create objects of EndUser for the purpose of testing
	 */
	public static EndUser createEndUserObjectForTest(String email){
		EndUser endUser=new EndUser();
		endUser.setUserEmail(email);
		endUser.setPlainPassword("password");
		endUser.setRepeatPassword("password");
		return endUser;
	}
	/*
	 * This method is used to create objects of Profile for the purpose of testing
	 */
	public static Profile createProfileObjectForTest(EndUser endUser){
		Profile profile=new Profile();
		profile.setEndUser(endUser);
		return new Profile();
	}
	/*
	 * This method test saveProfile() method
	 */
	@Test
	public void saveProfileTest(){
		EndUser endUser=createEndUserObjectForTest("merhaba@turkiye.tr");
		endUserService.saveEndUser(endUser);
		Profile profile=createProfileObjectForTest(endUser);
		profileService.saveProfile(profile);
		assertNotNull("Profile Id should not be null", profile.getProfileId());
	}
}
