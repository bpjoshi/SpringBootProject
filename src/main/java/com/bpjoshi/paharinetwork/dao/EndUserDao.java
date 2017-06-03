package com.bpjoshi.paharinetwork.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bpjoshi.paharinetwork.model.EndUser;

/**
 * @author Bhagwati Prasad(bpjoshi)
 *
 */
@Repository
public interface EndUserDao extends CrudRepository<EndUser, Long> {
	EndUser findByUserEmail(String userEmail);
}
