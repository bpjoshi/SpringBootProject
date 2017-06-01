/**
 * 
 */
package com.bpjoshi.paharinetwork.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
	//PAGESIZE defines number of status per page
	private final static int PAGESIZE=3;
	public void saveStatusUpdate(StatusUpdate statusUpdate){
		statusUpdateDao.save(statusUpdate);
	}
	
	public StatusUpdate getLatestStatusUpdate(){
		return statusUpdateDao.findFirstByOrderByStatusDateDesc();
	}
	
	/*
	 * To retrieve number of statuses in a page on DESC order of statusDate
	 * PageSize is 3 status updates per page
	 */
	public Page<StatusUpdate> getPage(int pageNumber){
		PageRequest pageRequest=new PageRequest(pageNumber-1, PAGESIZE, Sort.Direction.DESC, "statusDate");
		return statusUpdateDao.findAll(pageRequest);
	}

	/**
	 * @param statusId
	 */
	public void deleteStatus(Long statusId) {
		statusUpdateDao.delete(statusId);
	}

	/**
	 * @param statusId
	 * @return
	 */
	public StatusUpdate getStatusUpdate(Long statusId) {
			return statusUpdateDao.findOne(statusId);
	}

}
