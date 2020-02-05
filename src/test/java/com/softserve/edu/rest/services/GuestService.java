package com.softserve.edu.rest.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softserve.edu.rest.data.Lifetime;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.dto.LoginedUser;
import com.softserve.edu.rest.dto.RestParameters;
import com.softserve.edu.rest.entity.SimpleEntity;
import com.softserve.edu.rest.resources.ApplicationResource;
import com.softserve.edu.rest.resources.LoginResource;
import com.softserve.edu.rest.resources.TokenlifetimeResource;

import io.qameta.allure.Step;

public class GuestService {
	public static final Logger logger = LoggerFactory.getLogger(GuestService.class); // org.slf4j.LoggerFactory

	protected LoginResource loginResource;
	protected TokenlifetimeResource tokenlifetimeResource;
//	protected CooldownResource cooldownResource;
	private ApplicationResource applicationResource;

	public GuestService() {
		loginResource = new LoginResource();
		tokenlifetimeResource = new TokenlifetimeResource();
//		cooldownResource = new CooldownResource();
		applicationResource = new ApplicationResource();
	}

//	public GuestService(LoginResource loginResource, TokenlifetimeResource tokenlifetimeResource) {
//		this.loginResource = loginResource;
//		this.tokenlifetimeResource = tokenlifetimeResource;
//	}

	protected void checkEntity(SimpleEntity simpleEntity,
			String wrongMessage, String errorMessage) {
		// if (!simpleEntity.getContent().toLowerCase().equals("true"))
		if ((simpleEntity.getContent() == null)
				|| (simpleEntity.getContent().isEmpty())
				|| (simpleEntity.getContent().toLowerCase()
						.equals(wrongMessage.toLowerCase()))) {
			// TODO Develop Custom Exception
			throw new RuntimeException(errorMessage);
		}
	}

	@Step("Reset_Service_To_Initial_State")
	public GuestService resetServiceToInitialState() {
		SimpleEntity simpleEntity = applicationResource.httpPutAsEntity(null, null, null);
		checkEntity(simpleEntity, "false", "Error Reset Server");
		return this;
	}

	//	public boolean isUserLockedAfterTryToLogin(User user) {
//		RestParameters bodyParameters = new RestParameters().addParameter("name", user.getName())
//				.addParameter("password", user.getPassword());
//		SimpleEntity simpleEntity = loginResource.httpPostAsEntity(null, null, bodyParameters);
//		checkEntity(simpleEntity, "Error Login");
//		return simpleEntity.getContent().equals("ERROR, user locked");
//	}

	public Lifetime getCurrentLifetime() {
		SimpleEntity simpleEntity = tokenlifetimeResource.httpGetAsEntity(null, null);
		return new Lifetime(simpleEntity.getContent());
	}

	// Check Error
	public void updateLifetime() {
		tokenlifetimeResource.httpPostAsEntity(null, null, null);
	}
	
	// Check Error
	public GuestService updateCurrentLifetime() {
		logger.debug("updateCurrentLifetime START");
		RestParameters bodyParameters = new RestParameters()
				.addParameter("token", "111111111111111")
				.addParameter("time", new Lifetime("111111").getTimeAsText());
		SimpleEntity simpleEntity = tokenlifetimeResource.httpPutAsEntity(null, null, bodyParameters);
		checkEntity(simpleEntity, "false", "Error Change Current Lifetime");
		logger.debug("updateCurrentLifetime DONE");
		return this;
	}
	
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
		checkEntity(simpleEntity, "ERROR, user not found", "Error Login");
		//logger.debug("successfulUserLogin DONE, user = " + user);
		return new UserService(new LoginedUser(user, simpleEntity.getContent()));
	}

	@Step("Successful_Admin_Login")
	public AdminService successfulAdminLogin(User adminUser) {
		RestParameters bodyParameters = new RestParameters()
				.addParameter("name", adminUser.getName())
				.addParameter("password", adminUser.getPassword());
		SimpleEntity adminContent = loginResource.httpPostAsEntity(null, null, bodyParameters);
		checkEntity(adminContent, "ERROR, user not found", "Error Login");
		return new AdminService(new LoginedUser(adminUser, adminContent.getContent()));
	}

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
