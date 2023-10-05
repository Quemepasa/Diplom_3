package pom;

import io.qameta.allure.Step;
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
    private final By tabBuns = By.xpath(".//span[text()='Булки']/parent::div");
    private final By tabSauces = By.xpath(".//span[text()='Соусы']/parent::div");
    private final By tabFillings = By.xpath(".//span[text()='Начинки']/parent::div");

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

    public By getTabBuns() {
        return tabBuns;
    }

    public By getTabSauces() {
        return tabSauces;
    }

    public By getTabFillings() {
        return tabFillings;
    }


    @Step("Open main page")
    public MainPage open() {
        driver.get(MAIN_PAGE_URI);
        return this;
    }

    public MainPage waitForLoadMainPage() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(mainHeading));
        return this;
    }

    public boolean checkMainHeadingIsDisplayed() {
        return driver.findElement(mainHeading).isDisplayed();
    }

    public Boolean checkCheckoutButtonIsDisplayed() {
        return driver.findElement(mainHeading).isDisplayed();
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Click on buns tab")
    public MainPage clickTabBuns() {
        driver.findElement(tabBuns).click();
        return this;
    }

    @Step("Click on sauces tab")
    public MainPage clickTabSauces() {
        driver.findElement(tabSauces).click();
        return this;
    }

    @Step("Click on fillings tab")
    public MainPage clickTabFillings() {
        driver.findElement(tabFillings).click();
        return this;
    }

    public String checkBunsSectionIsSelected() {
        return driver.findElement(tabBuns).getAttribute("class");
    }

    public String checkSaucesSectionIsSelected() {
        return driver.findElement(tabSauces).getAttribute("class");
    }

    public String checkFillingsSectionIsSelected() {
        return driver.findElement(tabFillings).getAttribute("class");
    }
}
