package site.stellarburgers;

import com.codeborne.selenide.conditions.webdriver.Url;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.stellarburgers.builders.UserBuilder;
import site.stellarburgers.configuration.Config;
import site.stellarburgers.configuration.ListURL;
import site.stellarburgers.pageobject.*;

import java.util.HashMap;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;
import static site.stellarburgers.configuration.ListURL.burgerMainURL;
import static site.stellarburgers.configuration.ListURL.burgerProfileURL;

public class userLoginTests {

    UserBuilder userBuilder = new UserBuilder();
    PageHeader pageHeader;
    MainPage mainPage;
    RegisterPage registerPage;
    LoginPage loginPage;
    RestorePasswordPage restorePasswordPage;
    HashMap<String, String> data = new HashMap<>();

    @Before
    public void configurationSetup() {
        data = userBuilder.createRandomUserReturnHashmap();
        new Config().chrome();
        pageHeader = page(PageHeader.class);
        mainPage = page(MainPage.class);
        registerPage = page(RegisterPage.class);
        loginPage = page(LoginPage.class);
        restorePasswordPage = page(RestorePasswordPage.class);
        open(ListURL.burgerMainURL);
    }

    @After
    public void deleteUser() {
        userBuilder.deleteUserWithAccessToken(userBuilder.AuthUserGetToken(data));
    }

    @Test
    public void clickPersonalAccountAndLogin() {
        pageHeader.clickPersonalAccountButton();
        loginPage.fillLoginCredentialsAndClickLogin(data);
        pageHeader.clickPersonalAccountButton();
        webdriver().shouldHave(new Url(burgerProfileURL));
    }

    @Test
    public void clickEnterAccountAndLogin() {
        mainPage.clickEnterAccountButton();
        loginPage.fillLoginCredentialsAndClickLogin(data);
        pageHeader.clickPersonalAccountButton();
        webdriver().shouldHave(new Url(burgerProfileURL));
    }

    @Test
    public void clickBottomLoginButtonInRegisterFormAndLogin() {
        mainPage.clickEnterAccountButton();
        loginPage.clickRegisterButton();
        registerPage.clickBottomLoginButton();
        loginPage.fillLoginCredentialsAndClickLogin(data);
        pageHeader.clickPersonalAccountButton();
        webdriver().shouldHave(new Url(burgerProfileURL));
    }

    @Test
    public void clickLoginButtonInRestorePasswordFormAndLogin() {
        mainPage.clickEnterAccountButton();
        loginPage.clickRestorePasswordButton();
        restorePasswordPage.clickBottomLoginButton();
        loginPage.fillLoginCredentialsAndClickLogin(data);
        pageHeader.clickPersonalAccountButton();
        webdriver().shouldHave(new Url(burgerProfileURL));
    }
}
