package site.stellarburgers;

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
    public void bunsButtonSelected() {
        mainPage.clickSauceButton();
        mainPage.clickBunsButton();
        Assert.assertTrue($(mainPage.bunsSection).isDisplayed());
    }

    @Test
    public void sauceButtonSelected() {
        mainPage.clickSauceButton();
        Assert.assertTrue($(mainPage.sauceSection).isDisplayed());
    }

    @Test
    public void fillingButtonSelected() {
        mainPage.clickFillingButton();
        Assert.assertTrue($(mainPage.fillingSection).isDisplayed());
    }
}
