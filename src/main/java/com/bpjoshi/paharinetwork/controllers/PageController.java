package com.bpjoshi.paharinetwork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    String home() {
		//changed to app.homepage from home to display from tiles
        return "app.homepage";
    }
	
	@RequestMapping("/about")
    String about() {
        return "app.about";
    }
	
	@RequestMapping(value="/addstatus", method=RequestMethod.GET)
    ModelAndView addStatus(ModelAndView modelAndView) {
		StatusUpdate statusUpdate=new StatusUpdate();
		modelAndView.getModel().put("statusUpdate", statusUpdate);
		
		StatusUpdate latestStatusUpdate=statusUpdateService.getLatestStatusUpdate();
		modelAndView.getModel().put("latestStatusUpdate", latestStatusUpdate);
		
		modelAndView.setViewName("app.addStatus");
        return modelAndView;
    }
	
	@RequestMapping(value="/addstatus", method=RequestMethod.POST)
    ModelAndView addStatus(ModelAndView modelAndView, StatusUpdate statusUpdate) {
		statusUpdateService.saveStatusUpdate(statusUpdate);
		
		StatusUpdate latestStatusUpdate=statusUpdateService.getLatestStatusUpdate();
		modelAndView.getModel().put("latestStatusUpdate", latestStatusUpdate);
		
		modelAndView.setViewName("app.addStatus");
        return modelAndView;
    }
}
