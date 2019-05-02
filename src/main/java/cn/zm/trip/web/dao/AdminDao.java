package cn.zm.trip.web.dao;

import cn.zm.trip.web.domain.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDao {
	/**
	 *
	 * @param admin
	 * @return
	 */
	Admin selectAdmin(Admin admin);


	List<Admin> selectAll();
}
