package com.bpjoshi.paharinetwork.service;

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
}
