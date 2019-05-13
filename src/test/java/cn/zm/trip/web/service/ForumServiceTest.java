package cn.zm.trip.web.service;

import cn.zm.trip.web.domain.Forum;
import cn.zm.trip.web.domain.ForumExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})

public class ForumServiceTest {
	@Autowired
	ForumService forumService;

	@Test
	public void selectByExampleWithBLOBs() {
		List<Forum> forums = forumService.selectByExampleWithBLOBs();
		for (Forum forum : forums){
			System.out.println(forum.getTpTcontent());
		}
	}
}