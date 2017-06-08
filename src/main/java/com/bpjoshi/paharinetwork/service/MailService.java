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
	private void send(MimeMessagePreparator mimeMessagePreparator){
		if(isMailEnabled){
			javaMailSender.send(mimeMessagePreparator);
		}
	}
	
	public void sendVerificationEmail(String emailAddress){
		//Making a velocity template content
		HashMap<String, Object> model=new HashMap<>();
		model.put("testData", "This is dynamic test data");
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
