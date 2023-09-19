package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountPage {
    private final WebDriver driver;

    private final By logoutButton = By.xpath(".//button[text()='Выход']");

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click on logout button")
    public void clickLogoutButton() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
        driver.findElement(logoutButton).click();
    }
}
