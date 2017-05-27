package com.bpjoshi.paharinetwork.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
/**
 * @author Bhagwati Prasad(bpjoshi)
 * Use SpringBootTest Class
 */
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class StatusUpdateTest {
	
	public void saveStatusTest(){
		
	}
	
}
