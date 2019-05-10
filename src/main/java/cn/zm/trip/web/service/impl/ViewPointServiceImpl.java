package cn.zm.trip.web.service.impl;

import cn.zm.trip.web.dao.ViewPointDao;
import cn.zm.trip.web.domain.ViewPoint;
import cn.zm.trip.web.domain.ViewPointExample;
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
}
