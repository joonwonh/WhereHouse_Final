package com.wherehouse.members.model;

import java.sql.Date;
import java.sql.Timestamp;

public class MembersVO {
	
	String id;
	String pw;
	String nickName;	
	String tel;	
	String email;
	Date joinDate;
	
	public void setId(String id) {
		
		this.id = id;
	}
	
	public String getId() {
		
		return id;
	}
	

	public void setPw(String pw) {
		
		this.pw = pw; 
	}
	
	public String getPw() {
		
		return pw;
	}
	

	public void setNickName(String nickName) {
		
		this.nickName = nickName;
	}
	
	public String getNickName() {
		
		return nickName;
	}
	

	public void setTel(String tel) {
		
		this.tel = tel;
	}
	
	public String geTel() {
		
		return tel;
	}
	

	public void setEmail(String email) {
		
		this.email = email;
	}
	
	public String getEmail() {
		
		return email;
	}
	

	public void setJoinDate(Date date) {
		
		this.joinDate = date;
	}
	
	public Date getjoindate() {
		
		return joinDate;
	}
}
