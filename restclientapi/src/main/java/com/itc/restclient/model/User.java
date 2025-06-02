package com.itc.restclient.model;

import java.time.LocalDateTime;


public class User {
	private int id;
	private String email;
	private String password;
	private String mobile;
	private String name;
	
	private String resetPasswordLink;
	
	private LocalDateTime createdOn;
	private Boolean isActive;
	private Boolean isEmailVerified;
	private String ipAddress;
	
	private String accountNumber;
	
	
	    private Double amount;


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


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getMobile() {
			return mobile;
		}


		public void setMobile(String mobile) {
			this.mobile = mobile;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getResetPasswordLink() {
			return resetPasswordLink;
		}


		public void setResetPasswordLink(String resetPasswordLink) {
			this.resetPasswordLink = resetPasswordLink;
		}


		public LocalDateTime getCreatedOn() {
			return createdOn;
		}


		public void setCreatedOn(LocalDateTime createdOn) {
			this.createdOn = createdOn;
		}


		public Boolean getIsActive() {
			return isActive;
		}


		public void setIsActive(Boolean isActive) {
			this.isActive = isActive;
		}


		public Boolean getIsEmailVerified() {
			return isEmailVerified;
		}


		public void setIsEmailVerified(Boolean isEmailVerified) {
			this.isEmailVerified = isEmailVerified;
		}


		public String getIpAddress() {
			return ipAddress;
		}


		public void setIpAddress(String ipAddress) {
			this.ipAddress = ipAddress;
		}


		public String getAccountNumber() {
			return accountNumber;
		}


		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}


		public Double getAmount() {
			return amount;
		}


		public void setAmount(Double amount) {
			this.amount = amount;
		}


		@Override
		public String toString() {
			return "User [id=" + id + ", email=" + email + ", password=" + password + ", mobile=" + mobile + ", name="
					+ name + ", resetPasswordLink=" + resetPasswordLink + ", createdOn=" + createdOn + ", isActive="
					+ isActive + ", isEmailVerified=" + isEmailVerified + ", ipAddress=" + ipAddress
					+ ", accountNumber=" + accountNumber + ", amount=" + amount + "]";
		}
	    
	    
	    
	

}
