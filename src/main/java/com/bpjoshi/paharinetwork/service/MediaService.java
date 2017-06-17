package com.bpjoshi.paharinetwork.service;

import java.io.File;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Bhagwati Prasad(bpjoshi)
 *
 */
@Service
public class MediaService {
	@Value("${media.image.extensions}")
	private String validImageExtensions;
	@Value("${media.video.extensions}")
	private String validVideoExtensions;
	private Random randomNumber=new Random();
	
	private String getMediaExtension(String fileName){
		int positionOfDot=fileName.lastIndexOf(".");
		if(positionOfDot<0){
			return null;
		}
		return fileName.substring(positionOfDot+1);
	}
	
	private boolean isAnImageExtension(String extensionName){
		for(String validExtension:validImageExtensions.split(",")){
			if(extensionName.equalsIgnoreCase(validExtension)){
				return true;
			}
		}
		return false;
	}
	
	private boolean isAVideoExtension(String extensionName){
		for(String validExtension:validVideoExtensions.split(",")){
			if(extensionName.equalsIgnoreCase(validExtension)){
				return true;
			}
		}
		return false;
	}
	
	private File selectMediaDirectory(String rootPath, String prefix){
		int numDir=randomNumber.nextInt(1000);
		String newSubDir=String.format("%s%03d", prefix, numDir);
		File newDir=new File(rootPath, newSubDir);
		if(!newDir.exists()){
			newDir.mkdir();
		}
		return newDir;
	}
}
