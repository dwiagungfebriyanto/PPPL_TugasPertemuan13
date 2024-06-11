package object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ToolObject {
    WebDriver driver;

    public ToolObject(WebDriver driver) {
        this.driver = driver;
    }

    public By getTextMenu() {
        return By.xpath("//*[contains(text(), 'Menu')]");
    }
}
