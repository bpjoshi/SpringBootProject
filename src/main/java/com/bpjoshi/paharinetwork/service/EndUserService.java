package com.bpjoshi.paharinetwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	@Autowired
	private PasswordEncoder passwordEncoder;
	//Register a new end user in database
	public void registerEndUser(EndUser endUser){
		
		endUser.setUserRole("ROLE_USER");
		//Encode the password before registering the user in the database, now being done in EndUser Class
		//endUser.setUserPassword(passwordEncoder.encode(endUser.getUserPassword()));
		endUserDao.save(endUser);
	}
	
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		EndUser endUser=endUserDao.findByUserEmail(userEmail);
		if(endUser==null){
			return null;
		}
		List<GrantedAuthority> authorityList=AuthorityUtils.commaSeparatedStringToAuthorityList(endUser.getUserRole());
		String userPassword=endUser.getUserPassword();
		return new User(userEmail, userPassword, authorityList);
	}

}
