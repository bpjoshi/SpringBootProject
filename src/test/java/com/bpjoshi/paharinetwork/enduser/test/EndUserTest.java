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

import com.bpjoshi.paharinetwork.dao.EndUserDao;
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
	@Test
	public void registerEndUserTest(){
		EndUser endUser=createEndUserObjectForTest("hello@hello.com");
		endUserService.registerEndUser(endUser);
		assertNotNull("User Id should not be null", endUser.getUserId());
		assertFalse("User shouldn't be enabled", endUser.getUserEnabled());
		assertEquals("A new user's role should be 'USER' ", "ROLE_USER", endUser.getUserRole());
	}
	@Test
	public void findByUserEmailTest(){
		EndUser endUser=createEndUserObjectForTest("abc@def.com");
		endUserService.save(endUser);
		EndUser newEndUser=endUserService.getEndUser("abc@def.com");
		assertEquals("The emailid must be same", "abc@def.com", newEndUser.getUserEmail());
	}
	
	public static EndUser createEndUserObjectForTest(String email){
		EndUser endUser=new EndUser();
		endUser.setUserEmail(email);
		endUser.setPlainPassword("password");
		endUser.setRepeatPassword("password");
		return endUser;
	}
}
