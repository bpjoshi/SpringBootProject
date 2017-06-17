package com.bpjoshi.paharinetwork.service;

import org.springframework.stereotype.Service;

/**
 * @author Bhagwati Prasad(bpjoshi)
 *
 */
@Service
public class MediaService {
	
	private String getMediaExtension(String fileName){
		int positionOfDot=fileName.lastIndexOf(".");
		if(positionOfDot<0){
			return null;
		}
		return fileName.substring(positionOfDot+1);
	}
}
