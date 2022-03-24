package stepDefinitions.user;

import commons.PageGeneratorManager;
import cucumberOptions.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pageObject.user.UserHomePageObject;
import pageObject.user.UserLoginPageObject;
import pageObject.user.UserRegisterPageObject;

public class UserHomePageSteps {

    WebDriver driver;
    UserHomePageObject userHomePage;
    UserRegisterPageObject userRegisterPage;
    UserLoginPageObject userLoginPage;

    public UserHomePageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
        userHomePage = PageGeneratorManager.getUserHomePage(driver);
    }

    @Given("a web browser is on the Register Page")
    public void aWebBrowserIsOnTheRegisterPage() {
        userHomePage.clickToHeaderMenuLinkByText(driver, "Register");
        userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
    }

    @And("click to Register header link")
    public void clickToRegisterHeaderLink() {
        userHomePage.clickToHeaderMenuLinkByText(driver, "Register");
        userRegisterPage = PageGeneratorManager.getUserRegisterPage(driver);
    }

    @Given("a web browser is on the Login Page")
    public void clickToLogInHeaderLink() {
        userHomePage.clickToHeaderMenuLinkByText(driver, "Log in");
        userLoginPage = PageGeneratorManager.getUserLoginPage(driver);
    }
}
