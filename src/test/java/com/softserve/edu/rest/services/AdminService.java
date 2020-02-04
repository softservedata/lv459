package com.softserve.edu.rest.services;

import com.softserve.edu.rest.data.Lifetime;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.dto.LoginedUser;
import com.softserve.edu.rest.dto.RestParameters;
import com.softserve.edu.rest.entity.SimpleEntity;
import com.softserve.edu.rest.tools.RegexUtils;

public class AdminService extends UserService {

    public AdminService(LoginedUser loginedUser) {
        super(loginedUser);
        check();
        System.out.println(loginResource.toString());
    }

    private void check() {
        RestParameters urlParameters = new RestParameters().addParameter("token", loginedUser.getToken());
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
    
    public String getAllLoggedUsers() {
        RestParameters urlParameters = new RestParameters()
                .addParameter("token", loginedUser.getToken());
        SimpleEntity simpleEntity = loginUserResource.httpGetAsEntity(null, urlParameters);
        return simpleEntity.getContent();
    }
    public boolean isUserLogged(User user) {

        if (getAllLoggedUsers().contains(user.getName())) {
            return true;
        } else {
            return false;
        }
    }

    // create user
    public AdminService createUser2() {
        RestParameters bodyParameters = new RestParameters().addParameter("token", loginedUser.getToken())
                .addParameter("name", "Vasya").addParameter("password", "qwerty").addParameter("rights", "false");
        SimpleEntity simpleEntity = loginResource.httpPostAsEntity(null, null, bodyParameters);
        System.out.println(simpleEntity);
        checkEntity(simpleEntity, "false", "Error create user");
        return this;
    }

    // Dana code
    // create user
    public AdminService createUser() {
        logger.debug("creation of user START");
        RestParameters bodyParameters = new RestParameters().addParameter("token", loginedUser.getToken())
                .addParameter("name", "Dana").addParameter("password", "qwerty").addParameter("rights", "false");
        return this;
    }
    public AdminService createNewAdmin(User adminUser) {
        RestParameters bodyParameters = new RestParameters().addParameter("token", loginedUser.getToken())
                .addParameter("name", adminUser.getName()).addParameter("password", adminUser.getPassword())
                .addParameter("rights", "true");
        SimpleEntity simpleEntity = userDBResource.httpPostAsEntity(null, null, bodyParameters);
        System.out.println("*******" + simpleEntity);
        checkEntity(simpleEntity, "false", "Error Change Current Lifetime");
        return this;

    }

    // alessandro
//	public String getAllLoggedUsers() {
//		RestParameters urlParameters = new RestParameters()
//				.addParameter("token", loginedUser.getToken());
//		SimpleEntity simpleEntity = loginUserResource.httpGetAsEntity(null, urlParameters);
//		return simpleEntity.getContent();
//	}
//
//	public boolean isUserLogged(User user) {
//
//		if (getAllLoggedUsers().contains(user.getName())) {
//			return true;
//		} else {
//			return false;
//		}
//	}

    // Dana code
    // create user
    public AdminService createUser(User newUser) {
        logger.debug("creation of user START");
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", loginedUser.getToken())
                .addParameter("name", newUser.getName())
                .addParameter("password", newUser.getPassword())
                .addParameter("rights", String.valueOf(newUser.isAdmin()));
        SimpleEntity simpleEntity = userResource.httpPostAsEntity(null, null, bodyParameters);
        System.out.println(simpleEntity);
        checkEntity(simpleEntity, "false", "Error create user");
        logger.debug("creation of user DONE");
        return this;
    }

    // delete user
    public AdminService deleteUser() {
        RestParameters bodyParameters = new RestParameters().addParameter("token", loginedUser.getToken())
                .addParameter("name", "Dana");
        SimpleEntity simpleEntity = loginResource.httpDeleteAsEntity(null, null, bodyParameters);
        System.out.println(simpleEntity);
        checkEntity(simpleEntity, "false", "Error delete user");
        return this;
    }

    public AdminService waitTokenLifeTime(Lifetime lifetime) {
        try {
            Thread.sleep(lifetime.getTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.debug("Waint token life done");
        return this;
    }

    // get all users

    // change user password
    // Dana code
    // create user
    /*
     * public AdminService createUser( User newUser) {
     * logger.debug("creation of user START"); RestParameters bodyParameters = new
     * RestParameters() .addParameter("token", loginedUser.getToken())
     * .addParameter("name", newUser.getName()) .addParameter("password",
     * newUser.getPassword()) .addParameter("rights",
     * String.valueOf(newUser.isAdmin())); SimpleEntity simpleEntity =
     * userResource.httpPostAsEntity(null, null, bodyParameters);
     * System.out.println(simpleEntity); checkEntity(simpleEntity, "false",
     * "Error create user"); logger.debug("creation of user DONE"); return this; }
     */

    // delete user
    public AdminService removeUser(User existUser) {
        logger.debug("removing  user START");
        RestParameters bodyParameters = new RestParameters().addParameter("token", loginedUser.getToken())
                .addParameter("name", existUser.getName());
        SimpleEntity simpleEntity = userResource.httpDeleteAsEntity(null, bodyParameters, null);// bug of application
        System.out.println(simpleEntity);
        checkEntity(simpleEntity, "false", "Error delete user");
        logger.debug("removing user DONE");
        return this;
    }

    // get all users
    public AdminService getAllUsers() {
        logger.debug("get all user START");
        RestParameters bodyParameters = new RestParameters().addParameter("token", loginedUser.getToken());
        SimpleEntity simpleEntity = userResource.httpGetAsEntity(null, bodyParameters);
        System.out.println(simpleEntity);
        checkEntity(simpleEntity, "false", "Error get all users");
        logger.debug("get all user DONE");
        return this;
    }
    @Override
    public String toString() {
        return loginedUser + "";
    }
}
