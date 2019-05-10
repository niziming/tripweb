package cn.zm.trip.web.service;

import cn.zm.trip.web.domain.ViewPoint;
import cn.zm.trip.web.domain.ViewPointExample;

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
}
