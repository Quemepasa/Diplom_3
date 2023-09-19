package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.Urls.LOGIN_PAGE_URL;

public class LoginPage {
    private final WebDriver driver;

    private final By loginHeading = By.xpath(".//h2[text()='Вход']");
    private final By emailField = By.xpath(".//input[@name='name']");
    private final By passwordField = By.xpath(".//input[@type='password']");
    private final By loginButton = By.xpath(".//button[text()='Войти']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getLoginHeading() {
        return loginHeading;
    }

    public By getEmailField() {
        return emailField;
    }

    public By getPasswordField() {
        return passwordField;
    }

    public By getLoginButton() {
        return loginButton;
    }

    public LoginPage open() {
        driver.get(LOGIN_PAGE_URL);
        return this;
    }

    public LoginPage waitForLoadLoginPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(loginHeading));
        return this;
    }

    public String getLoginHeadingText() {
        return driver.findElement(loginHeading).getText();
    }

    public void inputUserEmail(String userEmail) {
        driver.findElement(emailField).sendKeys(userEmail);
    }

    public void inputUserPassword(String userPassword) {
        driver.findElement(passwordField).sendKeys(userPassword);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Login user")
    public void loginUser(String userEmail, String userPassword){
        inputUserEmail(userEmail);
        inputUserPassword(userPassword);
        clickLoginButton();
    }
}
