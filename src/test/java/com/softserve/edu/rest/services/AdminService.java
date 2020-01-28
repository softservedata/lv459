package com.softserve.edu.rest.services;

import com.softserve.edu.rest.dto.LoginedUser;

public class AdminService extends UserService {

	public AdminService(LoginedUser loginedUser) {
		super(loginedUser);
	}
	
}
