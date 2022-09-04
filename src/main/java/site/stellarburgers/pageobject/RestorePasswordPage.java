package site.stellarburgers.pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class RestorePasswordPage {

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Войти')][@class='Auth_link__1fOlj']")
    private SelenideElement bottomLoginButton;

    @Step("Нажатие кнопки \"Войти\" в форме регистрации")
    public void clickBottomLoginButton() {
        bottomLoginButton.shouldBe(visible).click();
    }
}