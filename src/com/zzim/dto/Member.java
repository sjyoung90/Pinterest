package com.zzim.dto;

public class Member {
	private String id;
	private String pw;
	private String name;
	private String gender;
	private String b_date;
	
	public Member(){
		
	}
	
	public Member(String id, String pw, String name, String gender,
			String b_date) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.gender = gender;
		this.b_date = b_date;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getB_date() {
		return b_date;
	}
	public void setB_date(String b_date) {
		this.b_date = b_date;
	}

	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pw=" + pw + ", name=" + name
				+ ", gender=" + gender + ", b_date=" + b_date + "]";
	}
	
	
	
	

}
