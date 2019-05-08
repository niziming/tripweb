package cn.zm.trip.web.service.impl;

import cn.zm.trip.web.dao.ViewPointDao;
import cn.zm.trip.web.domain.ViewPoint;
import cn.zm.trip.web.service.ViewPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewPointServiceImpl implements ViewPointService {
	@Autowired
	private ViewPointDao viewPointDao;
	@Override
	public ViewPoint selectByPrimaryKey(Integer tpVid) {
		ViewPoint viewPoint = viewPointDao.selectByPrimaryKey(tpVid);
		return viewPoint;
	}
}
