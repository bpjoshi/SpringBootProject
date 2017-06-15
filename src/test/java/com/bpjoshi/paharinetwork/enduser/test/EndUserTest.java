/**
 * 
 */
package com.bpjoshi.paharinetwork.enduser.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bpjoshi.paharinetwork.model.EndUser;
import com.bpjoshi.paharinetwork.service.EndUserService;
/**
 * @author Bhagwati Prasad(bpjoshi)
 *
 */
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class EndUserTest {
	@Autowired
	private EndUserService endUserService;
	/*
	 * This method tests registerEndUser() method of EndUserService
	 */
	@Test
	public void registerEndUserTest(){
		EndUser endUser=createEndUserObjectForTest("bonjour@france.fr");
		endUserService.registerEndUser(endUser);
		assertNotNull("User Id should not be null after registration", endUser.getUserId());
		assertFalse("User shouldn't be enabled till he clicks on verfication link on email", 
				endUser.getUserEnabled());
		assertEquals("A newly registered user's role should be 'ROLE_USER' ", "ROLE_USER", 
				endUser.getUserRole());
	}
	/*
	 * This method tests saveEndUser() method of EndUserService. The saveEndUser() method is
	 * called after updating the role. It should reflect the updated role in test.
	 */
	@Test
	public void saveEndUserTest(){
		EndUser endUser=createEndUserObjectForTest("czesc@polska.pl");
		endUserService.registerEndUser(endUser);
		assertEquals("A newly registered user's role should be 'ROLE_USER' ", "ROLE_USER",
				endUser.getUserRole());
		endUser.setUserRole("ROLE_ADMIN");
		endUserService.saveEndUser(endUser);
		assertEquals("After saveEndUser() call role should be that of Admin ", "ROLE_ADMIN", 
				endUser.getUserRole());
	}
	/*
	 * This methods tests getEndUser() method of EndUserService
	 * The registered User and the retrieved EndUser object using getEndUser() 
	 * method of EndUserService must be the same
	 */
	@Test
	public void findByUserEmailTest(){
		EndUser endUser=createEndUserObjectForTest("namaste@india.in");
		endUserService.registerEndUser(endUser);
		assertEquals("The two EndUser object must be Equal", endUser, endUserService.getEndUser("namaste@india.in"));
	}
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
}
