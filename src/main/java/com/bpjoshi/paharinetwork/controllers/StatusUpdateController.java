package com.bpjoshi.paharinetwork.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
 * @author Bhagwati Prasad(bpjoshi)
 *
 */
@Controller
public class StatusUpdateController {
	@Autowired
	private StatusUpdateService statusUpdateService;
	
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
			modelAndView.setViewName("redirect:/viewstatus");
		}
		
		StatusUpdate latestStatusUpdate=statusUpdateService.getLatestStatusUpdate();
		modelAndView.getModel().put("latestStatusUpdate", latestStatusUpdate);
		
        return modelAndView;
    }
	
	@RequestMapping(value="/viewstatus", method=RequestMethod.GET)
	ModelAndView viewStatus(ModelAndView modelAndView, @RequestParam(name="p", defaultValue="1") int pageNumber){
		//Set view to view status page
		modelAndView.setViewName("app.viewStatus");
		Page<StatusUpdate> page=statusUpdateService.getPage(pageNumber);
		modelAndView.getModel().put("page", page);
		return modelAndView;
	}
	@RequestMapping(value="/deletestatus", method=RequestMethod.GET)
	ModelAndView deleteStatus(ModelAndView modelAndView, @RequestParam(name="id") Long statusId){
		modelAndView.setViewName("redirect:/viewstatus");
		statusUpdateService.deleteStatus(statusId);
		return modelAndView;
	}
	
	@RequestMapping(value="/editstatus", method=RequestMethod.GET)
	ModelAndView editStatus(ModelAndView modelAndView, @RequestParam(name="id") Long statusId){
		StatusUpdate statusUpdate=statusUpdateService.getStatusUpdate(statusId);
		modelAndView.getModel().put("statusUpdate", statusUpdate);
		modelAndView.setViewName("app.editStatus");
		return modelAndView;
	}
	
	@RequestMapping(value="/editstatus", method=RequestMethod.POST)
	ModelAndView editStatus(ModelAndView modelAndView, @Valid StatusUpdate statusUpdate, BindingResult result){
		modelAndView.setViewName("app.editStatus");
		if(!result.hasErrors()){
			statusUpdateService.saveStatusUpdate(statusUpdate);
			modelAndView.setViewName("redirect:/viewstatus");
		}
		return modelAndView;
	}
}
