package cn.zm.trip.web.controller;

import cn.zm.trip.web.commons.Msg;
import cn.zm.trip.web.commons.TimeStampUtil;
import cn.zm.trip.web.domain.Admin;
import cn.zm.trip.web.domain.User;
import cn.zm.trip.web.domain.ViewPoint;
import cn.zm.trip.web.domain.ViewPointExample;
import cn.zm.trip.web.service.AdminService;
import cn.zm.trip.web.service.UserService;
import cn.zm.trip.web.service.ViewPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private UserService userService;
	@Autowired
	private HttpSession session;
	@Autowired
	private ViewPointService viewPointService;

	/**
	 ***********login start***************
	 * 从前端跳转到后台登陆
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "admin/login";
	}

	/**
	 * 登陆逻辑
	 * handle
	 *
	 * @param aemail 用户邮箱
	 * @param apwd   密码
	 * @return String
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	// @RequestParam(required = true) 为true时意思为不可缺省
	public String login(String aemail, String apwd, HttpSession session) {
		Admin admin = adminService.login(aemail, apwd);
		String timestamp = TimeStampUtil.getTimeFormat();

		//登录失败
		if (admin == null) {
			session.setAttribute("msg", Msg.fail("邮箱或者密码错误!"));
			return login();
		}
		//登陆成功
		else {

			// 将登录信息放入session
			session.setAttribute("msg", Msg.success());
			session.setAttribute("timestamp", timestamp);
			session.setAttribute("admin", admin);
			// 明日任务,获取域对象传送user信息
			return "redirect:main";
		}
	}

	/**
	 * 后台注销
	 */
	@RequestMapping(value = "loginout", method = RequestMethod.GET)
	public String loginOut(HttpSession session) {
		//销毁session
		session.invalidate();
		return login();
	}
	//**********login end***************

	/**
	 * **********main start***************
	 * 登录成功后跳转管理主界面
	 * @return
	 */
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String main() {
		return "admin/main";
	}
	//**********main end***************


	/**********user start***************
	 * 查看用户列表
	 */
	@RequestMapping(value = "userlist", method = RequestMethod.GET)
	public String userList() {
		String prefix = "/static/upload/useravatar/";
		List<User> users = userService.selectAll();
		for (User user : users){
			String suffix = user.getUpic();
			user.setUpic(prefix+suffix);
		}
		session.setAttribute("users", users);
		return "admin/user_list";
	}

	/**
	 * 用户模糊搜索
	 */
	@RequestMapping(value = "usersearch", method = RequestMethod.GET)
	public String userSearch(String keyword, HttpSession session) {
		System.out.println(keyword);
		List<User> users = userService.search(keyword);

		session.setAttribute("users", users);
		session.setAttribute("msg", Msg.success("用户查询成功!"));

		return "admin/user_list";
	}

	/**
	 * 用户单个单击删除
	 */
	@RequestMapping(value = "userdelete", method = RequestMethod.GET)
	public String userDelete(String uid) {
		System.out.println(uid);
		userService.userDelete(uid);
		session.setAttribute("users", userService.selectAll());
		session.setAttribute("msg", Msg.success(uid + "号用户删除成功!"));
		return "admin/user_list";
	}

	/**
	 * 用户新增表单跳转
	 */
	@RequestMapping(value = "userform", method = RequestMethod.GET)
	public String userForm() {
		return "admin/user_form";
	}

	/**
	 * 用户新增
	 */
	@RequestMapping(value = "userinsert", method = RequestMethod.POST)
	public String userInsert(String uname, String uemail, String upwd) {
		userService.insertUser(uname, uemail, upwd);
		session.setAttribute("msg", Msg.success("新增用户成功"));
		return "redirect:userlist";
	}

	/**
	 * 用户批量删除功能
	 */
	@RequestMapping(value = "usersectiondelete", method = RequestMethod.GET)
	@ResponseBody//返回给前端
	public String userSectionDelete(String[] uids) {
		for (String uid : uids) {
			userService.userDelete(uid);
		}
		session.setAttribute("msg", Msg.success(Arrays.toString(uids) + "号用户批量删除成功!"));
		return "1";
	}

	/**
	 * 跳转用户编辑更新界面
	 */
	@RequestMapping(value = "useredit", method = RequestMethod.GET)
	public String userEdit(String uid) {
		User user = userService.userGet(uid);
		System.out.println(user);
		session.setAttribute("user",user);

		return "admin/user_edit";
	}

	/**
	 * 跳转用户更新业务
	 */
	@RequestMapping(value = "useredithandle", method = RequestMethod.POST)
	public String userEditHandle(User user) {
		userService.updataUserInfo(user);
		session.setAttribute("msg",Msg.success("用户信息保存成功!"));
		return "redirect:userlist";
	}
	//**********user start***************


	/************view start***************
	 * 跳转内容管理 景点列表
	 */
	@RequestMapping(value = "viewlist", method = RequestMethod.GET)
	public String viewPoint(ViewPointExample example, Model model, HttpServletRequest request) {
		example.setOrderByClause("tp_vid desc");
		String prefix = "/static/upload/viewavatar/";
		List<ViewPoint> viewPoints = viewPointService.selectByExample(example);
		for (ViewPoint viewPoint : viewPoints){
			String suffix = viewPoint.getTpVpic();
			//前端img标签路径
			viewPoint.setTpVpic(prefix+suffix);
		}
		//存储信息转发
		model.addAttribute("viewPoints", viewPoints);
		return "admin/view_list";
	}

	/**
	 * 用户批量删除功能
	 */
	@RequestMapping(value = "viewsectiondelete", method = RequestMethod.GET)
	@ResponseBody//返回给前端
	public String viewSectionDelete(Integer[] tpVids) {
		for (Integer tpVid : tpVids) {
			viewPointService.deleteviews(tpVid);
		}
		session.setAttribute("msg", Msg.success(Arrays.toString(tpVids) + "号景点批量删除成功!"));
		return "1";
	}

	/**
	 * 用户单个单击删除
	 */
	@RequestMapping(value = "viewdelete", method = RequestMethod.GET)
	public String viewDelete(Integer tpVid) {
		viewPointService.deleteviews(tpVid);
		session.setAttribute("msg", Msg.success(tpVid + "号用户删除成功!"));
		return "redirect:viewlist";
	}

	/**
	 * 景点新增表单跳转
	 */
	@RequestMapping(value = "viewform", method = RequestMethod.GET)
	public String viewForm() {
		return "admin/view_form";
	}

	/**
	 * 景点新增
	 */
	@RequestMapping(value = "viewinsert", method = RequestMethod.POST)
	public String viewInsert(ViewPoint viewPoint) {
		if (viewPoint.getTpVid() == null){
			viewPointService.insertView(viewPoint);
			session.setAttribute("msg", Msg.success("新增景点成功!"));
			return "redirect:viewlist";
		}
		session.setAttribute("msg", Msg.fail("新增景点失败!"));
		return "redirect:viewlist";
	}


	/**
	 * 跳转景点编辑更新界面
	 */
	@RequestMapping(value = "viewedit", method = RequestMethod.GET)
	public String viewEdit(Integer tpVid, Model model) {
		ViewPoint viewPoint = viewPointService.selectByPrimaryKey(tpVid);
		model.addAttribute("viewPoint", viewPoint);
		return "admin/view_edit";
	}

	/**
	 * 跳转景点更新业务
	 */
	@RequestMapping(value = "viewedithandle", method = RequestMethod.POST)
	public String viewEditHandle(ViewPoint viewPoint) {
		viewPointService.updateByPrimaryKeySelective(viewPoint);
		session.setAttribute("msg",Msg.success("景点信息保存成功!"));
		return "redirect:viewlist";
	}

	/**
	 * 跳转景点内容页面
	 */
	@RequestMapping(value = "viewcontent", method = RequestMethod.GET)
	public String viewContent(Integer tpVid, Model model) {
		String prefix = "/static/upload/viewavatar/";
		ViewPoint viewPoint = viewPointService.selectByPrimaryKey(tpVid);

		model.addAttribute("viewPoint", viewPoint);
		String suffix = viewPoint.getTpVpic();

		viewPoint.setTpVpic(prefix+suffix);

		return "admin/view_content";
	}




	//**********view end***************
}