package cn.zm.trip.web.controller;

import cn.zm.trip.web.commons.Msg;
import cn.zm.trip.web.commons.TimeStampUtil;
import cn.zm.trip.web.domain.Admin;
import cn.zm.trip.web.domain.User;
import cn.zm.trip.web.service.AdminService;
import cn.zm.trip.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
	 * 登录成功后跳转管理界面
	 *
	 * @return
	 */
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String main() {
		return "admin/main";
	}

	/**
	 * 注销
	 */
	@RequestMapping(value = "loginout", method = RequestMethod.GET)
	public String loginOut(HttpSession session) {
		//销毁session
		session.invalidate();
		return login();
	}

	/**
	 * 查看用户列表
	 *
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "userlist", method = RequestMethod.GET)
	public String userList(HttpSession session) {
		List<User> users = userService.selectAll();
		session.setAttribute("users", users);
		return "admin/user_list";
	}

	/**
	 * 用户模糊搜索
	 *
	 * @param keyword
	 * @param session
	 * @return
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
	 * 单机删除
	 *
	 * @param uid
	 * @return
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
	 * 用户注册表单
	 *
	 * @return
	 */
	@RequestMapping(value = "userform", method = RequestMethod.GET)
	public String userForm() {
		return "admin/user_form";
	}

	/**
	 * 用户注册表单
	 *
	 * @return
	 */
	@RequestMapping(value = "userinsert", method = RequestMethod.POST)
	public String userInsert(String uname, String uemail, String upwd) {
		userService.insertUser(uname, uemail, upwd);
		session.setAttribute("msg", Msg.success("新增用户成功"));
		return "redirect:userlist";
	}

	/**
	 * 用户批量删除功能
	 *
	 * @param uids
	 * @return "redirect:user_list";
	 */
	@RequestMapping(value = "usersectiondelete", method = RequestMethod.GET)
	@ResponseBody
	public String userSectionDelete(String[] uids) {
		for (String uid : uids) {
			userService.userDelete(uid);
		}
		session.setAttribute("msg", Msg.success(Arrays.toString(uids) + "号用户批量删除成功!"));
		return "1";
	}

	/**
	 * 跳转用户编辑界面
	 *
	 * @param
	 * @return "redirect:user_edit";
	 */
	@RequestMapping(value = "useredit", method = RequestMethod.GET)
	public String userEdit(String uid) {
		User user = userService.userGet(uid);
		System.out.println(user);
		session.setAttribute("user",user);

		return "admin/user_edit";
	}

	/**
	 * 跳转用户编辑处理
	 *
	 * @param
	 * @return "redirect:user_edit";
	 */
	@RequestMapping(value = "useredithandle", method = RequestMethod.POST)
	public String userEditHandle(User user) {
		userService.updataUserInfo(user);
		session.setAttribute("msg",Msg.success("用户信息保存成功!"));
		return "redirect:userlist";
	}


}