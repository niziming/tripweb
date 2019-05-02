package cn.zm.trip.web.controller;

import cn.zm.trip.web.commons.Msg;
import cn.zm.trip.web.commons.TimeStampUtil;
import cn.zm.trip.web.domain.Admin;
import cn.zm.trip.web.domain.User;
import cn.zm.trip.web.service.AdminService;
import cn.zm.trip.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "admin")
public class AdminController {
	@Autowired
	private AdminService adminService;

	@Autowired
	private UserService userService;

	/**
	 * 从前端跳转到后台登陆
	 *
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "admin/login";
	}

	/**
	 * 登陆逻辑
	 *handle
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
	 * 登录成功后跳转管理界面
	 * @return
	 */
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String main(){
		return "admin/main";
	}

	/**
	 * 注销
	 */
	@RequestMapping(value = "loginout", method = RequestMethod.GET)
	public String loginOut(HttpSession session){
		//销毁session
		session.invalidate();
		return login();
	}

	/**
	 * 查看用户列表
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "userlist", method = RequestMethod.GET)
	public String userList(HttpSession session) {
		List<User> users = userService.selectAll();
		session.setAttribute("users", users);
		return "admin/user_list";
	}

}