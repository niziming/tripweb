package cn.zm.trip.web.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;
@Component
public class Admin implements Serializable {
	private Long aid;
	private String aname;
	private String aemail;
	private String apwd;

	public Admin(String aemail, String apwd) {
		this.aemail = aemail;
		this.apwd = apwd;
	}

	public Admin() {
	}

	public Long getAid() {
		return aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getAemail() {
		return aemail;
	}

	public void setAemail(String aemail) {
		this.aemail = aemail;
	}

	public String getApwd() {
		return apwd;
	}

	public void setApwd(String apwd) {
		this.apwd = apwd;
	}

	@Override
	public String toString() {
		return "Admin{" +
				"aid=" + aid +
				", aname='" + aname + '\'' +
				", aemail='" + aemail + '\'' +
				", apwd='" + apwd + '\'' +
				'}';
	}
}
