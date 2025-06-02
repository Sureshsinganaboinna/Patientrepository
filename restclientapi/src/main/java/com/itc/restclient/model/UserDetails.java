package com.itc.restclient.model;


public class UserDetails {
	
	
	private int id;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private String username;
	private String email;
	private String mobile;
	private String pincode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", username=" + username + ", email=" + email + ", mobile=" + mobile
				+ ", pincode=" + pincode + "]";
	}
	
			

}
