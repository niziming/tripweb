package cn.zm.trip.web.service;

import cn.zm.trip.web.domain.Admin;

import java.util.List;

public interface AdminService {
	Admin login(String eamil, String pwd);

	List<Admin> selectAll();
}
