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

    @When("enter registered email to Email text box")
    public void enterRegisteredEmailToEmailTextBox() {
        userLoginPage.enterToTextBoxByName(driver, "Email", UserRegisterPageSteps.email);
    }

    @And("enter valid password to Password text box")
    public void enterValidPasswordToPasswordTextBox(DataTable dataTable) {
        List<List<String>> password = dataTable.cells();
        userLoginPage.enterToTextBoxByName(driver, "Password", password.get(0).get(0));
    }

    @Then("a web browser is on the Customer Info Page")
    public void getCustomerInfoPageTitle(DataTable dataTable) {
        List<List<String>> title = dataTable.cells();
        Assert.assertEquals(title.get(0).get(0), userLoginPage.getCustomerInfoPageTitle());
    }
}
