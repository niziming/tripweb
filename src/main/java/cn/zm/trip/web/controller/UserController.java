package cn.zm.trip.web.controller;

import cn.zm.trip.web.commons.Msg;
import cn.zm.trip.web.domain.User;
import cn.zm.trip.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String userLogin(String uemail, String upwd, Model model) {

		if (uemail == null || uemail == "" || upwd == null || upwd == "") {
			session.setAttribute("msg", Msg.fail("邮箱或密码不可为空!"));
			return "redirect:/index";
		}
		User user = userService.userLogin(new User(uemail, upwd));
		if (user != null) {
			session.setAttribute("user", user);
			return "redirect:/index";
		} else {
			session.setAttribute("msg", Msg.fail("还未注册或邮箱密码错误,请重新输入!"));
			return "redirect:/index";
		}

	}

	/**
	 * 前台用户注销
	 *
	 * @return
	 */
	@RequestMapping(value = "loginout", method = RequestMethod.GET)
	public String loginOut() {
		session.invalidate();
		return "redirect:/index";
	}

	/**
	 * 跳转注册用户
	 *
	 * @return
	 */
	@RequestMapping(value = "regst", method = RequestMethod.GET)
	public String regst() {
		return "proscenium/user/regst";
	}

	@RequestMapping(value = "regstform", method = RequestMethod.POST)
	public String regst(String uname, String uemail, String upwd, String reupwd, Model model) {
		if (uemail == null || upwd == null || uemail.trim().equals("") || upwd.trim().equals("")) {
			model.addAttribute("msg", Msg.fail("用户名或密码不可为空,请重新输入!"));
		} else if (!reupwd.equals(upwd)) {
			model.addAttribute("msg", Msg.fail("密码不正确请重新输入!"));
		} else {
			userService.insertUser(uname, uemail, upwd);
			model.addAttribute("msg", Msg.success("用户注册成功!"));
		}
		System.out.println(!uemail.trim().equals(""));
		return "proscenium/user/regst";
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
		session.setAttribute("user", userService.userGet(user.getUid()));
		session.setAttribute("msg", Msg.success("用户信息更新成功!"));
		return "redirect:edit";
	}


}
