package com.bpjoshi.paharinetwork;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
/**
 * @author Bhagwati Prasad(bpjoshi)
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
	/*
	 * The @SpringBootTest annotation tells Spring Boot to go and look for a main 
	 * configuration class (one with @SpringBootApplication for instance), and use 
	 * that to start a Spring application context.
	 */
	@Test
    public void contextLoads() throws Exception {
		
    }
}
