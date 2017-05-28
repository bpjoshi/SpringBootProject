/**
 * 
 */
package com.bpjoshi.paharinetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bpjoshi.paharinetwork.dao.StatusUpdateDao;
import com.bpjoshi.paharinetwork.model.StatusUpdate;

/**
 * @author Bhagwati Prasad(bpjoshi)
 *
 */
@Service
public class StatusUpdateService {
	@Autowired
	private StatusUpdateDao statusUpdateDao;
	
	public void saveStatusUpdate(StatusUpdate statusUpdate){
		statusUpdateDao.save(statusUpdate);
	}
	
	public StatusUpdate getLatestStatusUpdate(){
		return statusUpdateDao.findFirstByOrderByStatusDateDesc();
	}

}
