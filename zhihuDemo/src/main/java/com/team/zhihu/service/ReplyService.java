package com.team.zhihu.service;

import java.util.List;

import com.team.zhihu.bean.Reply;

public interface ReplyService {

	Reply selectByCommentId(Integer commentId);
	
	int insertReply(Reply reply);
	
	List<Reply> selectByCommentKey(Integer id);
}
