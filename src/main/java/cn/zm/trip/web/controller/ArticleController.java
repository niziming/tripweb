package cn.zm.trip.web.controller;

import cn.zm.trip.web.domain.Reply;
import cn.zm.trip.web.domain.ViewPoint;
import cn.zm.trip.web.domain.Words;
import cn.zm.trip.web.service.ViewPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {
	@Autowired
	ViewPointService viewPointService;
	/**
	 * 保存留言信息
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
	//声明用于存放留言回复信息的List集合
	private List<Words> lw_list;
	private List<Reply> lr_list;
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
}
