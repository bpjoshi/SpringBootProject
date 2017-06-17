package com.bpjoshi.paharinetwork.service;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	@Value("${media.upload.directory}")
	private String MediaUploadDirectory;
	/*
	 * Test method to get extension
	 */
	@Test
	public void getMediaExtensionTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method method=MediaService.class.getDeclaredMethod("getMediaExtension", String.class);
		method.setAccessible(true);
		assertEquals("Should be a JPEG", "jpeg", (String)method.invoke(mediaService, "myPhot.jpeg"));
		assertEquals("Should be a JPEG", "xlsx", (String)method.invoke(mediaService, "myPhot.xlsx"));
		assertNull("Should be a JPEG", (String)method.invoke(mediaService, "myPhot"));
	}
	/*
	 * Test method for isAnImageExtension method
	 */
	@Test
	public void isAnImageExtensionTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method method=MediaService.class.getDeclaredMethod("isAnImageExtension", String.class);
		method.setAccessible(true);
		//assertTrue("Should fail", (Boolean)method.invoke(mediaService, "myPhot"));
		assertTrue("Should pass", (Boolean)method.invoke(mediaService, "jpeg"));
	}
	/*
	 * Test method for isAVideoExtension method
	 */
	@Test
	public void isAVideoExtensionTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method method=MediaService.class.getDeclaredMethod("isAVideoExtension", String.class);
		method.setAccessible(true);
		//assertTrue("Should fail", (Boolean)method.invoke(mediaService, "myPhot"));
		assertTrue("Should pass", (Boolean)method.invoke(mediaService, "mp4"));
	}
	/*
	 * Test method for method selectMediaDirectory() to check if the directories are
	 * being created
	 */
	@Test
	public void selectMediaDirectoryTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method method=MediaService.class.getDeclaredMethod("selectMediaDirectory", String.class, String.class);
		method.setAccessible(true);
		for(int i=0; i<50; i++){
			File fileCreated=(File)method.invoke(mediaService,MediaUploadDirectory, "images" );
			assertTrue("Directory should exist "+fileCreated.getAbsolutePath(), fileCreated.exists());
		}
	}
	
}
