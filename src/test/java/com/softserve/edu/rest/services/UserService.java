package com.softserve.edu.rest.services;

import com.softserve.edu.rest.data.Item;
import com.softserve.edu.rest.dto.LoginedUser;
import com.softserve.edu.rest.dto.RestParameters;
import com.softserve.edu.rest.entity.SimpleEntity;
import com.softserve.edu.rest.resources.ItemIndexResource;

public class UserService extends GuestService {

    protected LoginedUser loginedUser;
    protected ItemIndexResource itemIndexResource;

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

    public String getToken() {
        return loginedUser.getToken();
    }

    //GET item (token + index) 	.addText("URL=/item/{index}, method=GET
    // getItem, PARAMETERS= token, index");
    public String getItemByIndex(String index) {
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", getToken());
        RestParameters pathVariables = new RestParameters()
                .addParameter("", index);

        SimpleEntity simpleEntity = itemIndexResource
                .httpGetAsEntity(pathVariables,
                                 bodyParameters);
        System.out.println("simpleEntity =" + simpleEntity.getContent());
        return simpleEntity.getContent();
    }

    //POST  .addText("URL=/item/{index}, method=POST addItem, PARAMETERS=
    // token, item")
    public UserService postNewItemByIndex(Item item) {
        RestParameters bodyParameters = new RestParameters()
                .addParameter("token", getToken())
                .addParameter(item.getItemIndex(), item.getItemText());
        RestParameters pathVariables = new RestParameters()
                .addParameter("", item.getItemIndex());

        SimpleEntity simpleEntity = itemIndexResource
                .httpGetAsEntity(pathVariables, bodyParameters);
        System.out.println("answer from server on add one item: " +simpleEntity.getContent());
        return this;
    }

    //DELETE item .addText("URL=/item/{index}, method=DELETE deleteItem,
    // PARAMETERS= token, index")

    //PUT .addText("URL=/item/{index}, method=PUT updateItem, PARAMETERS=
    // token, index, item")
}