package stepDefinitions.user;

import commons.PageGeneratorManager;
import cucumberOptions.Hooks;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.user.UserCustomerInfoPageObject;
import pageObject.user.UserRegisterPageObject;
import ultil.DataHelper;

import java.util.List;
import java.util.Map;

import static cucumberOptions.Hooks.generateNumber;

public class UserRegisterPageSteps {

    WebDriver driver;
    DataHelper dataHelper;
    UserRegisterPageObject userRegisterPage;
    UserCustomerInfoPageObject userCustomerInfoPage;

    public static String email;

    public UserRegisterPageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
        dataHelper = DataHelper.getData();
        userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
    }

    @When("click to Register button")
    public void clickToRegisterButton() {
        userRegisterPage.clickToButtonByText(driver, "Register");
    }

    @Then("First name error message is displayed {string}")
    public void firstNameErrorMessageIsDisplayed(String errorMessage) {
        Assert.assertEquals(errorMessage, userRegisterPage.getDynamicErrorMessage("FirstName-error"));
    }

    @Then("Last name error message is displayed {string}")
    public void lastNameErrorMessageIsDisplayed(String errorMessage) {
        Assert.assertEquals(errorMessage, userRegisterPage.getDynamicErrorMessage("LastName-error"));
    }

    @Then("Email error message is displayed {string}")
    public void emailErrorMessageIsDisplayed(String errorMessage) {
        Assert.assertEquals(errorMessage, userRegisterPage.getDynamicErrorMessage("Email-error"));
    }

    @Then("Password error message is displayed {string}")
    public void passwordErrorMessageIsDisplayed(String errorMessage) {
        Assert.assertEquals(errorMessage, userRegisterPage.getDynamicErrorMessage("Password-error"));
    }

    @Then("Confirm password error message is displayed {string}")
    public void confirmPasswordErrorMessageIsDisplayed(String errorMessage) {
        Assert.assertEquals(errorMessage, userRegisterPage.getDynamicErrorMessage("ConfirmPassword-error"));
    }


    @Then("Email's error message is displayed {string}")
    public void emailSErrorMessageIsDisplayed(String errorMessage) {
        Assert.assertEquals(errorMessage, userRegisterPage.getDynamicErrorMessage("Email-error"));
    }


    @When("enter {string} to Email text box")
    public void enterToEmailTextBox(String enterValue) {
        userRegisterPage.enterToTextBoxByName(driver, "Email", enterValue);
    }

    @When("enter to Your Personal Details form with data")
    public void enterToYourPersonalDetailsFormWithData(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> userInfo = dataTable.asMaps(String.class, String.class);
        userRegisterPage.clickToRadioButtonByValue(driver, userInfo.get(0).get("gender"));
        userRegisterPage.enterToTextBoxByName(driver, "FirstName", userInfo.get(0).get("firstName"));
        userRegisterPage.enterToTextBoxByName(driver, "LastName", userInfo.get(0).get("lastName"));
        userRegisterPage.selectDateOfBirth("DateOfBirthDay", userInfo.get(0).get("dateOfBirthDay"));
        userRegisterPage.selectDateOfBirth("DateOfBirthMonth", userInfo.get(0).get("dateOfBirthMonth"));
        userRegisterPage.selectDateOfBirth("DateOfBirthYear", userInfo.get(0).get("dateOfBirthYear"));
        userRegisterPage.enterToTextBoxByName(driver, "Email",userInfo.get(0).get("email") );
        userRegisterPage.enterToTextBoxByName(driver, "Company", userInfo.get(0).get("company"));
        userRegisterPage.enterToTextBoxByName(driver, "Password", userInfo.get(0).get("password"));
        userRegisterPage.enterToTextBoxByName(driver, "ConfirmPassword", userInfo.get(0).get("confirmPassword"));
    }

    @Then("registered success message has displayed {string}")
    public void isRegisteredSuccessMessageDisplayed(String successMessage) {
        Assert.assertEquals(userRegisterPage.getRegisteredSuccessMessage(), successMessage);
    }


    @Then("error message {string} is displayed")
    public void errorMessageIsDisplayed(String errorMessage) {
        Assert.assertEquals(userRegisterPage.getDynamicErrorMessage("Password"), errorMessage);
    }

    @When("enter {string} to Password text box")
    public void enterToPasswordTextBox(String enterValue) {
        userRegisterPage.enterToTextBoxByName(driver, "Password", enterValue);
    }

    @When("enter {string} to Confirm Password text box")
    public void enterToConfirmPasswordTextBox(String enterValue) {
        userRegisterPage.enterToTextBoxByName(driver, "ConfirmPassword", enterValue);
    }

    @Then("email already exists error message is displayed {string}")
    public void emailAlreadyExistsErrorMessageIsDisplayed(String errorMessage) {
        userRegisterPage.getEmailAlreadyExistsErrorMessage();
    }

    @When("click to My account header link")
    public void clickToMyAccountHeaderLink() {
        userRegisterPage.clickToHeaderMenuLinkByText(driver, "My account");
        userCustomerInfoPage = PageGeneratorManager.getUserCustomerInfoPage(driver);
    }
}
