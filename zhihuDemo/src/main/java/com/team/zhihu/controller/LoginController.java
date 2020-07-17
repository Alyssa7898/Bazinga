package com.team.zhihu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.team.zhihu.bean.User;
import com.team.zhihu.mapper.UserMapper;
import com.team.zhihu.service.UserService;


@Controller
public class LoginController {
	
	 @Autowired
	 private UserService userService;
	 
	//用户登录
	 @RequestMapping("user/login")
     public String userLogin(User user,HttpServletRequest req,HttpServletResponse resp) throws IOException {
	 	 User loginUser = userService.selectByUser(user);
	 	
	 	 HttpSession session = req.getSession();
	 	 // 将当前用户放到session中 名为curUser
	 	 session.setAttribute("curUser", loginUser);
	 	 if(loginUser!=null) {
	 		 return "redirect:/index";
	 	 }else {
	 		resp.setContentType("text/html; charset=UTF-8");
	 		PrintWriter out = resp.getWriter();
			out.write("<script>");
			out.write("alert('登录失败，用户名或密码错误');");
			out.write("location.href='/';");
			out.write("</script>");
			out.close();
	 		return "login";
	 	 }
     }
	 
	 //用户注册
	 @RequestMapping("/user/doRegister")
	 public String userRegister(User user,HttpServletResponse resp) throws IOException {
		 User registerUser = userService.selectByphonenumber(user.getPhonenumber());
		 //电话号码不相同 就插入
		 if(registerUser==null) {
		 int i =  userService.insertUser(user);
			 if(i>0) {
				 resp.setContentType("text/html; charset=UTF-8");
			 		PrintWriter out = resp.getWriter();
					out.write("<script>");
					out.write("alert('注册成功');");
					out.write("location.href='/';");
					out.write("</script>");
					out.close();
				 return "login";
			 }else {
				 resp.setContentType("text/html; charset=UTF-8");
			 		PrintWriter out = resp.getWriter();
					out.write("<script>");
					out.write("alert('注册失败');");
					out.write("location.href='/user/register';");
					out.write("</script>");
					out.close();
				 return "register";
			 }
		 }else {
			 resp.setContentType("text/html; charset=UTF-8");
		 		PrintWriter out = resp.getWriter();
				out.write("<script>");
				out.write("alert('该电话号码已被注册');");
				out.write("location.href='/user/register';");
				out.write("</script>");
				out.close();
			 return "register";
		 }
	 }
	 
	 
}
