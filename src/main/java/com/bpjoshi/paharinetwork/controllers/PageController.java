package com.bpjoshi.paharinetwork.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @author Bhagwati Prasad(bpjoshi)
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
        return "app.about";
    }
	
	@RequestMapping("/addstatus")
    String addStatus() {
        return "app.addStatus";
    }
}
