package site.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.stellarburgers.builders.UserBuilder;
import site.stellarburgers.configuration.Config;
import site.stellarburgers.configuration.ListURL;
import site.stellarburgers.generators.RandomData;
import site.stellarburgers.pageobject.*;

import java.util.HashMap;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static site.stellarburgers.configuration.ListURL.burgerMainURL;

public class UserLoginTests {

    UserBuilder userBuilder = new UserBuilder();
    PageHeader pageHeader;
    MainPage mainPage;
    RegisterPage registerPage;
    LoginPage loginPage;
    RestorePasswordPage restorePasswordPage;
    HashMap<String, String> data = new HashMap<>();

    @Before
    public void configurationSetup() {
        data = new RandomData().randomCredentials();
        data.put("token",userBuilder.createRandomUserReturnToken(data));
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
        if (data.get("token") != null) {
            userBuilder.deleteUserWithAccessToken(data.get("token"));
        }
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void clickPersonalAccountAndLogin() {
        pageHeader.clickPersonalAccountButton();
        loginPage.fillLoginCredentialsAndClickLogin(data);
        webdriver().shouldHave(url(burgerMainURL));
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    public void clickEnterAccountAndLogin() {
        mainPage.clickEnterAccountButton();
        loginPage.fillLoginCredentialsAndClickLogin(data);
        webdriver().shouldHave(url(burgerMainURL));
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void clickBottomLoginButtonInRegisterFormAndLogin() {
        mainPage.clickEnterAccountButton();
        loginPage.clickRegisterButton();
        registerPage.clickBottomLoginButton();
        loginPage.fillLoginCredentialsAndClickLogin(data);
        webdriver().shouldHave(url(burgerMainURL));
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void clickLoginButtonInRestorePasswordFormAndLogin() {
        mainPage.clickEnterAccountButton();
        loginPage.clickRestorePasswordButton();
        restorePasswordPage.clickBottomLoginButton();
        loginPage.fillLoginCredentialsAndClickLogin(data);
        webdriver().shouldHave(url(burgerMainURL));
    }
}