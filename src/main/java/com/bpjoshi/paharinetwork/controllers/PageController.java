package com.bpjoshi.paharinetwork.controllers;

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
		//changed to app.homepage from home to display from tiles
        return "app.homepage";
    }
	
	@RequestMapping("/about")
    String about() {
        return "about";
    }
}
