package site.stellarburgers.pageobject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;

public class ProfilePage {

    @FindBy(how = How.XPATH, using = "//*[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']")
    private SelenideElement logoutButton;

    public void clickLogoutButton() {
        logoutButton.shouldBe(visible).click();
    }
}
