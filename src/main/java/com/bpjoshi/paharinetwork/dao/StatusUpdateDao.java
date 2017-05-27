/**
 * 
 */
package com.bpjoshi.paharinetwork.dao;

import org.springframework.data.repository.CrudRepository;

import com.bpjoshi.paharinetwork.model.StatusUpdate;;

/**
 * @author Bhagwati Prasad(bpjoshi)
 * StatusUpdate represents model StatusUpdate and Long represent type of statusId
 * Type of id should be object type, it doesn't accept premitive types
 */
public interface StatusUpdateDao extends CrudRepository<StatusUpdate, Long> {
	//Added to retrieve latest status update.
	//Spring data jpa adds implementation ..based upon our object properties
	StatusUpdate findFirstByOrderByStatusDateDesc();
}
