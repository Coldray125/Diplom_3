package site.stellarburgers;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.stellarburgers.configuration.Config;
import site.stellarburgers.configuration.ListURL;
import site.stellarburgers.pageobject.MainPage;

import static com.codeborne.selenide.Selenide.*;

public class burgerConstructorTests {

    MainPage mainPage;

    @Before
    public void configurationSetup() {
        new Config().chrome();
        mainPage = page(MainPage.class);
        open(ListURL.burgerMainURL);
    }

    @Test
    @DisplayName("Проверка работы переходы к разделу \"Булки\"")
    public void bunsButtonSelected() {
        mainPage.clickSauceButton();
        mainPage.clickBunsButton();
        String tab = mainPage.activeConstructorTab().innerText();
        Assert.assertEquals("Булки", tab);
    }

    @Test
    @DisplayName("Проверка работы переходы к разделу \"Соусы\"")
    public void sauceButtonSelected() {
        mainPage.clickSauceButton();
        String tab = mainPage.activeConstructorTab().innerText();
        Assert.assertEquals("Соусы", tab);
    }

    @Test
    @DisplayName("Проверка работы переходы к разделу \"Начинки\"")
    public void fillingButtonSelected() {
        mainPage.clickFillingButton();
        String tab = mainPage.activeConstructorTab().innerText();
        Assert.assertEquals("Начинки", tab);
    }
}