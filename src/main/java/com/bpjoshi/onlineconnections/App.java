package com.bpjoshi.onlineconnections;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class App {

	public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
	
	@RequestMapping("/")
    String home() {
        return "home";
    }

}