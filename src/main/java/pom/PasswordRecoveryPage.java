package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.Urls.PASSWORD_RECOVERY_PAGE_URL;

public class PasswordRecoveryPage {
    private final WebDriver driver;

    private final By passwordRecoveryHeading = By.xpath(".//h2[text()='Восстановление пароля']");
    private final By loginButton = By.xpath(".//a[text()='Войти']");

    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getPasswordRecoveryHeading() {
        return passwordRecoveryHeading;
    }

    public By getLoginButton() {
        return loginButton;
    }

    public PasswordRecoveryPage open() {
        driver.get(PASSWORD_RECOVERY_PAGE_URL);
        return this;
    }

    public PasswordRecoveryPage waitForLoadPasswordRecoveryPage() {
        new WebDriverWait(driver, 8)
                .until(ExpectedConditions.visibilityOfElementLocated(passwordRecoveryHeading));
        return this;
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

}
