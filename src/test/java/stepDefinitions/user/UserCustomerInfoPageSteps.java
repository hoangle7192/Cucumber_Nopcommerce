package stepDefinitions.user;

import commons.PageGeneratorManager;
import cucumberOptions.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObject.user.UserCustomerInfoPageObject;
import pageObject.user.UserHomePageObject;

public class UserCustomerInfoPageSteps {

    WebDriver driver;
    UserCustomerInfoPageObject userCustomerInfoPage;
    UserHomePageObject userHomePage;

    public static String emailMain;

    public UserCustomerInfoPageSteps() {
        this.driver = Hooks.openAndQuitBrowser();
        userCustomerInfoPage = PageGeneratorManager.getUserCustomerInfoPage(driver);
    }

    @And("get Email attribute value")
    public void getEmailAttributeValue() {
        emailMain = userCustomerInfoPage.getEmailAttributeValue("Email");
    }

    @When("click to Logout button")
    public void clickToLogoutButton() {
        userCustomerInfoPage.clickToHeaderMenuLinkByText(driver, "Log out");
        userHomePage = PageGeneratorManager.getUserHomePage(driver);
    }
}
