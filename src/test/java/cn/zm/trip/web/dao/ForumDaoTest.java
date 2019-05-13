package cn.zm.trip.web.dao;

import cn.zm.trip.web.domain.Forum;
import cn.zm.trip.web.domain.ForumExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})

public class ForumDaoTest {
	@Autowired
	ForumDao forumDao;
	@Test
	public void selectByExampleWithBLOBs() {
		List<Forum> forums = forumDao.selectByExampleWithBLOBs(new ForumExample());

	}
}