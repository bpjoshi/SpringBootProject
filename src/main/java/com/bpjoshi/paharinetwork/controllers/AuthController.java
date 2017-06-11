package com.bpjoshi.paharinetwork.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bpjoshi.paharinetwork.model.EndUser;
import com.bpjoshi.paharinetwork.service.EndUserService;
import com.bpjoshi.paharinetwork.service.MailService;
/**
 * 
 * @author Bhagwati Prasad(bpjoshi)
 *
 */
@Controller
public class AuthController {
	@Autowired
	private EndUserService endUserService;
	@Autowired
	private MailService emailService;
	@Value("${message.token.confirmed}")
	private String tokenRegConfirmed;
	@Value("${message.token.invalid}")
	private String tokenInvalid;
	@Value("${message.token.expired}")
	private String tokenExpired;
	@RequestMapping("/login")
    String adminPage() {
        return "app.login";
    }
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
    ModelAndView register(ModelAndView modelAndView) {
		EndUser endUser=new EndUser();
		modelAndView.getModel().put("endUser", endUser);
		//"endUser" should be same as modelAttribute in form page
		modelAndView.setViewName("app.register");
		return modelAndView;
    }
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
    ModelAndView register(ModelAndView modelAndView, @Valid EndUser endUser, BindingResult result) {
		modelAndView.setViewName("app.register");
		if(!result.hasErrors()){
			endUserService.registerEndUser(endUser);
			emailService.sendVerificationEmail(endUser.getUserEmail());
			modelAndView.setViewName("redirect:/verifyemail");
		}
		return modelAndView;
    }
	
	@RequestMapping("/verifyemail")
	String verifyEmail() {
		return "app.verifyEmail";
	}
	/**
	 * If user clicks on a valid token, account is confirmed.
	 */
	@RequestMapping(value="/regconfirmed")
    ModelAndView tokenRegConfirmed(ModelAndView modelAndView) {
		
		modelAndView.getModel().put("message", tokenRegConfirmed);
		modelAndView.setViewName("app.message");
		return modelAndView;
    }
	/**
	 * If the user clicks on the wrong token that doesn't match the user
	 */
	@RequestMapping(value="/invaliduser")
    ModelAndView tokenInvalid(ModelAndView modelAndView) {
		
		modelAndView.getModel().put("message", tokenInvalid);
		modelAndView.setViewName("app.message");
		return modelAndView;
    }
	/**
	 * If user clicks on the token which was sent long back and has expired.
	 */
	@RequestMapping(value="/expiredlink")
    ModelAndView tokenExpired(ModelAndView modelAndView) {
		
		modelAndView.getModel().put("message", tokenExpired);
		modelAndView.setViewName("app.message");
		return modelAndView;
    }

}
