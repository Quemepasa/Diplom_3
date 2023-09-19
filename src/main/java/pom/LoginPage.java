package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver driver;

    private final By loginHeading = By.xpath(".//h2[text()='Вход']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getLoginHeading() {
        return loginHeading;
    }

    public LoginPage waitForLoadLoginPage() {
        new WebDriverWait(driver, 8)
                .until(ExpectedConditions.visibilityOfElementLocated(loginHeading));
        return this;
    }

    public String getLoginHeadingText() {
        return driver.findElement(loginHeading).getText();
    }
}
