package com.team.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.bean.Book;
import com.team.mapper.BookMapper;

@Controller
public class login {
	
	@Autowired
	BookMapper bookMapper;
	
	@RequestMapping("user/login")
	//自动注入
	public String login(String username,String password,Model model) {
		
		//测试mybatis是否成功
		Book book = bookMapper.findAll();
	
		
		System.out.println(password+"  "+username);
		 model.addAttribute("books", book);
		
		return "index";//跳转到模板引擎下
	}
}
