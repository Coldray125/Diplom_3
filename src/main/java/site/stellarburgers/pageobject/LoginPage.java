package site.stellarburgers.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.HashMap;

import static com.codeborne.selenide.Condition.visible;

public class LoginPage {

    @FindBy(how = How.XPATH, using = "//fieldset[1]//*[@class='text input__textfield text_type_main-default']")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = "//fieldset[2]//*[@class='text input__textfield text_type_main-default']")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = "//*[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement loginButton;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Зарегистрироваться')][@class='Auth_link__1fOlj']")
    private SelenideElement registerButton;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Восстановить пароль')][@class='Auth_link__1fOlj']")
    private SelenideElement restorePasswordButton;

    public void clickLoginButton() {
        loginButton.shouldBe(visible).click();
    }

    public void clickRegisterButton() {
        registerButton.shouldBe(visible).click();
    }

    public void clickRestorePasswordButton() {
        restorePasswordButton.shouldBe(visible).click();
    }

    public void fillLoginCredentialsAndClickLogin(HashMap<String, String> data) {
        emailField.shouldBe(visible).sendKeys(data.get("email"));
        passwordField.shouldBe(visible).sendKeys(data.get("password"));
        clickLoginButton();
    }
}