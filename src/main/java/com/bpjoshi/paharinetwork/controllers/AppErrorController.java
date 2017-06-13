/**
 * 
 */
package com.bpjoshi.paharinetwork.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Bhagwati Prasad(bpjoshi)
 *
 */
@Controller
public class AppErrorController implements ErrorController {
	@Value(value = "${access.forbidden.message}")
	private String accessForbiddenMessage;

	/* (non-Javadoc)
	 * @see org.springframework.boot.autoconfigure.web.ErrorController#getErrorPath()
	 */
	@Override
	public String getErrorPath() {
		return "/error";
	}

	@RequestMapping("/error")
	public ModelAndView exceptionHandler(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.getModel().put("errorMessage", accessForbiddenMessage);
		modelAndView.getModel().put("url", request.getRequestURL());
		modelAndView.setViewName("app.errorPage");
		return modelAndView;
	}
}
