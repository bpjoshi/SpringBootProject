package com.bpjoshi.paharinetwork.service;
import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * @author Bhagwati Prasad(bpjoshi)
 *
 */
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
public class MediaServiceTest {
	@Autowired
	private MediaService mediaService;
	@Test
	public void getMediaExtensionTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method method=MediaService.class.getDeclaredMethod("getMediaExtension", String.class);
		method.setAccessible(true);
		assertEquals("Should be a JPEG", "jpeg", (String)method.invoke(mediaService, "myPhot.jpeg"));
	}
}
