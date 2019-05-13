package cn.zm.trip.web.service;

import cn.zm.trip.web.domain.Forum;

import java.util.List;

public interface ForumService {
	/**
	 * 	查询所有帖子
	 */
	List<Forum> selectByExampleWithBLOBs();
}
