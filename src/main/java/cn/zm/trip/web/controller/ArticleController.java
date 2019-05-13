package cn.zm.trip.web.controller;

import cn.zm.trip.web.dao.ForumDao;
import cn.zm.trip.web.dao.HotelDao;
import cn.zm.trip.web.domain.*;
import cn.zm.trip.web.service.ViewPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "article")
public class ArticleController {
	//声明用于存放留言回复信息的List集合
	private List<Words> lw_list;
	private List<Reply> lr_list;

	@Autowired
	ViewPointService viewPointService;
	@Autowired
	ForumDao forumDao;
	@Autowired
	HotelDao hotelDao;

	/**
	 * 保存景点留言信息
	 */
	@RequestMapping(value="/saveWords")
	public String saveWords(Words words){
		if(words != null){
			String r_id = words.getLw_for_article_id();
			viewPointService.saveWords(words);
			return "redirect:toArticleView.do?r_id="+r_id;
		}else{
			return null;
		}
	}

	/**
	 * 保存回复信息
	 */
	@RequestMapping(value="/saveReply")
	public String saveReply(Reply reply){
		if(reply != null){
			viewPointService.saveReply(reply);
			String r_id = reply.getLr_for_article_id();
			return "redirect:toArticleView.do?r_id="+r_id;
		}else{
			return null;
		}
	}

	/**
	 * 跳转到查看文章内容页面
	 */
	@RequestMapping(value="/toArticleView")
	public String toArticleView(@RequestParam int r_id, Model model){
		//封装留言信息
		lw_list = viewPointService.findByWords();
		model.addAttribute("lw_list",lw_list);

		//封装回复信息
		lr_list = viewPointService.findByReply();
		model.addAttribute("lr_list",lr_list);

		//查询文章信息
		ViewPoint viewPoint = viewPointService.selectByPrimaryKey(r_id);
		System.out.println("查询到当前文章的ID值：" + viewPoint.getTpVid());

		if (viewPoint != null) {
			model.addAttribute("viewPoint", viewPoint);
			return "proscenium/viewpoint/content";
		} else {
			return null;
		}
	}


	/**
	 * 保存论坛回复信息
	 */
	@RequestMapping(value="/saveForumReply")
	public String saveForumReply(Reply reply){
		if(reply != null){
			viewPointService.saveReply(reply);
			String tpFid = reply.getLr_forumId();
			return "redirect:toForumArticleView.do?tpFid=" + tpFid;
		}else{
			return null;
		}
	}

	/**
	 * 保存论坛留言信息
	 */
	@RequestMapping(value="/saveforumWords")
	public String saveForumWords(Words words){
		if(words != null){
			String forumId = words.getLw_forumId();//获取什么类型的ID
			viewPointService.saveWords(words);
			return "redirect:toForumArticleView.do?tpFid=" + forumId;
		}else{
			return null;
		}
	}

	/**
	 * 跳转到论坛
	 */

	@RequestMapping(value="/toForumArticleView")
	public String toForumArticleView(@RequestParam int tpFid, Model model){
		//封装留言信息
		lw_list = viewPointService.findByWords();
		model.addAttribute("lw_list",lw_list);

		//封装回复信息
		lr_list = viewPointService.findByReply();
		model.addAttribute("lr_list",lr_list);

		//查询文章信息
		Forum forum = forumDao.selectByPrimaryKey(tpFid);

		System.out.println("查询到当前文章的ID值：" + forum.getTpFid());

		if (forum != null) {
			model.addAttribute("forum", forum);
			return "proscenium/forum/content";
		} else {
			return null;
		}
	}


	/**
	 * 保存论坛回复信息
	 */
	@RequestMapping(value="/saveHotelReply")
	public String saveHotelReply(Reply reply){
		if(reply != null){
			viewPointService.saveReply(reply);
			String hid = reply.getLr_hotel_id();
			return "redirect:toHotelArticleView.do?hid=" + hid;
		}else{
			return null;
		}
	}

	/**
	 * 保存论坛留言信息
	 */
	@RequestMapping(value="/saveHotelWords")
	public String saveHotelWords(Words words){
		if(words != null){
			String hid = words.getLw_hotel_id();
			viewPointService.saveWords(words);
			return "redirect:toHotelArticleView.do?hid=" + hid;
		}else{
			return null;
		}
	}

	/**
	 * 跳转到论坛
	 */

	@RequestMapping(value="/toHotelArticleView")
	public String toHotelArticleView(@RequestParam int hid, Model model){
		//封装留言信息
		lw_list = viewPointService.findByWords();
		model.addAttribute("lw_list",lw_list);

		//封装回复信息
		lr_list = viewPointService.findByReply();
		model.addAttribute("lr_list",lr_list);

		//查询文章信息
		Hotel hotel = hotelDao.selectByPrimaryKey(hid);

		System.out.println("查询到当前文章的ID值：" + hotel.getHid());

		if (hotel != null) {
			model.addAttribute("hotel", hotel);
			return "proscenium/hotel/content";
		} else {
			return null;
		}
	}

}
