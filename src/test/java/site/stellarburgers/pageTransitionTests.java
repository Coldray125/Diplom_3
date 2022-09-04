package site.stellarburgers;

import com.codeborne.selenide.conditions.webdriver.Url;
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
import static site.stellarburgers.configuration.ListURL.*;

public class pageTransitionTests {

    UserBuilder userBuilder = new UserBuilder();
    PageHeader pageHeader;
    MainPage mainPage;
    RegisterPage registerPage;
    LoginPage loginPage;
    ProfilePage profilePage;
    RestorePasswordPage restorePasswordPage;
    HashMap<String, String> data;

    @Before
    public void configurationSetup() {
        data = new RandomData().randomCredentials();
        data.put("token",userBuilder.createRandomUserReturnToken(data));
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
        String token = userBuilder.AuthUserGetToken(data);
        userBuilder.deleteUserWithAccessToken(token);
    }

    @Test
    @DisplayName("Провека перехода по клику на «Личный кабинет»")
    public void transitionPersonalAccount() {
        pageHeader.clickPersonalAccountButton();
        loginPage.fillLoginCredentialsAndClickLogin(data);
        pageHeader.clickPersonalAccountButton();
        webdriver().shouldHave(url(burgerProfileURL));
    }

    @Test
    @DisplayName("Проверка перехода по клику на «Конструктор»")
    public void transitionConstructorButton() {
        pageHeader.clickPersonalAccountButton();
        loginPage.fillLoginCredentialsAndClickLogin(data);
        pageHeader.clickPersonalAccountButton();
        pageHeader.clickConstructorButton();
        webdriver().shouldHave(url(burgerMainURL));
    }


    @Test
    @DisplayName("Проверка перехода по клику на логотип Stellar Burgers")
    public void transitionBurgerLogo() {
        pageHeader.clickPersonalAccountButton();
        loginPage.fillLoginCredentialsAndClickLogin(data);
        pageHeader.clickPersonalAccountButton();
        pageHeader.clickBurgerLogo();
        webdriver().shouldHave(url(burgerMainURL));
    }

    @Test
    @DisplayName("Проверка выхода по кнопке «Выйти» в личном кабинете")
    public void transitionLogoutButton() {
        pageHeader.clickPersonalAccountButton();
        loginPage.fillLoginCredentialsAndClickLogin(data);
        pageHeader.clickPersonalAccountButton();
        profilePage.clickLogoutButton();
        webdriver().shouldHave(url(burgerLoginURL));
    }
}