package pageObject.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUI.user.UserLoginPageUI;

public class UserLoginPageObject extends BasePage {

    WebDriver driver;

    public UserLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getEmailErrorMessage() {
        waitForElementVisible(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
        return getElementText(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
    }
}
