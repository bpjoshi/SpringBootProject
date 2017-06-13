package com.bpjoshi.paharinetwork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bpjoshi.paharinetwork.model.StatusUpdate;
import com.bpjoshi.paharinetwork.service.StatusUpdateService;
/**
 * 
 * @author Bhagwati Prasad(bpjoshi)
 *
 */
@Controller
public class PageController {
	@Autowired
	private StatusUpdateService statusUpdateService;
	@RequestMapping("/")
    ModelAndView home(ModelAndView modelAndView) {
		StatusUpdate statusUpdate=statusUpdateService.getLatestStatusUpdate();
		
		modelAndView.getModel().put("statusUpdate", statusUpdate);
		modelAndView.setViewName("app.homepage");
        return modelAndView;
    }
	
	@RequestMapping("/about")
    String about() {
        return "app.about";
    }
	
}
