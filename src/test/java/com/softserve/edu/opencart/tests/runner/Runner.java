package com.softserve.edu.opencart.tests.runner;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.softserve.edu.opencart.pages.admin.account.LoginPage;
import com.softserve.edu.opencart.pages.user.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class Runner {
    protected WebDriver driver; // singlethread
    protected Map<Long, WebDriver> drivers; // multithread
    protected final Long ONE_SECOND_DELAY = 1000L;
    protected final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss";
    //    private final String SERVER_URL = System.getenv().get("OPENCART_URL");
    protected final String SERVER_URL = ("http://172.16.0.131/opencart/upload/");
//    protected final String SERVER_URL = ("http://192.168.196.129/opencart/upload/");
    protected final String SERVER_ADMIN_URL = SERVER_URL + "admin/";
    protected final String USER_ENABLED = "1";
    protected final String USER_DISABLED = "0";
    protected final String EXPECTED_ERROR_MESSAGE = "Warning: No match for E-Mail Address and/or Password.";
    protected final String CUSTOMER_SUCCESSFULLY_CREATED_MESSAGE = "Your Account Has Been Created!";
    protected final String CUSTOMER_FIRSTNAME_ERROR = "First Name must be between 1 and 32 characters!";
    protected final String FIRST_NAME_AMEND = "Lv459-TAQC-Updated";
    protected final String CUSTOMER_UPDATED_MESSAGE = "Success: Your account has been successfully updated.";
    protected final String HRYVNIA = "hryvnia";
    protected final int TWO_HUNDRED_AND_FIFTY_FIVE = 255;
    protected final int SIXTY_FIVE_THOUSANDS_FIVE_HUNDRED_AND_THIRTY_SIX = 65536;
    protected final String NUMBERS_AND_LETTERS = "0123456789abcdefghijklmnopqrstuvwxyz\\*;.,%$#\\\\'{}()\",";
    protected final String BLOCK_USER_ERROR_MESSAGE = "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
    protected final String EMAIL_URL = "https://www.ukr.net/";
    protected final String RESET_PASSWORD_MESSAGE = "Password reset";




}