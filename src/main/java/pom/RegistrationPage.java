package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.Urls.REGISTRATION_PAGE_URL;

public class RegistrationPage {
    private final WebDriver driver;
    private final By registrationHeading = By.xpath(".//h2[text()='Регистрация']");
    private final By nameField = By.xpath(".//fieldset[1]//input[@name='name']");
    private final By emailField = By.xpath(".//fieldset[2]//input[@name='name']");
    private final By passwordField = By.xpath(".//input[@type='password']");
    private final By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By loginButton = By.xpath(".//a[text()='Войти']");
    private final By passwordErrorMessage = By.xpath(".//p[text()='Некорректный пароль']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getRegistrationHeading() {
        return registrationHeading;
    }

    public By getNameField() {
        return nameField;
    }

    public By getEmailField() {
        return emailField;
    }

    public By getPasswordField() {
        return passwordField;
    }

    public By getRegistrationButton() {
        return registrationButton;
    }

    public By getPasswordErrorMessage() {
        return passwordErrorMessage;
    }

    public By getLoginButton() {
        return loginButton;
    }

    public RegistrationPage open() {
        driver.get(REGISTRATION_PAGE_URL);
        return this;
    }

    public RegistrationPage waitForLoadRegistrationPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(registrationHeading));
        return this;
    }

    public void inputUsername(String username) {
        driver.findElement(nameField).sendKeys(username);
    }

    public void inputUserEmail(String userEmail) {
        driver.findElement(emailField).sendKeys(userEmail);
    }

    public RegistrationPage inputUserPassword(String userPassword) {
        driver.findElement(passwordField).sendKeys(userPassword);
        return this;
    }

    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String getPasswordErrorMessageText() {
        return driver.findElement(passwordErrorMessage).getText();
    }

    @Step("Register user")
    public void registerUser(String username, String userEmail, String userPassword) {
        inputUsername(username);
        inputUserEmail(userEmail);
        inputUserPassword(userPassword);
        clickRegistrationButton();
    }
}
