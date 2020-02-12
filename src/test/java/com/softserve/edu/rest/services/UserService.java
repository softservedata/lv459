package com.softserve.edu.rest.services;

import com.softserve.edu.rest.data.Item;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.dto.LoginedUser;
import com.softserve.edu.rest.dto.RestParameters;
import com.softserve.edu.rest.entity.SimpleEntity;
import com.softserve.edu.rest.resources.ItemIndexResource;
import com.softserve.edu.rest.resources.UserDBResource;
import io.qameta.allure.Step;

public class UserService extends GuestService {

    protected LoginedUser loginedUser;
    protected ItemIndexResource itemByIndexResource;
    protected UserDBResource userDBResource;

    public UserService(LoginedUser loginedUser) {
        // super();
        this.loginedUser = loginedUser;
        itemByIndexResource = new ItemIndexResource();
        userDBResource = new UserDBResource();

    }

    @Step("Log out")
    public GuestService logout() {
        logger.info("logout START");
        RestParameters bodyParameters = new RestParameters()
                .addParameter("name", loginedUser.getUser().getName())
                .addParameter("token", loginedUser.getToken());
        SimpleEntity simpleEntity = loginResource
                .httpDeleteAsEntity(null, null, bodyParameters);
        checkEntity(simpleEntity, "false", "Error Logout");
        logger.info("logout END");
        return new GuestService();
    }

    @Step("Get Token")
    public String getToken() {
        return loginedUser.getToken();
    }

    @Step ("Get user's item by index")
    public String getItemByIndex(Item item) {
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", getToken());
        RestParameters pathVariables = new RestParameters()
                .addParameter("index", item.getItemIndex());

        SimpleEntity simpleEntity = itemByIndexResource
                .httpGetAsEntity(pathVariables,bodyParameters);
        logger.info("Answer from server on GET one item: " + simpleEntity.toString());

        return simpleEntity.getContent();
    }

    @Step("Add user's item by index")
    public UserService postNewItemByIndex(Item item) {
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", getToken())
                .addParameter("item", item.getItemText());

        RestParameters pathVariables = new RestParameters()
                .addParameter("index", item.getItemIndex());

        SimpleEntity simpleEntity = itemByIndexResource
                .httpPostAsEntity(pathVariables , null , bodyParameters);
        logger.info("Answer from server on POST one item: " + simpleEntity.toString());
        return this;
    }

    @Step("Overwrite user's item by index(POST)")
    public UserService postOverwriteItemByIndex(Item initialItem, Item overwtriteItem) {

        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", getToken())
                .addParameter("item", overwtriteItem.getItemText());

        RestParameters pathVariables = new RestParameters()
                .addParameter("index", initialItem.getItemIndex());

        SimpleEntity simpleEntity = itemByIndexResource
                .httpPostAsEntity(pathVariables , null , bodyParameters);
        logger.info("Answer from server on POST one item: " + simpleEntity.toString());
        return this;
    }

    @Step("Overwrite user's item by index(PUT)")
    public UserService putOverwriteItemByIndex(Item initialItem, Item overwtriteItem) {

        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", getToken())
                .addParameter("item", overwtriteItem.getItemText());

        RestParameters pathVariables = new RestParameters()
                .addParameter("index", initialItem.getItemIndex());

        SimpleEntity simpleEntity = itemByIndexResource
                .httpPutAsEntity(pathVariables , null , bodyParameters);
        logger.info("Answer from server on PUT one item: " + simpleEntity.toString());
        return this;
    }

    @Step("Delete item by index")
    public UserService deleteItemByIndex(Item item) {

        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", getToken());

        RestParameters pathVariables = new RestParameters()
                .addParameter("index", item.getItemIndex());

        SimpleEntity simpleEntity = itemByIndexResource
                .httpDeleteAsEntity(pathVariables , bodyParameters, null);
        logger.info("Answer from server on DELETE one item: " + simpleEntity.toString());
        return this;
    }

    public UserService getAllItems() {
        RestParameters urlParameters = new RestParameters()
                .addParameter("token", loginedUser.getToken());
        SimpleEntity simpleEntity = itemsResource
                .httpGetAsEntity(null, urlParameters);
        System.out.println(simpleEntity);
        //checkEntity(simpleEntity, "false", "Error get all items");
        return this;
    }


    public String getUserItemByIndex(Item item) {
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", getToken());
        RestParameters pathVariables = new RestParameters()
                .addParameter("index", item.getItemIndex());

        SimpleEntity simpleEntity = itemByIndexResource.httpGetAsEntity(pathVariables, bodyParameters);

        return simpleEntity.getContent();
    }

    public UserService addItem(Item newItem) {
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", loginedUser.getToken())
                .addParameter("item", newItem.getItemText());
        RestParameters pathVariables = new RestParameters()
                .addParameter("index", newItem.getItemIndex());
        SimpleEntity simpleEntity = itemByIndexResource.httpPostAsEntity(pathVariables, null, bodyParameters);
        System.out.println(simpleEntity);
        checkEntity(simpleEntity, "false", "Error add item");
        return this;
    }

    public UserService updateItem(Item oldItem, Item newItem ) {
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", loginedUser.getToken())
                .addParameter("item", newItem.getItemText());
        RestParameters pathVariables = new RestParameters()
                .addParameter("index", oldItem.getItemIndex());
        SimpleEntity simpleEntity = itemByIndexResource.httpPutAsEntity(pathVariables, null, bodyParameters);
        System.out.println(simpleEntity);
        checkEntity(simpleEntity, "false", "Error update item");
        return this;
    }

    public UserService deleteItem(Item item) {
        RestParameters urlParameters = new RestParameters()
                .addParameter("token", loginedUser.getToken());
        RestParameters pathVariables = new RestParameters()
                .addParameter("index", item.getItemIndex());
        SimpleEntity simpleEntity = itemByIndexResource.httpDeleteAsEntity(pathVariables, urlParameters, null);
        System.out.println(simpleEntity);
        checkEntity(simpleEntity, "false", "Error delete item");
        return this;
    }


    //Dana code
    //change user password
    @Step("Change password")
    public UserService changePassword(User existUser) {
      //  logger.debug("change password START");
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", loginedUser.getToken())
                .addParameter("oldpassword", existUser.getPassword())
                .addParameter("newpassword", "qwerty5");
        SimpleEntity simpleEntity = userResource.httpPutAsEntity(null,  bodyParameters,  null);
        checkEntity(simpleEntity, "false", "Error change password");
      //  logger.debug("change password DONE");
        return this;
    }

    //is user created
    @Step("Check if user is created")
    public boolean isUserCreated(User user) {
        RestParameters urlParameters = new RestParameters()
                .addParameter("token", loginedUser.getToken());
        SimpleEntity simpleEntity = userResource.httpGetAsEntity(null, urlParameters);
        return simpleEntity.getContent().contains(user.getName());
    }

    //is user removed
    @Step("Check if user is removed from DB")
    public boolean isUserRemoved(User user) {
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", loginedUser.getToken());
        SimpleEntity simpleEntity = userResource.httpGetAsEntity(null, bodyParameters);
        return !simpleEntity.getContent().contains(user.getName());
    }
}