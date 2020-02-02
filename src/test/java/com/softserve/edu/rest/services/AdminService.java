package com.softserve.edu.rest.services;

import com.softserve.edu.rest.data.Lifetime;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.dto.LoginedUser;
import com.softserve.edu.rest.dto.RestParameters;
import com.softserve.edu.rest.entity.SimpleEntity;
import com.softserve.edu.rest.resources.TokenlifetimeResource;
import com.softserve.edu.rest.tools.RegexUtils;

public class AdminService extends UserService {

	public AdminService(LoginedUser loginedUser) {
		super(loginedUser);
		check();
		System.out.println(loginResource.toString());
	}
	
	private void check() {
		RestParameters urlParameters = new RestParameters()
				.addParameter("token", loginedUser.getToken());
		SimpleEntity loginedAdmins = loginResource.httpGetLoginedAdmins(null, urlParameters);
		System.out.println("loginedAdmins: " + loginedAdmins);
		if (!RegexUtils.isTextContains("admin", loginedAdmins.getContent())) {
			// TODO Develop Custom Exception
            throw new RuntimeException("Error Admin Login. Response: " + loginedAdmins.getContent());
		}
	}
	
	public AdminService changeCurrentLifetime(Lifetime lifetime) {
		RestParameters bodyParameters = new RestParameters()
				.addParameter("token", loginedUser.getToken())
				.addParameter("time", lifetime.getTimeAsText());
		SimpleEntity simpleEntity = tokenlifetimeResource.httpPutAsEntity(null, null, bodyParameters);
		checkEntity(simpleEntity, "false", "Error Change Current Lifetime");
		return this;
	}


	//Dana code
	//create user
	public AdminService createUser( ) {
		logger.debug("creation of user START");
		RestParameters bodyParameters = new RestParameters()
				.addParameter("token", loginedUser.getToken())
				.addParameter("name", "Dana")
				.addParameter("password","qwerty")
				.addParameter("rights", "false");
		SimpleEntity simpleEntity = loginResource.httpPostAsEntity(null, null, bodyParameters);
		System.out.println(simpleEntity);
		checkEntity(simpleEntity, "false", "Error create user");
		logger.debug("creation of user DONE");
		return this;
	}

	//delete user
	public AdminService deleteUser() {
		RestParameters bodyParameters = new RestParameters()
				.addParameter("token", loginedUser.getToken())
				.addParameter("name", "Dana");
		SimpleEntity simpleEntity = loginResource.httpDeleteAsEntity(null, null, bodyParameters);
		System.out.println(simpleEntity);
		checkEntity(simpleEntity, "false", "Error delete user");
		return this;
	}

	//get all users

	//change user password

}
