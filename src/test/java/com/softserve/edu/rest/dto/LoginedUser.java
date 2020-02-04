package com.softserve.edu.rest.dto;

import com.softserve.edu.rest.data.User;

import java.util.ArrayList;

public class LoginedUser {

    private User user;
    private String token;
    private long loginTime;
    private ArrayList<String> items;

    public LoginedUser(User user, String token) {
        this.user = user;
        this.token = token;
        loginTime = System.currentTimeMillis();
    }

    public User getUser() {
        return user;
    }

    public String getToken() {
        return token;
    }

    public long getLoginTime() {
        return loginTime;
    }

    public ArrayList<String> fillAllItems() {
        //    "content": "1 \tnew item by loco\n3 \tnew item by loco\n"
        // TODO - parse results into 'items'arraylist @speretc
        return fillAllItems();
    }

    @Override
    public String toString() {
        return user + "";
    }

}
