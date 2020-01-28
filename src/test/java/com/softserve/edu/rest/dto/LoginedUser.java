package com.softserve.edu.rest.dto;

import com.softserve.edu.rest.data.User;

public class LoginedUser {

	private User user;
	private String token;
	private long loginTime;
	
	public LoginedUser(User user, String token) {
		this.user = user;
		this.token = token;
		loginTime = System.currentTimeMillis();
	}

	public User getUser() {
		return user;
	}

	public String getToken() {
		return token;
	}

	public long getLoginTime() {
		return loginTime;
	}	

}
