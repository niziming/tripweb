package cn.zm.trip.web.controller;

import cn.zm.trip.web.domain.ViewPoint;
import cn.zm.trip.web.domain.ViewPointExample;
import cn.zm.trip.web.service.ViewPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "view")
public class ViewPointController {
	@Autowired
	private ViewPointService viewPointService;
	private HttpSession session;
	private Model model;
	private ViewPointExample viewPointExample;

	/**
	 * 旅游景点跳转
	 * @return
	 */
	@ResponseBody//返回给前端
	@RequestMapping(value = "point", method = RequestMethod.GET)
	public String viewPoint(ViewPointExample example, Model model) {
		String prefix = "/static/upload/viewavatar/";
		example.setOrderByClause("tp_vid desc");
		List<ViewPoint> viewPoints = viewPointService.selectByExample(example);
		for (ViewPoint viewPoint : viewPoints){
			String suffix = viewPoint.getTpVpic();
			viewPoint.setTpVpic(prefix+suffix);
		}
		model.addAttribute("viewPoints", viewPoints);
		return "proscenium/viewpoint/view";
	}

	/**
	 * 用户模糊搜索
	 *
	 * @param keyword
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "viewsearch", method = RequestMethod.GET)
	public String userSearch(String keyword, HttpSession session) {
		//System.out.println(keyword);
		//List<ViewPoint> users = viewPoint();
		//session.setAttribute("users", users);

		return "admin/view/user_list";
	}
}
