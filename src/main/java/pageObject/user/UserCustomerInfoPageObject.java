package pageObject.user;

import commons.BasePage;
import commons.BasePageUI;
import org.openqa.selenium.WebDriver;

public class UserCustomerInfoPageObject extends BasePage {

    WebDriver driver;

    public UserCustomerInfoPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getEmailAttributeValue(String fieldName) {
        waitForElementVisible(driver, BasePageUI.DYNAMIC_TEXT_BOX_BY_NAME, fieldName);
        return getElementAttributeValue(driver, BasePageUI.DYNAMIC_TEXT_BOX_BY_NAME, "value", fieldName);
    }
}
