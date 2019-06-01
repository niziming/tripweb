package cn.zm.trip.web.dao;

import cn.zm.trip.web.domain.ViewPoint;
import cn.zm.trip.web.domain.Words;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})

public class ViewPointDaoTest {
	@Autowired
	ViewPointDao viewPointDao;
	@Test
	public void findByWords() {
		List<Words> byWords = viewPointDao.findByWords();
		for (Words word : byWords){
			System.out.println(word.getLw_hotel_id());
		}
	}

	@Test
	public void viewPointSearch() {
		String keyword = "锦里";
		ViewPoint viewPoint = new ViewPoint();
		viewPoint.setTpVname(keyword);
		List<ViewPoint> viewPoints = viewPointDao.viewPointSearch(viewPoint);
	}
}