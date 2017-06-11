/**
 * 
 */
package com.bpjoshi.paharinetwork.service;

import java.util.Date;
import java.util.HashMap;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 * @author Bhagwati Prasad(bpjoshi)
 *
 */
@SuppressWarnings("deprecation")
@Service
public class MailService {
	@Autowired
	private JavaMailSender javaMailSender;
	@Value("${mail.enable}")
	private Boolean isMailEnabled;
	@Autowired
	private VelocityEngine velocityEngine;
	@Value("${website.url}")
	private String websiteUrl;
	private void send(MimeMessagePreparator mimeMessagePreparator){
		if(isMailEnabled){
			javaMailSender.send(mimeMessagePreparator);
		}
	}
	/**
	 * @param emailAddress
	 * @param verificationToken
	 * Method sends a verification token to the user
	 * Method is marked Async because contacting to email server might take time and 
	 * we would like other things to run during this time.
	 * This can be tested if we put Thread.sleep(10000) ..The mail will be sent after 10 seconds
	 */
	@Async 
	public void sendVerificationEmail(String emailAddress, String verificationToken){
		//Making a velocity template content
		HashMap<String, Object> model=new HashMap<>();
		model.put("verificationToken", verificationToken);
		model.put("websiteUrl", websiteUrl);
		//Deprecated Utils class need to be replaced though.
		String mailContent=VelocityEngineUtils.mergeTemplateIntoString
				(velocityEngine, "/com/bpjoshi/paharinetwork/velocitytemplates/verifyemail.vm", "UTF-8", model);
		MimeMessagePreparator mimeMessagePreparator=new MimeMessagePreparator(){

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage);
				mimeMessageHelper.setTo(emailAddress);
				mimeMessageHelper.setFrom(new InternetAddress("no-reply@bpjoshi.com"));
				mimeMessageHelper.setSubject("Vefication of your account");
				mimeMessageHelper.setSentDate(new Date());
				
				mimeMessageHelper.setText(mailContent, true);
			}
		};
		send(mimeMessagePreparator);
	}

}
