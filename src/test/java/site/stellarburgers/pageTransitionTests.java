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
import static site.stellarburgers.configuration.ListURL.*;

public class pageTransitionTests {

    UserBuilder userBuilder = new UserBuilder();
    PageHeader pageHeader;
    MainPage mainPage;
    RegisterPage registerPage;
    LoginPage loginPage;
    ProfilePage profilePage;
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
        profilePage = page(ProfilePage.class);
        restorePasswordPage = page(RestorePasswordPage.class);
        open(ListURL.burgerMainURL);
    }

    @After
    public void deleteUser() {
        userBuilder.deleteUserWithAccessToken(userBuilder.AuthUserGetToken(data));
    }

    @Test
    public void transitionPersonalAccount() {
        pageHeader.clickPersonalAccountButton();
        loginPage.fillLoginCredentialsAndClickLogin(data);
        pageHeader.clickPersonalAccountButton();
        webdriver().shouldHave(new Url(burgerProfileURL));
    }

    @Test
    public void transitionConstructorButton() {
        pageHeader.clickPersonalAccountButton();
        loginPage.fillLoginCredentialsAndClickLogin(data);
        pageHeader.clickPersonalAccountButton();
        pageHeader.clickConstructorButton();
        webdriver().shouldHave(new Url(burgerMainURL));
    }


    @Test
    public void transitionBurgerLogo() {
        pageHeader.clickPersonalAccountButton();
        loginPage.fillLoginCredentialsAndClickLogin(data);
        pageHeader.clickPersonalAccountButton();
        pageHeader.clickBurgerLogo();
        webdriver().shouldHave(new Url(burgerMainURL));
    }

    @Test
    public void transitionLogoutButton() {
        pageHeader.clickPersonalAccountButton();
        loginPage.fillLoginCredentialsAndClickLogin(data);
        pageHeader.clickPersonalAccountButton();
        profilePage.clickLogoutButton();
        webdriver().shouldHave(new Url(burgerLoginURL));
    }
}