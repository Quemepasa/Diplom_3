package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageHeader {
    private final WebDriver driver;
    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");

    public PageHeader(WebDriver driver) {
        this.driver = driver;
    }

    public By getPersonalAccountButton() {
        return personalAccountButton;
    }

    public By getConstructorButton() {
        return constructorButton;
    }

    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }
}
