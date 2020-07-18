package com.team.zhihu.controller;
//主页内容文章的显示

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team.zhihu.bean.Essay;
import com.team.zhihu.service.HomeService;

@Controller
public class HomeController {
	
	@Autowired
	HomeService homeservice;
	
	//主页显示
	@RequestMapping("/index")
	public String toHome(HttpServletRequest req,HttpServletResponse resp) {
		//查询所有文章
		HttpSession session=req.getSession();
		List<Essay> essays=homeservice.selectEssayWithUname(0);
		//将查到的文章列表存到session中
		session.setAttribute("essays", essays);
		
	 	return "index";
	 	
	}
	
}
