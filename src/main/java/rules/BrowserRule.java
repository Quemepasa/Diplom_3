package rules;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;

import static driver.WebDriverCreator.*;

public class BrowserRule extends ExternalResource {
    private WebDriver driver;

    @Override
    protected void before() {
        driver = createWebDriver();
    }

    @Override
    protected void after() {
        driver.quit();
    }

    public WebDriver getWebDriver() {
        return driver;
    }
}
