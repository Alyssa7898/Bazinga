package com.team.zhihu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.zhihu.bean.Reply;
import com.team.zhihu.mapper.ReplyMapper;
import com.team.zhihu.service.ReplyService;

@Service
public class ReplyServiceIpml implements ReplyService {

	@Autowired
	private ReplyMapper replyMapper;
	@Override
	public Reply selectByCommentId(Integer commentId) {
		// TODO Auto-generated method stub
		return replyMapper.selectByCommentKey(commentId);
	}
	@Override
	public int insertReply(Reply reply) {
		// TODO 自动生成的方法存根
		return replyMapper.insert(reply);
	}
	@Override
	public List<Reply> selectByCommentKey(Integer id) {
		// TODO 自动生成的方法存根
		return replyMapper.selectByCommentId(id);
	}
	

}
