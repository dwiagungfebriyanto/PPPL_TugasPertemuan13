package pages;

import object.ToolObject;
import org.openqa.selenium.WebDriver;

public class ToolPage extends BasePage {
    ToolObject tool;

    public ToolPage(WebDriver driver) {
        super(driver);
        this.tool = new ToolObject(driver);
    }

    public void getTextMenu() throws InterruptedException {
        verifyElementVisible(tool.getTextMenu());
    }
}
