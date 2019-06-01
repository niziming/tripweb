package cn.zm.trip.web.controller;

import cn.zm.trip.web.commons.Msg;
import cn.zm.trip.web.dao.ViewPointDao;
import cn.zm.trip.web.domain.*;
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

	private HttpSession session;
	@Autowired
	private ViewPointExample viewPointExample;
	@Autowired
	private ViewPointDao viewPointDao;

	/**
	 * 旅游景点跳转
	 * @return
	 */
	@RequestMapping(value = "point", method = RequestMethod.GET)
	public String viewPoint(ViewPointExample example, Model model) {
		example.setOrderByClause("tp_vid desc");
		String prefix = "/static/upload/viewavatar/";

		List<ViewPoint> viewPoints = viewPointService.selectByExample(example);
		for (ViewPoint viewPoint : viewPoints){
			String suffix = viewPoint.getTpVpic();
			//前端img标签路径
			viewPoint.setTpVpic(prefix+suffix);
		}
		model.addAttribute("viewPoints", viewPoints);
		return "proscenium/viewpoint/view";
	}

	/**
	 * 前台景点模糊搜索
	 *
	 * 待完成
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
	 * 景点内容 跳转
	 */
	@RequestMapping(value = "content", method = RequestMethod.GET)
	public String viewContent(Integer tpVid, Model model) {
		//封装留言信息
		List<Words> lw_list = viewPointService.findByWords();
		model.addAttribute("lw_list",lw_list);

		//封装回复信息
		List<Reply> lr_list = viewPointService.findByReply();
		model.addAttribute("lr_list",lr_list);

		ViewPoint viewPoint = viewPointService.selectByPrimaryKey(tpVid);
		model.addAttribute("viewPoint", viewPoint);

		return "proscenium/viewpoint/content";
	}

	/**
	 * 前台景点模糊搜索
	 */
	@RequestMapping(value = "viewPointSearch", method = RequestMethod.GET)
	public String viewPointSearch(String keyword, Model model) {
		String prefix = "/static/upload/viewavatar/";

		ViewPoint viewPoint = new ViewPoint();
		viewPoint.setTpVname(keyword);
		viewPoint.setTpVtype(keyword);
		viewPoint.setTpLocation(keyword);
		List<ViewPoint> viewPoints = viewPointDao.viewPointSearch(viewPoint);

		for (ViewPoint vp : viewPoints){
			String imgUrl = vp.getTpVpic();
			vp.setTpVpic(prefix + imgUrl);
		}

		model.addAttribute("viewPoints", viewPoints);
		model.addAttribute("msg", Msg.success("景点查询成功!"));

		return "proscenium/viewpoint/view";
	}


}
