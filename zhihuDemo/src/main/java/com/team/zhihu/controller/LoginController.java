package com.team.zhihu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.team.zhihu.bean.User;
import com.team.zhihu.mapper.UserMapper;

@Controller
public class LoginController {
	
	@Autowired
	UserMapper userMapper;
	
	@RequestMapping("login")
	//自动注入
	public String login(String username,String password,Model model) {
		
//		//测试mybatis是否成功
//		List<User>user=userMapper.selectByExample(null);
//		if (user!=null) 
//		{		
//		System.out.println(password+"  "+username);
//		
//		return "index";//跳转到模板引擎下
//		}
		return "index";
	}
}
