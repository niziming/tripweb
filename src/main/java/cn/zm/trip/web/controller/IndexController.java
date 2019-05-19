package cn.zm.trip.web.controller;

import cn.zm.trip.web.dao.HotelDao;
import cn.zm.trip.web.domain.Hotel;
import cn.zm.trip.web.domain.HotelExample;
import cn.zm.trip.web.domain.ViewPoint;
import cn.zm.trip.web.domain.ViewPointExample;
import cn.zm.trip.web.service.ViewPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "")
public class IndexController {
	@Autowired
	private ViewPointService viewPointService;
	@Autowired
	private HotelDao hotelDao;

	/**
	 * 跳转首页
	 */
	@RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
	public String index(ViewPointExample example, Model model) {
		HotelExample hotelExample = new HotelExample();
		//显示首页的景点
		String prefix = "/static/upload/viewavatar/";
		//酒店
		String prefixHotel = "/static/upload/hotelAvatar/";
		example.setOrderByClause("tp_vid desc");
		List<ViewPoint> viewPoints = viewPointService.selectByExample(example);
		for (ViewPoint viewPoint : viewPoints) {
			String suffix = viewPoint.getTpVpic();
			viewPoint.setTpVpic(prefix + suffix);
		}

		//酒店
		hotelExample.setOrderByClause("hid desc");
		List<Hotel> hotels = hotelDao.selectByExample(hotelExample);
		for (Hotel hotel : hotels) {
			String suffix = hotel.getImgUrl();
			hotel.setImgUrl(prefixHotel + suffix);
		}

		//传送景点
		model.addAttribute("viewPoints", viewPoints);
		model.addAttribute("hotels", hotels);
		return "index";
	}

}
