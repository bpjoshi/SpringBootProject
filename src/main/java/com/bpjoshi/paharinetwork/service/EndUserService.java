package com.bpjoshi.paharinetwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bpjoshi.paharinetwork.dao.EndUserDao;
import com.bpjoshi.paharinetwork.model.EndUser;

/**
 * @author Bhagwati Prasad(bpjoshi)
 *
 */
@Service
public class EndUserService implements UserDetailsService {
	@Autowired
	private EndUserDao endUserDao;
	//Register a new end user in database
	public void registerEndUser(EndUser endUser){
		endUserDao.save(endUser);
	}
	//Load user 
	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		EndUser endUser=endUserDao.findByUserEmail(userEmail);
		if(endUser==null){
			return null;
		}
		List<GrantedAuthority> authorityList=AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
		String userPassword=endUser.getUserPassword();
		return new User(userEmail, userPassword, authorityList);
	}

}
