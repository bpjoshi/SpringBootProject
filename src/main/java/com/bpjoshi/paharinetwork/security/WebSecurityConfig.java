package com.bpjoshi.paharinetwork.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.bpjoshi.paharinetwork.service.EndUserService;

/**
 * @author Bhagwati Prasad(bpjoshi)
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private EndUserService endUserService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//@formatter:off
		//The code right below, won't allow any css files to be visible
		//http.authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated();
		//Allow css etc at home page
		http.authorizeRequests().antMatchers("/", "/about").permitAll().antMatchers("/js/*", "/css/*", "/img/*")
		.permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login")
		.defaultSuccessUrl("/").permitAll();
		//@formatter:on
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//@formatter:off
			auth.userDetailsService(endUserService);
		//@formatter:on
	}
	
	

}
