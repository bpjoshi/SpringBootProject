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
}
