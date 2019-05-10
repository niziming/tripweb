package cn.zm.trip.web.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class UserServiceTest {
	@Autowired
	UserService userService;
	@Test
	public void insertUser() {
	}

	@Test
	public void selectAll() {
		userService.selectAll();
	}

	@Test
	public void search() {
	}

	@Test
	public void userDelete() {
	}

	@Test
	public void userLogin() {
	}

	@Test
	public void userGet() {
	}

	@Test
	public void updataUserInfo() {
	}
}