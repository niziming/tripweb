package cn.zm.trip.web.service.impl;

import cn.zm.trip.web.dao.ViewPointDao;
import cn.zm.trip.web.domain.Reply;
import cn.zm.trip.web.domain.ViewPoint;
import cn.zm.trip.web.domain.ViewPointExample;
import cn.zm.trip.web.domain.Words;
import cn.zm.trip.web.service.ViewPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewPointServiceImpl implements ViewPointService {
	@Autowired
	private ViewPointDao viewPointDao;

	@Override
	public ViewPoint selectByPrimaryKey(Integer tpVid) {
		ViewPoint viewPoint = viewPointDao.selectByPrimaryKey(tpVid);
		return viewPoint;
	}

	@Override
	public List<ViewPoint> selectByExample(ViewPointExample example) {
		List<ViewPoint> viewPoints = viewPointDao.selectByExample(example);
		return viewPoints;
	}

	@Override
	public void insertView(ViewPoint viewPoint) {
		viewPointDao.insertSelective(viewPoint);
	}

	@Override
	public void deleteviews(Integer tpVid) {
		viewPointDao.deleteByPrimaryKey(tpVid);
	}

	@Override
	public void updateByPrimaryKeySelective(ViewPoint viewPoint) {
		viewPointDao.updateByPrimaryKeySelective(viewPoint);
	}
	/**
	 * 保存留言信息功能
	 * @param words
	 * @return
	 */
	@Override
	public void saveWords(Words words) {
		viewPointDao.saveWords(words);
	}
	/**
	 * 保存回复信息
	 * @param reply
	 */
	@Override
	public void saveReply(Reply reply) {
		viewPointDao.saveReply(reply);
	}
	/**
	 * 查询所有留言信息
	 * @return
	 */
	@Override
	public List<Words> findByWords() {
		return viewPointDao.findByWords();
	}
	/**
	 * 	查询所有回复信息
	 */
	@Override
	public List<Reply> findByReply() {
		return viewPointDao.findByReply();
	}
}
