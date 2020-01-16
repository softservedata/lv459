package com.softserve.edu.opencart.data;

interface ILogin {
    IAdminPassword setLogin(String login);
}

interface IAdminPassword {
    IBuildAdmin setPassword(String password);
}

interface IBuildAdmin {
    IAdmin build();
}

public final class Admin implements ILogin, IAdminPassword, IBuildAdmin, IAdmin {

    private String username;
    private String password;

    public static ILogin get() {
        return new Admin();
    }

    public IAdminPassword setLogin(String username) {
        this.username = username;
        return this;
    }

    public IBuildAdmin setPassword(String password) {
        this.password = password;
        return this;
    }


    public IAdmin build() {
        return this;
    }

    public String getLogin() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}