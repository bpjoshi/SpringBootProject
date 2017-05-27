package com.bpjoshi.paharinetwork.tests;

import javax.transaction.Transactional;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bpjoshi.paharinetwork.dao.StatusUpdateDao;
import com.bpjoshi.paharinetwork.model.StatusUpdate;
/**
 * @author Bhagwati Prasad(bpjoshi)
 * Use SpringBootTest Class
 */
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class StatusUpdateTest {
	
	//Spring will manage this object
	@Autowired
	private StatusUpdateDao statusUpdateDao;
	@Test
	public void saveStatusTest(){
		StatusUpdate status= new StatusUpdate("Hey! Check out Bhagwati Prasad(bpjoshi)'s first status update.");
		statusUpdateDao.save(status);
		
		assertNotNull("ID should be non null", status.getStatusId());
		assertNotNull("Date shouldn't be null", status.getStatusDate());
		
		StatusUpdate retrieved=statusUpdateDao.findOne(status.getStatusId());
		assertEquals("Matching status update", status, retrieved);
	}
}
