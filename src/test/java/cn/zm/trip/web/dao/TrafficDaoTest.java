package cn.zm.trip.web.dao;

import cn.zm.trip.web.domain.TrafficExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})

public class TrafficDaoTest {
@Autowired
TrafficDao trafficDao;
	@Test
	public void selectByExample() {
		TrafficExample example = new TrafficExample();
		trafficDao.selectByExample(example);
	}
}