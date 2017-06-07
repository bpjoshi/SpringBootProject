package com.bpjoshi.paharinetwork.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bpjoshi.paharinetwork.model.EndUser;
import com.bpjoshi.paharinetwork.service.EmailService;
import com.bpjoshi.paharinetwork.service.EndUserService;
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
	private EmailService emailService;
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
			modelAndView.setViewName("redirect:/");
		}
		return modelAndView;
    }

}
