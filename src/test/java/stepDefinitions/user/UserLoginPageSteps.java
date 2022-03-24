package stepDefinitions.user;

import commons.PageGeneratorManager;
import cucumberOptions.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserLoginPageObject;

import java.util.List;

public class UserLoginPageSteps {

    WebDriver driver;
    UserHomePageObject userHomePage;
    UserLoginPageObject userLoginPage;

    public UserLoginPageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
        userLoginPage = PageGeneratorManager.getUserLoginPage(driver);
    }

    @When("click Login button")
    public void clickLoginButton() {
        userLoginPage.clickToButtonByText(driver, "Log in");
    }

    @When("enter value to Email text box")
    public void enterValueToEmailTextBox(DataTable dataTable) {
        List<List<String>> email = dataTable.cells();
        userLoginPage.enterToTextBoxByName(driver, "Email", email.get(0).get(0));
    }

    @Then("email error message is displayed")
    public void emailErrorMessageIsDisplayed(DataTable dataTable) {
        List<List<String>> errorMessage = dataTable.cells();
        Assert.assertEquals(errorMessage.get(0).get(0), userLoginPage.getEmailErrorMessage());
    }

}
