package pages;

import object.LoginObject;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    LoginObject login;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.login = new LoginObject(driver);
    }

    public void clearEmail() throws InterruptedException {
        clearText(login.getInputEmail());
    }

    public void clearPassword() throws InterruptedException {
        clearText(login.getInputPassword());
    }

    public void enterEmail(String email) throws InterruptedException {
        inputText(login.getInputEmail(), email);
    }

    public void enterPassword(String password) throws InterruptedException {
        inputText(login.getInputPassword(), password);
    }

    public void clickLogin() throws InterruptedException {
        click(login.getLoginBtn());
    }

    public void getTextValidationError() throws InterruptedException {
        verifyElementVisible(login.getTextValidationError());
    }
}
