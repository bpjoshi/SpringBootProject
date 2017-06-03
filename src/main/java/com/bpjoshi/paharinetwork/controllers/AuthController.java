package com.bpjoshi.paharinetwork.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bpjoshi.paharinetwork.model.EndUser;
/**
 * 
 * @author Bhagwati Prasad(bpjoshi)
 *
 */
@Controller
public class AuthController {
	
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

}
