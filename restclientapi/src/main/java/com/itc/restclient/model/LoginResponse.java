package com.itc.restclient.model;

public class LoginResponse {
	
	 private String result;
	    private LoginSuccess loginSuccess;

	    // Getters and Setters

	    public static class LoginSuccess {
	        private User userData;

	      

	        public User getUserData() {
	            return userData;
	        }

	        public void setUserData(User userData) {
	            this.userData = userData;
	        }
	    }

	    public String getResult() {
	        return result;
	    }

	    public void setResult(String result) {
	        this.result = result;
	    }

	    public LoginSuccess getLoginSuccess() {
	        return loginSuccess;
	    }

	    public void setLoginSuccess(LoginSuccess loginSuccess) {
	        this.loginSuccess = loginSuccess;
	    }

}
