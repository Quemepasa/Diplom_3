import org.junit.Rule;
import org.junit.Test;
import pom.MainPage;
import pom.LoginPage;
import pom.PasswordRecoveryPage;
import pom.RegistrationPage;
import rules.BrowserRule;

import static org.junit.Assert.assertTrue;

public class UserLoginTests {
    @Rule
    public final BrowserRule browserRule = new BrowserRule();

    @Test
    public void loginUserFromMainPage() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        LoginPage loginPage = new LoginPage(browserRule.getWebDriver());

        mainPage
                .open()
                .waitForLoadMainPage()
                .clickLoginButton();

        loginPage
                .waitForLoadLoginPage()
                .loginUser("vvvv@yandex.ru", "password");

        boolean actualResult = mainPage
                .waitForLoadMainPage()
                .checkCheckoutButtonIsDisplayed();

        assertTrue("The user is not logged in, the checkout button should be displayed", actualResult);
    }

    @Test
    public void loginUserFromLoginPage() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());
        LoginPage loginPage = new LoginPage(browserRule.getWebDriver());

        loginPage
                .open()
                .waitForLoadLoginPage()
                .loginUser("vvvv@yandex.ru", "password");

        boolean actualResult = mainPage
                .waitForLoadMainPage()
                .checkCheckoutButtonIsDisplayed();

        assertTrue("The user is not logged in, the checkout button should be displayed", actualResult);
    }

    @Test
    public void loginUserFromRegistrationPage() {
        RegistrationPage registrationPage = new RegistrationPage(browserRule.getWebDriver());
        LoginPage loginPage = new LoginPage(browserRule.getWebDriver());
        MainPage mainPage = new MainPage(browserRule.getWebDriver());

        registrationPage
                .open()
                .waitForLoadRegistrationPage()
                .clickLoginButton();

        loginPage
                .waitForLoadLoginPage()
                .loginUser("vvvv@yandex.ru", "password");

        boolean actualResult = mainPage
                .waitForLoadMainPage()
                .checkCheckoutButtonIsDisplayed();

        assertTrue("The user is not logged in, the checkout button should be displayed", actualResult);
    }

    @Test
    public void loginUserFromPasswordRecoveryPage() {
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(browserRule.getWebDriver());
        LoginPage loginPage = new LoginPage(browserRule.getWebDriver());
        MainPage mainPage = new MainPage(browserRule.getWebDriver());

        passwordRecoveryPage
                .open()
                .clickLoginButton();

        loginPage
                .waitForLoadLoginPage()
                .loginUser("vvvv@yandex.ru", "password");

        boolean actualResult = mainPage
                .waitForLoadMainPage()
                .checkCheckoutButtonIsDisplayed();

        assertTrue("The user is not logged in, the checkout button should be displayed", actualResult);
    }
}
