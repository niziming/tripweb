package cn.zm.trip.web.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class User implements Serializable {
	private String uid;
	private String uname;
	private String uemail;
	private String upwd;
	private String age;
	private String gender;
	private String upic;
	private String phone;
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
		this.regDate = new Date();
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

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
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

	public String getUpic() {
		return upic;
	}

	public void setUpic(String upic) {
		this.upic = upic;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
				", upwd='" + upwd + '\'' +
				", age='" + age + '\'' +
				", gender='" + gender + '\'' +
				", upic='" + upic + '\'' +
				", phone='" + phone + '\'' +
				", regDate=" + regDate +
				", updateTime=" + updateTime +
				'}';
	}
}
