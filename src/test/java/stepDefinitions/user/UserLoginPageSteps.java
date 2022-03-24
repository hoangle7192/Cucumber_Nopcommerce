package stepDefinitions.user;

import commons.PageGeneratorManager;
import cucumberOptions.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.user.UserCustomerInfoPageObject;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserLoginPageObject;

import java.util.List;

public class UserLoginPageSteps {

    WebDriver driver;
    UserLoginPageObject userLoginPage;
    UserCustomerInfoPageObject userCustomerInfoPage;

    public UserLoginPageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
        userLoginPage = PageGeneratorManager.getUserLoginPage(driver);
    }

    @When("click Login button")
    public void clickLoginButton() {
        userLoginPage.clickToButtonByText(driver, "Log in");
        userCustomerInfoPage = PageGeneratorManager.getUserCustomerInfoPage(driver);
    }

    @When("enter value invalid {string} to Email text box")
    public void enterValueToEmailTextBox(DataTable dataTable) {
        List<List<String>> email = dataTable.cells();
        userLoginPage.enterToTextBoxByName(driver, "Email", email.get(0).get(0));
    }

    @Then("email error message {string} is displayed")
    public void emailErrorMessageIsDisplayed(String errorMessage) {
        Assert.assertEquals(errorMessage, userLoginPage.getEmailErrorMessage());
    }

    @When("enter registered email to Email text box")
    public void enterRegisteredEmailToEmailTextBox() {
        userLoginPage.enterToTextBoxByName(driver, "Email", UserCustomerInfoPageSteps.emailMain);
    }

    @And("enter valid password to Password text box")
    public void enterValidPasswordToPasswordTextBox(DataTable dataTable) {
        List<List<String>> password = dataTable.cells();
        userLoginPage.enterToTextBoxByName(driver, "Password", password.get(0).get(0));
    }

    @Then("a web browser is on the Customer Info Page with title {string}")
    public void getCustomerInfoPageTitle(String titlePage) {
        Assert.assertEquals(titlePage, userLoginPage.getCustomerInfoPageTitle());
    }
}
