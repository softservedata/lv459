package com.softserve.edu.rest.services;

import com.softserve.edu.rest.dto.LoginedUser;
import com.softserve.edu.rest.dto.RestParameters;
import com.softserve.edu.rest.entity.SimpleEntity;

public class UserService extends GuestService {

	protected LoginedUser loginedUser;

	public UserService(LoginedUser loginedUser) {
		// super();
		this.loginedUser = loginedUser;
	}

	public GuestService logout() {
		RestParameters bodyParameters = new RestParameters()
				.addParameter("name", loginedUser.getUser().getName())
				.addParameter("token", loginedUser.getToken());
		SimpleEntity simpleEntity = loginResource
				.httpDeleteAsEntity(null, null, bodyParameters);
		checkEntity(simpleEntity, "false", "Error Logout");
		return new GuestService();
	}

	public String  getToken (){
		return loginedUser.getToken();
	}



	//Dana code
	//change password
	public UserService changePassword(LoginedUser loginedUser) {
		String newPassword = "qwerty5";
		RestParameters bodyParameters = new RestParameters()
				.addParameter("token", loginedUser.getToken())
				.addParameter("oldpassword", loginedUser.getUser().getPassword())
				.addParameter("newpassword", newPassword);
		SimpleEntity simpleEntity = loginResource
				.httpPutAsEntity(null, null, bodyParameters);
		checkEntity(simpleEntity, "false", "Error change password");
		return new UserService(loginedUser);
	}
}

