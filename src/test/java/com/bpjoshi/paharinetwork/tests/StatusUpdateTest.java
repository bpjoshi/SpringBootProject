package com.bpjoshi.paharinetwork.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bpjoshi.paharinetwork.dao.StatusUpdateDao;
import com.bpjoshi.paharinetwork.model.StatusUpdate;
/**
 * @author Bhagwati Prasad(bpjoshi)
 * Use SpringBootTest Class
 */
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
public class StatusUpdateTest {
	
	//Spring will manage this object
	@Autowired
	private StatusUpdateDao statusUpdateDao;
	@Test
	public void saveStatusTest(){
		StatusUpdate status= new StatusUpdate("Hey! Check out Bhagwati Prasad(bpjoshi)'s first status update.");
		statusUpdateDao.save(status);
	}
}
