/**
 * 
 */
package com.bpjoshi.paharinetwork.config;

import java.io.IOException;
import java.util.Properties;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.velocity.VelocityEngineFactory;

/**
 * @author Bhagwati Prasad(bpjoshi)
 *
 */
@Configuration
public class MailConfig {
	
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
	/*
	 * Added to get Velocity Engine Bean in MailService.java
	 */
	@SuppressWarnings("deprecation")
	@Bean
    public VelocityEngine getVelocityEngine() throws VelocityException, IOException{
        VelocityEngineFactory factory = new VelocityEngineFactory();
        Properties props = new Properties();
        props.put("resource.loader", "class");
        props.put("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        factory.setVelocityProperties(props);
        return factory.createVelocityEngine();      
    }

}
