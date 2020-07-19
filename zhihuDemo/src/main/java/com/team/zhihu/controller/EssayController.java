package com.team.zhihu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.team.zhihu.bean.Essay;
import com.team.zhihu.service.EssayService;
import com.team.zhihu.utils.DateUtil;
import com.team.zhihu.utils.MsgPrintUtil;

@Controller
public class EssayController {
	@Autowired 
	private EssayService essayService;	
	
	@RequestMapping("essay/write")
	public String toWriteEssay(HttpServletRequest request) {
		return "writeessay";		
	}
	@RequestMapping("essay/index")
	public String toIndex() {
		return "index";
	}
	
	@RequestMapping("essay/publish")
	public String publishEssay(String title,String content 
			,HttpServletRequest request,HttpServletResponse resp) throws IOException{
		HttpSession session=request.getSession();
		Essay essay=null;
		title=request.getParameter("title");
		content=request.getParameter("content");
		int goodnum=0;
		int type=0;
		int topicType=0;
		Date date =new Date();
		int userid=(int)session.getAttribute("currId");
		String time=DateUtil.dateToString(date);
		essay=new Essay(null,title,content,goodnum,type,topicType,userid,time);
		int n=essayService.insert(essay);
		if(n!=0) {
		    MsgPrintUtil.doResponse(resp, "发布成功！", "index");
		    return "index";	
		}
		else {
		    MsgPrintUtil.doResponse(resp, "发布异常，请重新发布", "/essay/write");
	 		return "writeessay";	
		}
	  
	
		
	}

}
