package site.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
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

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static org.junit.Assert.assertTrue;
import static site.stellarburgers.configuration.ListURL.burgerLoginURL;

public class UserRegisterTests {

    UserBuilder userBuilder = new UserBuilder();
    PageHeader pageHeader;
    MainPage mainPage;
    RegisterPage registerPage;
    LoginPage loginPage;
    HashMap<String, String> data = new HashMap<>();

    @Before
    public void configurationSetup() {
        new Config().chrome();
        data = new RandomData().randomCredentials();
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
    @DisplayName("Успешная регистрация")
    public void registerUserValidData() {
        pageHeader.clickPersonalAccountButton();
        loginPage.clickRegisterButton();
        registerPage.fillCredentials(data);
        registerPage.clickRegisterButton();
        webdriver().shouldHave(url(burgerLoginURL));
    }

    @Test
    @DisplayName("Проверка ошибки для некорректного пароля. Минимальный пароль — шесть символов")
    public void registerUserWrongPassword() {
        pageHeader.clickPersonalAccountButton();
        loginPage.clickRegisterButton();
        data.put("password", RandomStringUtils.randomAlphanumeric(5));
        registerPage.fillCredentials(data);
        registerPage.clickRegisterButton();
        assertTrue(registerPage.getPasswordError());
    }
}