/**
 * 
 */
package com.bpjoshi.paharinetwork.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bpjoshi.paharinetwork.model.EndUser;
import com.bpjoshi.paharinetwork.model.Profile;

/**
 * @author Bhagwati Prasad(bpjoshi)
 *
 */
@Repository
public interface ProfileDao extends CrudRepository<Profile, String> {
	Profile findByEndUser(EndUser endUser);
}
