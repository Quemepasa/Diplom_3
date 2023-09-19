package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.Urls.MAIN_PAGE_URI;

public class MainPage {
    private final WebDriver driver;

    private final By mainHeading = By.xpath(".//h1[text()='Соберите бургер']");
    private final By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");

    private final By checkoutButton = By.xpath(".//button[text()='Оформить заказ']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getMainHeading() {
        return mainHeading;
    }

    public By getLoginButton() {
        return loginButton;
    }

    public By getCheckoutButton() {
        return checkoutButton;
    }

    public MainPage open() {
        driver.get(MAIN_PAGE_URI);
        return this;
    }

    public MainPage waitForLoadMainPage() {
        new WebDriverWait(driver, 8)
                .until(ExpectedConditions.visibilityOfElementLocated(mainHeading));
        return this;
    }

    public Boolean checkCheckoutButtonIsDisplayed() {
        return driver.findElement(mainHeading).isDisplayed();
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
