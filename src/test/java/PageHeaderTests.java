import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import pom.LoginPage;
import pom.MainPage;
import pom.PageHeader;
import rules.BrowserRule;

import static org.junit.Assert.assertTrue;

public class PageHeaderTests {
    @Rule
    public final BrowserRule browserRule = new BrowserRule();

    @DisplayName("Check click on personal account button")
    @Test
    public void checkClickOnPersonalAccountButton() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        PageHeader pageHeader = new PageHeader(browserRule.getWebDriver());
        LoginPage loginPage = new LoginPage(browserRule.getWebDriver());

        mainPage.open();

        pageHeader.clickPersonalAccountButton();

        boolean actualResult = loginPage
                .waitForLoadLoginPage()
                .checkLoginHeadingTextIsDisplayed();

        assertTrue("The user is not on login page", actualResult);
    }

    @DisplayName("Check click on constructor button")
    @Test
    public void checkClickConstructorButton() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        LoginPage loginPage = new LoginPage(browserRule.getWebDriver());
        PageHeader pageHeader = new PageHeader(browserRule.getWebDriver());

        loginPage.open();

        pageHeader.clickConstructorButton();

        boolean actualResult = mainPage
                .waitForLoadMainPage()
                .checkMainHeadingIsDisplayed();

        assertTrue("The user is not on constructor page", actualResult);
    }

    @DisplayName("Check click on logo Stellar Burgers")
    @Test
    public void checkClickLogoStellarBurgers() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        LoginPage loginPage = new LoginPage(browserRule.getWebDriver());
        PageHeader pageHeader = new PageHeader(browserRule.getWebDriver());

        loginPage.open();

        pageHeader.clickOnLogoStellarBurgers();

        boolean actualResult = mainPage
                .waitForLoadMainPage()
                .checkMainHeadingIsDisplayed();

        assertTrue("The user is not on constructor page", actualResult);
    }
}
