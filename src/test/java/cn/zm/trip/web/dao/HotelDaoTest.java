package cn.zm.trip.web.dao;

import cn.zm.trip.web.domain.Hotel;
import cn.zm.trip.web.domain.HotelExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
public class HotelDaoTest {
	@Autowired
	HotelDao hotelDao;

	@Test
	public void selectByExample() {
		HotelExample example = new HotelExample();
		example.setOrderByClause("hid desc");
		List<Hotel> hotels = hotelDao.selectByExample(example);
		for (Hotel hotel : hotels) {
			System.out.println(hotel);
		}
	}
}