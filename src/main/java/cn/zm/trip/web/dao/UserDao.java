package cn.zm.trip.web.dao;

import cn.zm.trip.web.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

	/**
	 * 插入用户
	 * @param user
	 */
	void insertUser(User user);

	/**
	 * 查询所有用户
	 * @return
	 */
	List<User> selectAll();
}
