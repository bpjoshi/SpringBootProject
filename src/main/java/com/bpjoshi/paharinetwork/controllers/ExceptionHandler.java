/**
 * 
 */
package com.bpjoshi.paharinetwork.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Bhagwati Prasad(bpjoshi)
 *
 */
@ControllerAdvice
public class ExceptionHandler {
	@Value("${exception.message.display}")
	private Object exceptionMessage;
	@Value("${exception.message.duplicateUser}")
	private Object duplicateUserException;

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ModelAndView exceptionHandler(HttpServletRequest request, Exception exception){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.getModel().put("message", exceptionMessage);
		modelAndView.getModel().put("exceptionMessage", exception);
		modelAndView.setViewName("app.exceptionPage");
		return modelAndView;
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ModelAndView duplicateUserException(HttpServletRequest request, DataIntegrityViolationException exception){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.getModel().put("message", duplicateUserException);
		modelAndView.getModel().put("exceptionMessage", exception);
		modelAndView.setViewName("app.exceptionPage");
		return modelAndView;
	}
	@org.springframework.web.bind.annotation.ExceptionHandler(MultipartException.class)
	public String mediaUploadException(Exception e){
		e.printStackTrace();
		return "Error upload media files";
	}
	
}
