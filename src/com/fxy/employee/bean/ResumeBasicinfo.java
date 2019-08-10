package com.fxy.employee.bean;

import java.util.Date;

public class ResumeBasicinfo {
	private String realName;
	private String gender;
	private Date birthday;
	private String currentLoc;
	private String residentLoc;
	private String telephone;
	private String email;
	private String jobIntension;
	private String jobExperience;
	private String headshot;
	
	
	public ResumeBasicinfo() {
		super();
	}
	public ResumeBasicinfo(String realName, String gender, Date birthday, String currentLoc, String residentLoc,
			String telephone, String email, String jobIntension, String jobExperience) {
		super();
		this.realName = realName;
		this.gender = gender;
		this.birthday = birthday;
		this.currentLoc = currentLoc;
		this.residentLoc = residentLoc;
		this.telephone = telephone;
		this.email = email;
		this.jobIntension = jobIntension;
		this.jobExperience = jobExperience;
		this.headshot = headshot;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getCurrentLoc() {
		return currentLoc;
	}
	public void setCurrentLoc(String currentLoc) {
		this.currentLoc = currentLoc;
	}
	public String getResidentLoc() {
		return residentLoc;
	}
	public void setResidentLoc(String residentLoc) {
		this.residentLoc = residentLoc;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJobIntension() {
		return jobIntension;
	}
	public void setJobIntension(String jobIntension) {
		this.jobIntension = jobIntension;
	}
	public String getJobExperience() {
		return jobExperience;
	}
	public void setJobExperience(String jobExperience) {
		this.jobExperience = jobExperience;
	}
	public String getHeadshot() {
		return headshot;
	}
	public void setHeadshot(String headshot) {
		this.headshot = headshot;
	}
}
