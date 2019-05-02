package cn.zm.trip.web.service;

import cn.zm.trip.web.commons.GenerateCharacters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class UserServiceImplTest {
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
}