package com.bpjoshi.paharinetwork.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    ModelAndView addStatus(ModelAndView modelAndView, @ModelAttribute("statusUpdate") StatusUpdate statusUpdate) {
		
		StatusUpdate latestStatusUpdate=statusUpdateService.getLatestStatusUpdate();
		modelAndView.getModel().put("latestStatusUpdate", latestStatusUpdate);
		
		modelAndView.setViewName("app.addStatus");
        return modelAndView;
    }
	/*
	 * @Valid in front of StatusUpdate so that it validates statusUpdate Object
	 */
	@RequestMapping(value="/addstatus", method=RequestMethod.POST)
    ModelAndView addStatus(ModelAndView modelAndView, @Valid StatusUpdate statusUpdate, BindingResult result) {
		//We want to go to the same view even if it has errors
		modelAndView.setViewName("app.addStatus");
		//Save status only if it doesn't have any error
		if(!result.hasErrors()){
			statusUpdateService.saveStatusUpdate(statusUpdate);
			//Put new blank status only if old status was saved, so that old statu
			modelAndView.getModel().put("statusUpdate", new StatusUpdate());
		}
		
		StatusUpdate latestStatusUpdate=statusUpdateService.getLatestStatusUpdate();
		modelAndView.getModel().put("latestStatusUpdate", latestStatusUpdate);
		
        return modelAndView;
    }
	
	@RequestMapping(value="/viewstatus", method=RequestMethod.GET)
	ModelAndView viewStatus(ModelAndView modelAndView, @RequestParam(name="p", defaultValue="1") int pageNumber){
		//Set view to view status page
		System.out.println("\n\n page number is: "+pageNumber+"\n\n");
		modelAndView.setViewName("app.viewStatus");
		return modelAndView;
	}
}
