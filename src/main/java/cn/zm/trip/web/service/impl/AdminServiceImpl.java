package cn.zm.trip.web.service.impl;

import cn.zm.trip.web.dao.AdminDao;
import cn.zm.trip.web.domain.Admin;
import cn.zm.trip.web.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;

	@Override
	public Admin login(String email, String pwd) {
		Admin admin = adminDao.selectAdmin(new Admin(email, pwd));
		return admin;
	}

	@Override
	public List<Admin> selectAll() {
		List<Admin> admins = adminDao.selectAll();
		return admins;
	}

}
