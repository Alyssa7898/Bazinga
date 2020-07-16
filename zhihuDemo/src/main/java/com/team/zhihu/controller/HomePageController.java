package com.team.zhihu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.zhihu.bean.User;
import com.team.zhihu.mapper.UserMapper;

@Controller
public class HomePageController {
	
	 @Autowired
	 private UserMapper userMapper;
	
	 @RequestMapping("/")
	    public String home(String name) {
		 	User user = userMapper.selectByPrimaryKey(1);
		 	System.out.println(user);
	        return "login";
	    }
}
