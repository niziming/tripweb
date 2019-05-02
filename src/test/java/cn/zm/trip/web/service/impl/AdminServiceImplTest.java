package cn.zm.trip.web.service.impl;

import cn.zm.trip.web.domain.Admin;
import cn.zm.trip.web.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class AdminServiceImplTest {
	@Autowired
	private AdminService adminService;
	@Test
	public void login() {
		String email = "ziming@admin.com";
		String pwd = "admin";
		Admin user = adminService.login(email, pwd);
		System.out.println(user);
	}
}