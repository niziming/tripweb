package cn.zm.trip.web.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})

public class WordsDaoTest {
	@Autowired
	WordsDao wordsDao;
	@Test
	public void deleteByPrimaryKey() {
		wordsDao.deleteByPrimaryKey(29);
	}
}