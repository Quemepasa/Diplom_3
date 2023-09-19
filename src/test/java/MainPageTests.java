import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import pom.LoginPage;
import pom.MainPage;
import pom.PageHeader;
import rules.BrowserRule;

import static org.junit.Assert.assertEquals;

public class MainPageTests {
    @Rule
    public final BrowserRule browserRule = new BrowserRule();

    @DisplayName("Check the click on the personal account button")
    @Test
    public void checkClickOnPersonalAccountButton() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        PageHeader pageHeader = new PageHeader(browserRule.getWebDriver());
        LoginPage loginPage = new LoginPage(browserRule.getWebDriver());

        mainPage
                .open()
                .waitForLoadMainPage();

        pageHeader.clickPersonalAccountButton();

        String actualResult = loginPage
                .waitForLoadLoginPage()
                .getLoginHeadingText();

        assertEquals("No error message was displayed",
                "Вход", actualResult);
    }

    @DisplayName("Check the click on the constructor button")
    @Test
    public void checkClickConstructorButton() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        LoginPage loginPage = new LoginPage(browserRule.getWebDriver());
        PageHeader pageHeader = new PageHeader(browserRule.getWebDriver());

        loginPage
                .open()
                .waitForLoadLoginPage();

        pageHeader.clickConstructorButton();

        String actualResult = mainPage
                .waitForLoadMainPage()
                .getMainHeadingText();

        assertEquals("No error message was displayed",
                "Соберите бургер", actualResult);
    }
}
