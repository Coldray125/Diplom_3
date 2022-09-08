package site.stellarburgers.pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class PageHeader {

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Личный Кабинет')][@class='AppHeader_header__linkText__3q_va ml-2']")
    private SelenideElement accountButton;
    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Конструктор')][@class='AppHeader_header__linkText__3q_va ml-2']")
    private SelenideElement constructorButton;
    @FindBy(how = How.XPATH, using = "//*[@class='AppHeader_header__logo__2D0X2']/a/*")
    private SelenideElement burgerLogo;

    @Step("Нажатие на кнопку \"Личный Кабинет\" в header")
    public void clickPersonalAccountButton() {
        accountButton.shouldBe(visible).click();
    }

    @Step("Нажатие на кнопку \"Конструктор\" в header")
    public void clickConstructorButton() {
        constructorButton.shouldBe(visible).click();
    }

    @Step("Нажатие на логотип \"Stellar Burgers\" в header")
    public void clickBurgerLogo() {
        burgerLogo.shouldBe(visible).click();
    }
}