package cn.zm.trip.web.service;

import cn.zm.trip.web.commons.GenerateCharacters;
import cn.zm.trip.web.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class UserServiceTest {
	@Autowired
	private UserService userService;

	@Test
	public void insertUser() {
		int i = 5;
		while (i>0){
			userService.insertUser(GenerateCharacters.generateString(8).toString(), "random@Generate.cn", "test");
			i--;
		}
	}

	@Test
	public void selectAll() {
		List<User> users = userService.selectAll();
		for (User user : users){
			System.out.println(user);
		}
	}

	@Test
	public void search() {
		List<User> method = userService.search("@");
		System.out.println(method);
	}

	@Test
	public void userDelete() {
		userService.userDelete("37");
	}

	@Test
	public void userLogin() {
		User user = new User("user@test.com", "user");
		User userLogin = userService.userLogin(user);
		System.out.println(userLogin);
	}

	@Test
	public void userGet() {
		System.out.println(userService.userGet("1"));
	}

	@Test
	public void updataUserInfo() {
		User user = new User();
		user.setUid("2");
		user.setUemail("xueqing@test.com");
		System.out.println(user);
		userService.updataUserInfo(user);
		System.out.println(userService.userGet("2"));
	}
}