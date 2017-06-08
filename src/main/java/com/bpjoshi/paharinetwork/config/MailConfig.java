/**
 * 
 */
package com.bpjoshi.paharinetwork.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * @author Bhagwati Prasad(bpjoshi)
 *
 */
public class MailConfig {
	/*
	 * mail.enable=true
mail.smtp.host=smtp.mailtrap.io
mail.smtp.port=2525
mail.smtp.user=3ef22b84ece492
mail.smtp.pass=24117e92dcc825
	 */
	@Value("${mail.smtp.host}")
	private String host;
	@Value("${mail.smtp.port}")
	private Integer port;
	@Value("${mail.smtp.user}")
	private String username;
	@Value("${mail.smtp.pass}")
	private String password;
	@Bean //Added Bean annotation in the class so that it's bean can be autowired.
	public JavaMailSender mailSender(){
		JavaMailSender javaMailSender=new JavaMailSenderImpl();
		((JavaMailSenderImpl) javaMailSender).setHost(host);
		((JavaMailSenderImpl) javaMailSender).setPort(port);
		((JavaMailSenderImpl) javaMailSender).setUsername(username);
		((JavaMailSenderImpl) javaMailSender).setPassword(password);
		return javaMailSender;
	}

}
