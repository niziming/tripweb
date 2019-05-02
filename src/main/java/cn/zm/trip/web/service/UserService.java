package cn.zm.trip.web.service;

import cn.zm.trip.web.domain.User;

import java.util.List;

public interface UserService {
	/**
	 * 插入用户
	 * @param
	 */
	void insertUser(String uname, String email, String upwd);

	/**
	 * 查询所有用户
	 * @return
	 */
	List<User> selectAll();
}
