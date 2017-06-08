/**
 * 
 */
package com.bpjoshi.paharinetwork.service;

import java.util.Date;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

/**
 * @author Bhagwati Prasad(bpjoshi)
 *
 */
@Service
public class MailService {
	@Autowired
	private JavaMailSender javaMailSender;
	@Value("${mail.enable}")
	private Boolean isMailEnabled;
	
	private void send(MimeMessagePreparator mimeMessagePreparator){
		if(isMailEnabled){
			javaMailSender.send(mimeMessagePreparator);
		}
	}
	
	public void sendVerificationEmail(String emailAddress){
		//Preparing an email message
		StringBuilder mailMessageBuilder= new StringBuilder();
		mailMessageBuilder.append("<html>");
		mailMessageBuilder.append("<h3>Please click on the link below to activate your account.</h3>");
		mailMessageBuilder.append("<a href='https://www.facebook.com'>Click Me</a>");
		mailMessageBuilder.append("</html>");
		
		MimeMessagePreparator mimeMessagePreparator=new MimeMessagePreparator(){

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage);
				mimeMessageHelper.setTo(emailAddress);
				mimeMessageHelper.setFrom(new InternetAddress("no-reply@bpjoshi.com"));
				mimeMessageHelper.setSubject("Vefication of your account");
				mimeMessageHelper.setSentDate(new Date());
				
				mimeMessageHelper.setText(mailMessageBuilder.toString(), true);
			}
		};
		send(mimeMessagePreparator);
	}

}
