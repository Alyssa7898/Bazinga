package com.team.zhihu.service;

import java.util.List;

import com.team.zhihu.bean.Essay;

public interface HomeService {
	List<Essay> selectEssayWithUname(int type);
}
