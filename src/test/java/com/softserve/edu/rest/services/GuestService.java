package com.softserve.edu.rest.services;

import com.softserve.edu.rest.resources.*;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softserve.edu.rest.data.Lifetime;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.dto.LoginedUser;
import com.softserve.edu.rest.dto.RestParameters;
import com.softserve.edu.rest.entity.SimpleEntity;

public class GuestService {
    public static final Logger logger = LoggerFactory.getLogger(GuestService.class); // org.slf4j.LoggerFactory

    protected String userNotFoundMessage = "ERROR, user not found";
    protected LoginResource loginResource;
    protected LoginUserResource loginUserResource;
    protected LoginAdminResource loginAdminResource;
    protected LockUserResource lockUserResource;
    protected LockUsersResource lockUsersResource;
    protected LockAdminsResource lockAdminsResource;
    protected TokenlifetimeResource tokenlifetimeResource;
    protected UserResource userResource;
    protected ItemResource itemResource;
    protected ItemIndexResource itemIndexResource;
    protected CooldownTimeResource cooldownResource;


    //	protected CooldownResource cooldownResource;
    private ApplicationResource applicationResource;


    public GuestService() {
        loginResource = new LoginResource();
        tokenlifetimeResource = new TokenlifetimeResource();
		cooldownResource = new CooldownTimeResource();
        applicationResource = new ApplicationResource();
        loginResource = new LoginResource();
        loginUserResource = new LoginUserResource();
        loginAdminResource = new LoginAdminResource();
        lockUserResource = new LockUserResource();
        lockUsersResource = new LockUsersResource();
        lockAdminsResource = new LockAdminsResource();
        userResource = new UserResource();
        itemResource = new ItemResource();
        itemIndexResource = new ItemIndexResource();
    }

    protected void checkEntity(SimpleEntity simpleEntity,
                               String wrongMessage, String errorMessage) {
        if ((simpleEntity.getContent() == null)
                || (simpleEntity.getContent().isEmpty())
                || (simpleEntity.getContent().toLowerCase()
                .equals(wrongMessage.toLowerCase()))) {
            // TODO Develop Custom Exception
            throw new RuntimeException(errorMessage);
        }
    }

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
        // checkEntity(simpleEntity, "false", "Error Change Current Lifetime");
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", "111111111111111")
                .addParameter("time", new Lifetime("111111").getTimeAsText());
        SimpleEntity simpleEntity = tokenlifetimeResource.httpPutAsEntity(null, null, bodyParameters);
        //checkEntity(simpleEntity, "false", "Error Change Current Lifetime");
        logger.debug("updateCurrentLifetime DONE");
        return this;
    }

    //Check if lock request is success
    protected void checkLockEntity(SimpleEntity simpleEntity, String message) {
        if ((simpleEntity.getContent() == null) || (simpleEntity.getContent().isEmpty())
                || (simpleEntity.getContent().toLowerCase().equals("false"))) {
            logger.error("Throw LockPersonException");
            throw new RuntimeException(message);
        }
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


    //@Step("Logging in as User")
    public UserService successfulUserLogin(User user) {
        logger.debug("SuccessfulUserLogin START, user = " + user);
        RestParameters bodyParameters = new RestParameters()
                .addParameter("name", user.getName())
                .addParameter("password", user.getPassword());
        SimpleEntity simpleEntity = loginResource.httpPostAsEntity(null, null, bodyParameters);
        logger.info("SuccessfulUserLogin TRACE, simpleEntity = " + simpleEntity);
        System.out.println("USER ********** " + user.toString());
        checkEntity(simpleEntity, "ERROR, user not found", "Error Login");
        logger.debug("SuccessfulUserLogin DONE, user = " + user);
        return new UserService(new LoginedUser(user, simpleEntity.getContent()));
    }

    @Step("Logging in as Admin")
    public AdminService successfulAdminLogin(User adminUser) {
        RestParameters bodyParameters = new RestParameters()
                .addParameter("name", adminUser.getName())
                .addParameter("password", adminUser.getPassword());
        SimpleEntity adminContent = loginResource.httpPostAsEntity(null, null, bodyParameters);
        checkEntity(adminContent, "ERROR, user not found", "Error Login");
        return new AdminService(new LoginedUser(adminUser, adminContent.getContent()));
    }

    public GuestService unsuccessfulUserLogin(User user) {
        RestParameters bodyParameters = new RestParameters()
                .addParameter("name", user.getName())
                .addParameter("password", user.getPassword());
        SimpleEntity simpleEntity = loginUserResource.httpPostAsEntity(null, null, bodyParameters);
//        if (simpleEntity.getContent() != userNotFoundMessage)
//            return new UserService(user);
            logger.trace("SuccessfulUserLogin DONE, user = " + user);
        return new GuestService();
    }

    public GuestService unsuccessfulAdminLogin(User adminUser) {
        RestParameters bodyParameters = new RestParameters()
                .addParameter("name", adminUser.getName())
                .addParameter("password", adminUser.getPassword());
        SimpleEntity simpleEntity = loginAdminResource.httpPostAsEntity(null, null, bodyParameters);
//        if (!simpleEntity.getContent().contains(userNotFoundMessage))
//            return new UserService(adminUser);
        return new GuestService();
    }

    public Lifetime getCooldownTime() {
        SimpleEntity simpleEntity = cooldownResource
                .httpGetAsEntity(null, null);
        checkEntity(simpleEntity, "false","Something gets wrong");
        return new Lifetime(simpleEntity.getContent());
    }

}
