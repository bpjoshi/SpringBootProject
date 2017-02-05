package com.bpjoshi.onlineconnections.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @author bpjoshi(Bhagwati Prasad)
 *
 */
@Controller
public class AuthController {
	
	@RequestMapping("/admin")
    String about() {
        return "admin";
    }

}
