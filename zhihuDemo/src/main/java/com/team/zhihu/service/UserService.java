package com.team.zhihu.service;

import org.springframework.stereotype.Service;

import com.team.zhihu.bean.User;


public interface UserService {
	

	public User selectByUser(User user);

	public int insertUser(User user);

	public User selectByphonenumber(String phonenumber);

	public User selectByUserName(String username);
	
}
