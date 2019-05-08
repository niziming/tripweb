package cn.zm.trip.web.controller;

import cn.zm.trip.web.commons.Msg;
import cn.zm.trip.web.domain.User;
import cn.zm.trip.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private HttpSession session;

	/**
	 * 用户登陆
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String userLogin(String uemail, String upwd) {

		User user = userService.userLogin(new User(uemail, upwd));
		if (user != null) {
			session.setAttribute("user", user);
			return "index";
		} else {
			session.setAttribute("msg", Msg.fail("邮箱或密码错误,请重新输入!"));
			return "redirect:/index";
		}

	}

	/**
	 * 前台用户注销
	 * @return
	 */
	@RequestMapping(value = "loginout", method = RequestMethod.GET)
	public String loginOut() {
		session.invalidate();
		return "index";
	}

	/**
	 * 跳转个人信息
	 */
	@RequestMapping(value = "info", method = RequestMethod.GET)
	public String info() {
		return "proscenium/user/info";
	}

	/**
	 * 跳转编辑信息
	 */
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit() {
		return "proscenium/user/edit";
	}

	/**
	 * 前台用户个人信息管理
	 */
	@RequestMapping(value = "useredithandle", method = RequestMethod.POST)
	public String userEditHandle(User user) {
		userService.updataUserInfo(user);
		session.setAttribute("user",userService.userGet(user.getUid()));
		session.setAttribute("msg",Msg.success("用户信息更新成功!"));
		return "redirect:edit";
	}


}
