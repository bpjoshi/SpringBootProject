package com.bpjoshi.paharinetwork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	@Value(value = "${access.forbidden.403}")
	private Object accessForbidden403;
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
	
	@RequestMapping("/forbidden")
	ModelAndView accessDeniedError(ModelAndView modelAndView) {
		modelAndView.getModel().put("message", accessForbidden403);
		modelAndView.setViewName("app.message");
		return modelAndView;
	}
}
