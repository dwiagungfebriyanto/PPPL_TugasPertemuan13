package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ToolPage;

public class LoginStepDef {
    WebDriver driver;
    LoginPage login;
    ToolPage tool;

    void setUp() {
        this.driver = new ChromeDriver();
        login = new LoginPage(driver);
        tool = new ToolPage(driver);
        driver.manage().window().maximize();
    }

    public void closeBrowser() {
        driver.quit();
    }

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        setUp();
        driver.get("http://localhost:5173/");
    }

    @When("user submits valid credentials")
    public void user_submits_valid_credentials() throws InterruptedException {
        login.clearEmail();
        login.enterEmail("student@mail.com");
        login.clearPassword();
        login.enterPassword("password");
        login.clickLogin();
    }

    @Then("user should be redirected to the tool list page")
    public void user_redirected_to_list_page() throws InterruptedException {
        tool.getTextMenu();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/dashboard";
        Assertions.assertEquals(expectedUrl, actualUrl);
        closeBrowser();
    }

    @When("user submits invalid credentials")
    public void user_sumbits_invalid_credentials() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        login.clearEmail();
        login.enterEmail("Student");
        login.clearPassword();
        login.enterPassword("password");
        login.clickLogin();
    }

    @Then("user failed to login")
    public void user_failed_to_login() throws InterruptedException {
        login.getTextValidationError();
    }

    @And("user still on the login page")
    public void user_still_on_the_login() {
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "http://localhost:5173/";
        Assertions.assertEquals(expectedUrl, actualUrl);
        closeBrowser();
    }
}
