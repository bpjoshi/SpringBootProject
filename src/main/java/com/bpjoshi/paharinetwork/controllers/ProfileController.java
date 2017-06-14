/**
 * 
 */
package com.bpjoshi.paharinetwork.controllers;

import javax.validation.Valid;

import org.owasp.html.PolicyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bpjoshi.paharinetwork.model.EndUser;
import com.bpjoshi.paharinetwork.model.Profile;
import com.bpjoshi.paharinetwork.service.EndUserService;
import com.bpjoshi.paharinetwork.service.ProfileService;

/**
 * @author Bhagwati Prasad(bpjoshi)
 *
 */
@Controller
public class ProfileController {
	@Autowired
	private ProfileService profileService;
	@Autowired
	private EndUserService endUserService;
	@Autowired
	PolicyFactory htmlPolicy;
	@RequestMapping(value="/profile")
	public ModelAndView showProfile(ModelAndView modelAndView){
		//Add safe copy to publicly visible profile
		Profile publicProfile=getPublicProfile();
		modelAndView.getModel().put("profile", publicProfile);
		modelAndView.setViewName("app.profilePage");
		return modelAndView;
	}
	
	@RequestMapping(value="/editprofileabout", method=RequestMethod.GET)
	public ModelAndView editProfileAboutText(ModelAndView modelAndView){
		Profile publicProfile=getPublicProfile();
		modelAndView.getModel().put("profile", publicProfile);
		modelAndView.setViewName("app.editProfileAboutText");
		return modelAndView;
	}
	
	@RequestMapping(value="/editprofileabout", method=RequestMethod.POST)
	public ModelAndView editProfileAboutText(ModelAndView modelAndView, @Valid Profile publicProfile, BindingResult result){
		if(!result.hasErrors()){
			EndUser endUser=getEndUser();
			Profile profile=profileService.getProfile(endUser);
			profile.mergeFromPublicCopy(publicProfile, htmlPolicy);
			profileService.saveProfile(profile);
			modelAndView.setViewName("redirect:/profile");
			return modelAndView;
		}
		modelAndView.setViewName("app.editProfileAboutText");
		return modelAndView;
	}
	
	private EndUser getEndUser(){
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		String userEmail=auth.getName();
		return endUserService.getEndUser(userEmail);
	}
	
	
	private Profile getPublicProfile(){
		EndUser endUser=getEndUser();
		Profile profile=profileService.getProfile(endUser);
		//At first the profile is going to be null
		if(profile==null){
			profile=new Profile();
			profile.setEndUser(endUser);
			profileService.saveProfile(profile);
		}
		Profile publicProfile=new Profile();
		publicProfile.safeProfileCopy(profile);
		return publicProfile;
	}
}
