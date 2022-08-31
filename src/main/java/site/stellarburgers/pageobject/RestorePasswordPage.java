package site.stellarburgers.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class RestorePasswordPage {

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Войти')][@class='Auth_link__1fOlj']")
    private SelenideElement bottomLoginButton;

    public void clickBottomLoginButton() {
        bottomLoginButton.shouldBe(visible).click();
    }
}