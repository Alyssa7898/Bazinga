package com.team.zhihu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
	 @RequestMapping("/")
	    public String home(String name) {
	        return "login";
	    }

}
