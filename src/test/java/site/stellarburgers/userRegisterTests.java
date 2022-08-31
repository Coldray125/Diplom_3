package site.stellarburgers;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.stellarburgers.builders.UserBuilder;
import site.stellarburgers.configuration.Config;
import site.stellarburgers.configuration.ListURL;
import site.stellarburgers.generators.RandomData;
import site.stellarburgers.pageobject.LoginPage;
import site.stellarburgers.pageobject.MainPage;
import site.stellarburgers.pageobject.PageHeader;
import site.stellarburgers.pageobject.RegisterPage;

import java.util.HashMap;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class userRegisterTests {

    UserBuilder userBuilder = new UserBuilder();
    PageHeader pageHeader;
    MainPage mainPage;
    RegisterPage registerPage;
    LoginPage loginPage;
    HashMap<String, String> data = new HashMap<>();

    @Before
    public void configurationSetup() {
        data = new RandomData().randomCredentials();
        new Config().chrome();
        pageHeader = page(PageHeader.class);
        mainPage = page(MainPage.class);
        registerPage = page(RegisterPage.class);
        loginPage = page(LoginPage.class);
        open(ListURL.burgerMainURL);
    }

    @After
    public void deleteUser() {
        data.put("token", userBuilder.AuthUserGetToken(data));
        if (data.get("token") != null) {
            userBuilder.deleteUserWithAccessToken(data.get("token"));
        }
    }

    @Test
    public void registerUserValidData() {
        pageHeader.clickPersonalAccountButton();
        loginPage.clickRegisterButton();
        registerPage.fillCredentials(data);
        registerPage.clickRegisterButton();
        Assert.assertNotNull(userBuilder.AuthUserGetToken(data));
    }

    @Test
    public void registerUserWrongPassword() {
        pageHeader.clickPersonalAccountButton();
        loginPage.clickRegisterButton();
        data.put("password", RandomStringUtils.randomAlphanumeric(5));
        registerPage.fillCredentials(data);
        registerPage.clickRegisterButton();
        Assert.assertNull(userBuilder.AuthUserGetToken(data));
    }
}