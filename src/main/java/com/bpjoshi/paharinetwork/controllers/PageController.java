package com.bpjoshi.paharinetwork.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bpjoshi.paharinetwork.model.StatusUpdate;
/**
 * 
 * @author Bhagwati Prasad(bpjoshi)
 *
 */
@Controller
public class PageController {
	
	@RequestMapping("/")
    String home() {
		//changed to app.homepage from home to display from tiles
        return "app.homepage";
    }
	
	@RequestMapping("/about")
    String about() {
        return "app.about";
    }
	
	@RequestMapping("/addstatus")
    ModelAndView addStatus(ModelAndView modelAndView) {
		StatusUpdate statusUpdate=new StatusUpdate("Hello World!");
		modelAndView.getModel().put("statusUpdate", statusUpdate);
		modelAndView.setViewName("app.addStatus");
        return modelAndView;
    }
}
