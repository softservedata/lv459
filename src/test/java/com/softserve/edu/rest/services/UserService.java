package com.softserve.edu.rest.services;

import com.softserve.edu.rest.data.Item;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.dto.LoginedUser;
import com.softserve.edu.rest.dto.RestParameters;
import com.softserve.edu.rest.entity.SimpleEntity;
import com.softserve.edu.rest.resources.ItemIndexResource;
import com.softserve.edu.rest.resources.UserDBResource;

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

    public GuestService logout() {
        RestParameters bodyParameters = new RestParameters()
                .addParameter("name", loginedUser.getUser().getName())
                .addParameter("token", loginedUser.getToken());
        SimpleEntity simpleEntity = loginResource
                .httpDeleteAsEntity(null, null, bodyParameters);
        checkEntity(simpleEntity, "false", "Error Logout");
        return new GuestService();
    }

    public String getToken() {
        return loginedUser.getToken();
    }

    //GET item (token + index) 	.addText("URL=/item/{index}, method=GET
    // getItem, PARAMETERS= token, index");
    public String getItemByIndex(Item item) {
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", getToken());
        RestParameters pathVariables = new RestParameters()
                .addParameter("index", item.getItemIndex());

        SimpleEntity simpleEntity = itemByIndexResource
                .httpGetAsEntity(
                        pathVariables,
                                 bodyParameters);
        logger.info("Answer from server on GET one item: " + simpleEntity.toString());

        return simpleEntity.getContent();
    }

    //POST  .addText("URL=/item/{index}, method=POST addItem, PARAMETERS=
    // token, item")
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
    //DELETE item .addText("URL=/item/{index}, method=DELETE deleteItem,
    // PARAMETERS= token, index")

    //PUT .addText("URL=/item/{index}, method=PUT updateItem, PARAMETERS=
    // token, index, item")




    //Dana code
    //change user password
    public UserService changePassword(User existUser) {
        logger.debug("change password START");
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", loginedUser.getToken())
                .addParameter("oldpassword", existUser.getPassword())
                .addParameter("newpassword", String.valueOf(existUser.setPassword("qwerty5")));
        SimpleEntity simpleEntity = userResource.httpPutAsEntity(null,null,  bodyParameters);
        System.out.println(simpleEntity);
        checkEntity(simpleEntity, "false", "Error change password");
        logger.debug("change password DONE");
        return this;
    }

    //is user created
    public boolean isUserCreated(User user) {
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", loginedUser.getToken());
        SimpleEntity simpleEntity = userResource.httpGetAsEntity(null, bodyParameters);
        return simpleEntity.getContent().contains(user.getName());
    }

    //is user removed
    public boolean isUserRemoved(User user) {
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", loginedUser.getToken());
        SimpleEntity simpleEntity = userResource.httpGetAsEntity(null, bodyParameters);
        return !simpleEntity.getContent().contains(user.getName());
    }
}