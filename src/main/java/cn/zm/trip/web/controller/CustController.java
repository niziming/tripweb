package cn.zm.trip.web.controller;

import cn.zm.trip.web.dao.HotelDao;
import cn.zm.trip.web.dao.TrafficDao;
import cn.zm.trip.web.dao.ViewPointDao;
import cn.zm.trip.web.domain.Hotel;
import cn.zm.trip.web.domain.HotelExample;
import cn.zm.trip.web.domain.ViewPoint;
import cn.zm.trip.web.domain.ViewPointExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "cust")
public class CustController {
	@Autowired
	TrafficDao trafficDao;
	@Autowired
	ViewPointDao viewPointDao;
	@Autowired
	HotelDao hotelDao;
	/**
	 * 跳转定制
	 */
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index() {
		return "proscenium/cust/index";
	}

	/**
	 * 定制返回景
	 */
	@ResponseBody
	@RequestMapping(value = "viewPoint", method = RequestMethod.GET)
	public List<ViewPoint> viewPoint(String tpLocation) {
		ViewPointExample example = new ViewPointExample();
		example.createCriteria().andTpLocationEqualTo(tpLocation);
		example.setOrderByClause("tp_vid desc");
		List<ViewPoint> viewPoints = viewPointDao.selectByExample(example);
		return viewPoints;
	}

	/**
	 * 定制返回酒店
	 */
	@ResponseBody
	@RequestMapping(value = "hotel", method = RequestMethod.GET)
	public List<Hotel> hotel(String local) {
		String filePath = "/static/upload/hotelAvatar/";
		HotelExample example = new HotelExample();
		example.createCriteria().andLocalEqualTo(local);
		example.setOrderByClause("hid desc");
		System.out.println(example);
		List<Hotel> hotels = hotelDao.selectByExample(example);
		for (Hotel hotel : hotels){
			String fileSuffix = hotel.getImgUrl();
			hotel.setImgUrl(filePath + fileSuffix);
		}
		System.out.println(hotels);
		return hotels;
	}
}
