package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageHeader {
    private final WebDriver driver;
    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private final By logoStellarBurgers = By.xpath(".//div/a[@href='/']");

    public PageHeader(WebDriver driver) {
        this.driver = driver;
    }

    public By getPersonalAccountButton() {
        return personalAccountButton;
    }

    public By getConstructorButton() {
        return constructorButton;
    }

    public By getLogoStellarBurgers() {
        return logoStellarBurgers;
    }

    @Step("Click on personal account button")
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    @Step("Click on constructor button")
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    @Step("Click on logo Stellar Burgers")
    public void clickOnLogoStellarBurgers() {
        driver.findElement(logoStellarBurgers).click();
    }
}
