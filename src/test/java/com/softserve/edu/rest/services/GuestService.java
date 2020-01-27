package com.softserve.edu.rest.services;

import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.dto.RestParameters;
import com.softserve.edu.rest.entity.SimpleEntity;
import com.softserve.edu.rest.resources.LoginResource;

public class GuestService {
	//public static final Logger logger = LoggerFactory.getLogger(LoginLogoutTest.class); // org.slf4j.LoggerFactory

	protected LoginResource loginResource;
//	protected TokenlifetimeResource tokenlifetimeResource;
//	protected CooldownResource cooldownResource;
//	private ResetApiResource resetApiResource;

	public GuestService() {
		loginResource = new LoginResource();
//		tokenlifetimeResource = new TokenlifetimeResource();
//		cooldownResource = new CooldownResource();
//		resetApiResource = new ResetApiResource();
	}

//	public GuestService(LoginResource loginResource, TokenlifetimeResource tokenlifetimeResource) {
//		this.loginResource = loginResource;
//		this.tokenlifetimeResource = tokenlifetimeResource;
//	}

//	public void resetServiceToInitialState() {
//		resetApiResource.httpGetAsEntity(null, null);
//	}

	protected void checkEntity(SimpleEntity simpleEntity, String message) {
		// if (!simpleEntity.getContent().toLowerCase().equals("true"))
		if ((simpleEntity.getContent() == null) || (simpleEntity.getContent().isEmpty())
				|| (simpleEntity.getContent().toLowerCase().equals("false"))) {
			// TODO Develop Custom Exception
			throw new RuntimeException(message);
		}
	}

//	public boolean isUserLockedAfterTryToLogin(User user) {
//		RestParameters bodyParameters = new RestParameters().addParameter("name", user.getName())
//				.addParameter("password", user.getPassword());
//		SimpleEntity simpleEntity = loginResource.httpPostAsEntity(null, null, bodyParameters);
//		checkEntity(simpleEntity, "Error Login");
//		return simpleEntity.getContent().equals("ERROR, user locked");
//	}

//	public Lifetime getCurrentLifetime() {
//		SimpleEntity simpleEntity = tokenlifetimeResource.httpGetAsEntity(null, null);
//		return new Lifetime(simpleEntity.getContent());
//	}

//	public Cooldown getCurrentCooldown() {
//		SimpleEntity simpleEntity = cooldownResource.httpGetAsEntity(null, null);
//		return new Cooldown(simpleEntity.getContent());
//	}

	// TODO
//    public void UnsuccessfulUserLogin(IUser user)
//    {
//    }
//

	public UserService successfulUserLogin(User user) {
		//logger.debug("successfulUserLogin START, user = " + user);
		RestParameters bodyParameters = new RestParameters()
				.addParameter("name", user.getName())
				.addParameter("password", user.getPassword());
		SimpleEntity simpleEntity = loginResource.httpPostAsEntity(null, null, bodyParameters);
		//logger.trace("successfulUserLogin TRACE, simpleEntity = " + simpleEntity);
//		checkEntity(simpleEntity, "Error Login");
		user.setToken(simpleEntity.getContent());
		//logger.debug("successfulUserLogin DONE, user = " + user);
		return new UserService(user);
	}

//	public AdminService SuccessfulAdminLogin(User adminUser) {
//		RestParameters bodyParameters = new RestParameters().addParameter("name", adminUser.getName())
//				.addParameter("password", adminUser.getPassword());
//		SimpleEntity simpleEntity = loginResource.httpPostAsEntity(null, null, bodyParameters);
//		checkEntity(simpleEntity, "Error Login");
//		adminUser.setToken(simpleEntity.getContent());
//		return new AdminService(adminUser);
//	}

//	public AdminService ChangeCurrentPassword(User adminUser) {
//		String pass = "1111";
//		RestParameters bodyParameters = new RestParameters().addParameter("token", adminUser.getToken())
//				.addParameter("oldpassword", adminUser.getPassword()).addParameter("newpassword", pass);
//		SimpleEntity simpleEntity = loginResource.httpPostAsEntity(null, null, bodyParameters);
//		checkEntity(simpleEntity, "Error Login");
//		adminUser.setToken(simpleEntity.getContent());
//		return new AdminService(adminUser);
//	}

}
