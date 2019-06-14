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

	/**
	 * 用户模糊查询
	 * @param user
	 * @return
	 */
	List<User> search(User user);

	/**
	 * 单击删除用户
	 */
	void userDelete(String uid);

	/**
	 * 用户登录
	 *
	 */
	User userLogin(User user);

	/**
	 * 用户单个查询
	 *
	 */
	User userGet(String uid);

	/**
	 * 用户信息更新
	 *
	 */
	void updataUserInfo(User user);
}
