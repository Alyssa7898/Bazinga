package com.team.zhihu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team.zhihu.bean.Comment;
import com.team.zhihu.bean.Essay;
import com.team.zhihu.bean.Good;
import com.team.zhihu.bean.Reply;
import com.team.zhihu.bean.User;
import com.team.zhihu.service.CommentService;
import com.team.zhihu.service.EssayService;
import com.team.zhihu.service.GoodService;
import com.team.zhihu.service.HomeService;
import com.team.zhihu.service.ReplyService;
import com.team.zhihu.service.UserService;

@Controller
public class MineController {
	@Autowired
	private GoodService goodService;
	
	@Autowired
	private HomeService homeService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private ReplyService replyService;
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/mine")
	public String showGoodEssay(HttpServletRequest req) {
		User user = (User)req.getSession().getAttribute("curUser");
		List<Good> goods = goodService.selectByUserid(user.getId());
		List<Essay> essays = new ArrayList<>();
		for(Good good:goods) {
			Essay essay = homeService.selectById((good.getEassayid()));
			Integer commentNumber = commentService.showCommentNumber(good.getEassayid());
			essay.setCommentNumber(commentNumber);
			essays.add(essay);
		}
		req.getSession().setAttribute("goodEssays", essays);
		return "mine";
	}
	
	@ResponseBody()
	@RequestMapping("/mine/showcommit")
	public List<Comment> showCommit(@RequestParam("essayid")Integer essayid,HttpServletRequest req) {
		User user = (User)req.getSession().getAttribute("curUser");
		List<Comment> comments = commentService.selectByEssayid(essayid);
		for(Comment comment:comments) {
			Reply reply= replyService.selectByCommentId(comment.getId());
			if(reply!=null) {
				User fromUser = userService.selectByPrimaryKey(reply.getFromuserid());
				User toUser = userService.selectByPrimaryKey(reply.getTouserid());
				reply.setFromUser(fromUser);
				reply.setToUser(toUser);
				comment.setReply(reply);
			}
		}
		return comments;
	}
}
