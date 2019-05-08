package cn.zm.trip.web.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	private String uid;
	private String uname;
	private String uemail;
	private String age;
	private String gender;
	private String phone;
	private String upwd;
	private Date regDate;
	private Date updateTime;

	public User(String uname, String uemail, String upwd) {
		this.uname = uname;
		this.uemail = uemail;
		this.upwd = upwd;
		this.regDate = new Date();
		this.updateTime = new Date();
	}

	public User(String uemail, String upwd) {
		this.uemail = uemail;
		this.upwd = upwd;
		this.regDate = new Date();
		this.updateTime = new Date();
	}

	public User() {
		this.updateTime = new Date();
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public Date getRegDate() {
		return regDate;
	}


	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "User{" +
				"uid='" + uid + '\'' +
				", uname='" + uname + '\'' +
				", uemail='" + uemail + '\'' +
				", age='" + age + '\'' +
				", phone='" + phone + '\'' +
				", gender='" + gender + '\'' +
				", upwd='" + upwd + '\'' +
				", regDate=" + regDate +
				", updateTime=" + updateTime +
				'}';
	}
}
