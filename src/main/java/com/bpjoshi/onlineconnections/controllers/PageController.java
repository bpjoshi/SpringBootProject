package com.bpjoshi.onlineconnections.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @author bpjoshi(Bhagwati Prasad)
 *
 */
@Controller
public class PageController {
	
	@RequestMapping("/")
    String home() {
        return "home";
    }
	
	@RequestMapping("/about")
    String about() {
        return "about";
    }
}
