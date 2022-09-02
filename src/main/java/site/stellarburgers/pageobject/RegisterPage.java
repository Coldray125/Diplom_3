package site.stellarburgers.pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.HashMap;

import static com.codeborne.selenide.Condition.visible;

public class RegisterPage {

    @FindBy(how = How.XPATH, using = "//fieldset[1]//*[@class='text input__textfield text_type_main-default']")
    private SelenideElement nameField;

    @FindBy(how = How.XPATH, using = "//fieldset[2]//*[@class='text input__textfield text_type_main-default']")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH, using = "//fieldset[3]//*[@class='text input__textfield text_type_main-default']")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Зарегистрироваться')][@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']")
    private SelenideElement registerButton;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Войти')][@class='Auth_link__1fOlj']")
    private SelenideElement bottomLoginButton;

    @FindBy(how = How.XPATH, using = "//*[contains (text(), 'Некорректный пароль')]")
    private SelenideElement errorPasswordField;

    public void fillCredentials(HashMap<String, String> data) {
        nameField.shouldBe(visible).sendKeys(data.get("name"));
        emailField.shouldBe(visible).sendKeys(data.get("email"));
        passwordField.shouldBe(visible).sendKeys(data.get("password"));
    }

    public void fillName(String name) {
        nameField.sendKeys(name);
    }

    public void fillEmail(String email) {
        emailField.sendKeys(email);
    }

    public void fillPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickRegisterButton() {
        registerButton.shouldBe(visible).click();
    }

    public void clickBottomLoginButton() {
        bottomLoginButton.shouldBe(visible).click();
    }

    @Step("Получить текст об ошибке")
    public boolean getPasswordError() {
        return errorPasswordField.shouldBe(visible).isDisplayed();
    }
}
