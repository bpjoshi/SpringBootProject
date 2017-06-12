/**
 * 
 */
package com.bpjoshi.paharinetwork.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Bhagwati Prasad(bpjoshi)
 *
 */
@ControllerAdvice
public class ExceptionHandler {
	@Value("${exception.message.display}")
	private Object exceptionMessage;

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ModelAndView exceptionHandler(HttpServletRequest request, Exception exception){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.getModel().put("message", exceptionMessage);
		modelAndView.getModel().put("url", request.getRequestURL());
		modelAndView.getModel().put("exceptionMessage", exception.getCause());
		modelAndView.setViewName("app.exceptionPage");
		return modelAndView;
	}

}
