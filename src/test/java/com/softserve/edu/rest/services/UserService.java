package com.softserve.edu.rest.services;

import com.softserve.edu.rest.data.Item;
import com.softserve.edu.rest.dto.LoginedUser;
import com.softserve.edu.rest.dto.RestParameters;
import com.softserve.edu.rest.entity.SimpleEntity;
import com.softserve.edu.rest.resources.ItemIndexResource;

public class UserService extends GuestService {

    protected LoginedUser loginedUser;
    protected ItemIndexResource itemByIndexResource;

    public UserService(LoginedUser loginedUser) {
        // super();
        this.loginedUser = loginedUser;
        itemByIndexResource = new ItemIndexResource();

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
    public String getItemByIndex(String index) {
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", getToken());
        RestParameters pathVariables = new RestParameters()
                .addParameter(index, index);

        SimpleEntity simpleEntity = itemByIndexResource
                .httpGetAsEntity(
                        pathVariables,
                                 bodyParameters);
        System.out.println("simpleEntity =" + simpleEntity.getContent());
        return simpleEntity.getContent();
    }

    //POST  .addText("URL=/item/{index}, method=POST addItem, PARAMETERS=
    // token, item")
    public UserService postNewItemByIndex(Item item) { // TODO user should be here speretec
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", getToken());

        RestParameters pathVariables = new RestParameters()
                .addParameter("index", item.getItemIndex());

        SimpleEntity simpleEntity = itemByIndexResource
                .httpGetAsEntity(
                        pathVariables,
                        bodyParameters);
        System.out.println("answer from server on add one item: " + simpleEntity.getContent());
        return this;
    }

    //DELETE item .addText("URL=/item/{index}, method=DELETE deleteItem,
    // PARAMETERS= token, index")

    //PUT .addText("URL=/item/{index}, method=PUT updateItem, PARAMETERS=
    // token, index, item")
}