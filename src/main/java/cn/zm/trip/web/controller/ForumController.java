package cn.zm.trip.web.controller;

import cn.zm.trip.web.commons.Msg;
import cn.zm.trip.web.dao.ForumDao;
import cn.zm.trip.web.domain.Forum;
import cn.zm.trip.web.domain.ForumExample;
import cn.zm.trip.web.domain.Reply;
import cn.zm.trip.web.domain.Words;
import cn.zm.trip.web.service.ForumService;
import cn.zm.trip.web.service.ViewPointService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 论坛模块
 */
@Controller
@RequestMapping(value = "forum")
public class ForumController {
	@Autowired
	ForumService forumService;
	@Autowired
	ForumExample example;
	@Autowired
	ForumDao forumDao;
	@Autowired
	Words words;
	@Autowired
	Reply reply;
	@Autowired
	ViewPointService viewPointService;

	private Model model;
	/**
	 * 倒序查询帖子 跳转forum页面
	 */
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(Model model){
		example.setOrderByClause("tp_fid desc");
		List<Forum> forums = forumDao.selectByExampleWithBLOBs(example);
		model.addAttribute("forums",forums);
		return "proscenium/forum/index";
	}

	/**
	 * 倒序查询帖子 跳转forum页面
	 */
	@RequestMapping(value = "content", method = RequestMethod.GET)
	public String content(Integer tpFid, Model model){
		//封装留言信息
		List<Words> byWords = viewPointService.findByWords();
		model.addAttribute("lw_list",byWords);

		//封装回复信息
		List<Reply> byReply = viewPointService.findByReply();
		model.addAttribute("lr_list",byReply);

		Forum forum = forumDao.selectByPrimaryKey(tpFid);

		model.addAttribute("forum",forum);
		return "proscenium/forum/content";
	}

	/**
	 * 后台论坛模糊搜索
	 */
	@RequestMapping(value = "forumPointSearch", method = RequestMethod.GET)
	public String forumPointSearch(String keyword, Model model) {

		Forum forum = new Forum();

		forum.setTpTag(keyword);
		forum.setTpTitle(keyword);
		forum.setTpSubTitle(keyword);
		forum.setTpAuthor(keyword);

		List<Forum> forums = forumDao.forumPointSearch(forum);

		model.addAttribute("forums", forums);
		model.addAttribute("msg", Msg.success("论坛查询成功!"));

		return "proscenium/forum/index";
	}

	/**
	 * 发帖功能 跳转编辑页面
	 */
	@RequestMapping(value = "issue", method = RequestMethod.GET)
	public String issue(Integer uid, Model model){
		if (uid != null){
			return "proscenium/forum/edit";
		}
		example.setOrderByClause("tp_fid desc");
		List<Forum> forums = forumDao.selectByExampleWithBLOBs(example);
		model.addAttribute("forums",forums);
		model.addAttribute("msg", Msg.fail("您还未登录!"));
		return "proscenium/forum/index";
	}

	/**
	 * 编辑页面
	 */
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit(Integer uid, Model model){
		if (uid != null){
			return "proscenium/forum/edit";
		}
		model.addAttribute("msg", Msg.fail("您还未登录!"));
		return "redirect:index";
	}

	/**
	 * content
	 */
	@RequestMapping(value = "savecontent", method = RequestMethod.POST)
	public String saveContent(Forum forum, Model model){
		forumDao.insert(forum);
		model.addAttribute("msg", Msg.success("发帖成功"));
		return "redirect:index";
	}

	/*############后台开始##############*/



}
