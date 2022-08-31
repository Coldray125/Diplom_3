package site.stellarburgers.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class MainPage {

    @FindBy(how = How.XPATH, using = "//*[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']")
    private SelenideElement enterAccountButton;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Булки')][@class='text text_type_main-medium mb-6 mt-10']")
    public SelenideElement bunsSection;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Соусы')][@class='text text_type_main-medium mb-6 mt-10']")
    public SelenideElement sauceSection;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Начинки')][@class='text text_type_main-medium mb-6 mt-10']")
    public SelenideElement fillingSection;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Булки')][@class='text text_type_main-default']")
    private SelenideElement bunsButton;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Соусы')][@class='text text_type_main-default']")
    private SelenideElement sauceButton;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Начинки')][@class='text text_type_main-default']")
    private SelenideElement fillingButton;

    public void clickEnterAccountButton() {
        enterAccountButton.shouldBe(visible).click();
    }

    public void clickBunsButton() {
        bunsButton.shouldBe(visible).click();
    }

    public void clickSauceButton() {
        sauceButton.shouldBe(visible).click();
    }

    public void clickFillingButton() {
        fillingButton.shouldBe(visible).click();
    }
}