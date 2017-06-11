/**
 * 
 */
package com.bpjoshi.paharinetwork.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bpjoshi.paharinetwork.model.VerificationToken;

/**
 * @author Bhagwati Prasad(bpjoshi)
 */
@Repository
public interface VerificationTokenDao extends CrudRepository<VerificationToken, Long> {
	VerificationToken findByTokenString(String token);
}
