package pageObject.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUI.user.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage {

    WebDriver driver;

    public UserRegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getDynamicErrorMessage(String fieldName) {
        waitForElementVisible(driver, UserRegisterPageUI.DYNAMIC_ERROR_MESSAGE, fieldName);
        return getElementText(driver, UserRegisterPageUI.DYNAMIC_ERROR_MESSAGE, fieldName);
    }

    public void selectDateOfBirth(String dateOfBirth, String selectValue) {
        waitForElementVisible(driver, UserRegisterPageUI.DYNAMIC_SELECT_DROP_DOWN_BY_NAME, dateOfBirth);
        selectItemInDefaultDropDown(driver, UserRegisterPageUI.DYNAMIC_SELECT_DROP_DOWN_BY_NAME, selectValue, dateOfBirth);
    }

    public String getRegisteredSuccessMessage() {
        waitForElementVisible(driver, UserRegisterPageUI.REGISTERED_SUCCESS_MESSAGE);
        return getElementText(driver, UserRegisterPageUI.REGISTERED_SUCCESS_MESSAGE);
    }

    public String getEmailAlreadyExistsErrorMessage() {
        waitForElementVisible(driver, UserRegisterPageUI.EMAIL_ALREADY_EXIST_ERROR_MESSAGE);
        return getElementText(driver, UserRegisterPageUI.EMAIL_ALREADY_EXIST_ERROR_MESSAGE);
    }
}
