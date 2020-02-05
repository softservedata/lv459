package com.softserve.edu.rest.services;

import com.softserve.edu.rest.data.Lifetime;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.dto.LoginedUser;
import com.softserve.edu.rest.dto.RestParameters;
import com.softserve.edu.rest.entity.SimpleEntity;
import com.softserve.edu.rest.tools.RegexUtils;
import io.qameta.allure.Step;

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

    @Step("Change Token LifeTime")
    public AdminService changeCurrentLifetime(Lifetime lifetime) {
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", loginedUser.getToken())
                .addParameter("time", lifetime.getTimeAsText());
        SimpleEntity simpleEntity = tokenlifetimeResource.httpPutAsEntity(null, null, bodyParameters);
        checkEntity(simpleEntity, "false", "Error Change Current Lifetime");
        return this;
    }

    @Step("Get all logged users")
    public String getAllLoggedUsers() {
        RestParameters urlParameters = new RestParameters()
                .addParameter("token", loginedUser.getToken());
        SimpleEntity simpleEntity = loginUserResource
                .httpGetAsEntity(null, urlParameters);
        return simpleEntity.getContent();
    }

    @Step("Check if user is logged")
    public boolean isUserLogged(User user) {

        if (getAllLoggedUsers().contains(user.getName())) {
            return true;
        } else {
            return false;
        }
    }

    //Lock user
    @Step("Lock user")
    public AdminService lockUser(User userToLock) {
        logger.debug("Locked user START");
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", loginedUser.getToken());
        RestParameters pathParameters = new RestParameters()
                .addParameter("name", userToLock.getName());
        SimpleEntity simpleEntity = lockUserResource
                .httpPostAsEntity(pathParameters, null, bodyParameters);
        checkLockEntity(simpleEntity, "User was not locked");
        logger.debug("Locked user DONE");
        return this;
    }

    //Unlock user
    @Step("Unlock user")
    public AdminService unlockUser(User user) {
        logger.debug("Locked user START");
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", loginedUser.getToken());
        RestParameters pathParameters = new RestParameters()
                .addParameter("", user.getName());
        SimpleEntity simpleEntity = lockUserResource
                .httpPutAsEntity(pathParameters, null, bodyParameters);
        checkLockEntity(simpleEntity, "User was not unlocked");
        logger.debug("Locked user DONE");
        return this;
    }

    //Get all locked users
    @Step("Get all locked users")
    public String getAllLockedUsers() {
        logger.debug("get all locked users START");
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", loginedUser.getToken());
        SimpleEntity simpleEntity = lockUsersResource
                .httpGetAsEntity(null, bodyParameters);
        logger.debug("get all locked users DONE");
        return simpleEntity.getContent();
    }

    //Check is the user locked
    @Step("Check if user is locked")
    public boolean isUserLocked(User userToLock) {

        if (getAllLockedUsers().contains(userToLock.getName())) {
            return true;
        } else {
            return false;
        }
    }


    /*public AdminService createNewAdmin(User adminUser) {
        RestParameters bodyParameters = new RestParameters().addParameter("token", loginedUser.getToken())
                .addParameter("name", adminUser.getName()).addParameter("password", adminUser.getPassword())
                .addParameter("rights", "true");
        SimpleEntity simpleEntity = userDBResource.httpPostAsEntity(null, null, bodyParameters);
        System.out.println("*******" + simpleEntity);
        checkEntity(simpleEntity, "false", "Error Change Current Lifetime");
        return this;
    }
*/

    // Dana code
    // create user
    @Step("Create new user")
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
    @Step("Delete user")
    public AdminService removeUser(User existUser) {
        logger.debug("removing  user START");
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", loginedUser.getToken())
                .addParameter("name", existUser.getName());
        SimpleEntity simpleEntity = userResource.httpDeleteAsEntity(null, bodyParameters, null);// bug of application
        System.out.println(simpleEntity);
        checkEntity(simpleEntity, "false", "Error delete user");
        logger.debug("removing user DONE");
        return this;
    }

    //Dana code
    // get all users
    @Step("Get all users")
    public AdminService getAllUsers() {
        logger.debug("get all user START");
        RestParameters bodyParameters = new RestParameters().addParameter("token", loginedUser.getToken());
        SimpleEntity simpleEntity = userResource.httpGetAsEntity(null, bodyParameters);
        System.out.println(simpleEntity);
        checkEntity(simpleEntity, "false", "Error get all users");
        logger.debug("get all user DONE");
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

    @Override
    public String toString() {
        return loginedUser + "";
    }
}
