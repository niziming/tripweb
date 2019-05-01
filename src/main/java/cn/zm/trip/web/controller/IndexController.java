package cn.zm.trip.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	/**
	 * 跳转首页
	 * @return
	 */
	@RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
	public String index() {
		return "index";
	}

}
