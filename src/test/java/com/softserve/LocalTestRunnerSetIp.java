package com.softserve;

import org.openqa.selenium.WebDriver;

public abstract class LocalTestRunnerSetIp {
    protected static final String IP = "172.16.0.128";
    protected static final int DELAY = 1000;
    protected static WebDriver driver;
    protected static final String USER_EMAIL = System.getenv("USER_EMAIL");
    protected static final String DB_PASSWORD = System.getenv("DB_PASSWORD");
    protected static final String USER_PASSWORD = System.getenv("USER_PASSWORD");

}
