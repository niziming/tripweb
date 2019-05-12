package cn.zm.trip.web.controller;

import cn.zm.trip.web.domain.ViewPoint;
import cn.zm.trip.web.domain.ViewPointExample;
import cn.zm.trip.web.service.ViewPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "view")
public class ViewPointController {
	@Autowired
	private ViewPointService viewPointService;

	/**
	 * 旅游景点跳转
	 * @return
	 */
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
	 * 前台用户模糊搜索
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

	/**
	 * 前台景查看更多内容跳转
	 */
	@RequestMapping(value = "content", method = RequestMethod.GET)
	public String content(Integer tpVid, Model model) {
		ViewPoint viewPoint = viewPointService.selectByPrimaryKey(tpVid);
		model.addAttribute("viewPoint",viewPoint);
		return "proscenium/viewpoint/content";
	}

	/**
	 * 论坛功能
	 */
	@RequestMapping(value = "forum", method = RequestMethod.GET)
	public String forum() {

		return "proscenium/viewpoint/forum";
	}
}
