import org.junit.Rule;
import org.junit.Test;
import pom.LoginPage;
import pom.RegistrationPage;
import rules.BrowserRule;

import static org.junit.Assert.assertEquals;

public class UserRegistrationTests {
    @Rule
    public final BrowserRule browserRule = new BrowserRule();

    @Test
    public void registerUser() {
        RegistrationPage registrationPage = new RegistrationPage(browserRule.getWebDriver());
        LoginPage loginPage = new LoginPage(browserRule.getWebDriver());

        registrationPage
                .open()
                .waitForLoadRegistrationPage()
                .registerUser("vvv", "vvvv@vvv.vvv", "vvvvvv");

        String actualResult = loginPage
                .waitForLoadLoginPage()
                .getLoginHeadingText();

        assertEquals("The user is not registered, must be on the login page",
                "Вход", actualResult);
    }

    @Test
    public void checkPasswordErrorMessage() {
        RegistrationPage registrationPage = new RegistrationPage(browserRule.getWebDriver());

        String actualResult = registrationPage
                .open()
                .waitForLoadRegistrationPage()
                .inputUserPassword("vvv")
                .getPasswordErrorMessageText();

        assertEquals("No error message was displayed",
                "Некорректный пароль", actualResult);
    }
}
