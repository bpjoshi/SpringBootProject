package com.bpjoshi.paharinetwork.statusupdate.test;

import java.util.Calendar;

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
	
	@Test
	public void retrieveLastStatusUpdateTest(){
Calendar calendar = Calendar.getInstance();
		StatusUpdate lastStatusUpdate = null;
		for(int i=0; i<3; i++) {
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			StatusUpdate status = new StatusUpdate("Status update " + i, calendar.getTime());
			statusUpdateDao.save(status);
			lastStatusUpdate = status;
		}
		StatusUpdate retrieved = statusUpdateDao.findFirstByOrderByStatusDateDesc();
		assertEquals("Latest status update", lastStatusUpdate, retrieved);
	}
}
