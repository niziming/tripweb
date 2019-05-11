package cn.zm.trip.web.service;

import cn.zm.trip.web.domain.Reply;
import cn.zm.trip.web.domain.ViewPoint;
import cn.zm.trip.web.domain.ViewPointExample;
import cn.zm.trip.web.domain.Words;

import java.util.List;

public interface ViewPointService {
	/**
	 * 查询单个景点 根据vid
	 * @param tpVid
	 * @return
	 */
	ViewPoint selectByPrimaryKey(Integer tpVid);

	/**
	 * 查询所有景点,用于景点模块
	 * @param example
	 * @return
	 */
	List<ViewPoint> selectByExample(ViewPointExample example);

	/**
	 * 新增景点
	 * @param viewPoint
	 */
	void insertView(ViewPoint viewPoint);

	/**
	 * 批量删除景点
	 */
	void deleteviews(Integer tpVid);

	/**
	 * 更新景点信息
	 */
	void updateByPrimaryKeySelective(ViewPoint viewPoint);

	/**
	 * 保存回复
	 * @param words
	 * @return
	 */
	void saveWords(Words words);

	/**
	 * 保存回复信息
	 * @param reply
	 */
	void saveReply(Reply reply);

	/**
	 * 查询所有留言信息
	 * @return
	 */
	List<Words> findByWords();

	/**
	 * 	查询所有回复信息
	 */
	List<Reply> findByReply();
}
