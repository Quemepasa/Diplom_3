import org.junit.Rule;
import org.junit.Test;
import pom.LoginPage;
import pom.RegistrationPage;
import rules.BrowserRule;

import static org.junit.Assert.assertEquals;

public class UserRegistration {
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

        loginPage.waitForLoadLoginPage();
        String actualResult = loginPage.getLoginHeadingText();

        assertEquals("Invalid heading text of the login page",
                "Вход", actualResult);
    }

    @Test
    public void checkPasswordErrorMessage() {
        RegistrationPage registrationPage = new RegistrationPage(browserRule.getWebDriver());

        registrationPage
                .open()
                .waitForLoadRegistrationPage()
                .inputUserPasswordInPasswordField("vvv");
        String actualResult = registrationPage.getPasswordErrorMessageText();

        assertEquals("No error message was displayed",
                "Некорректный пароль", actualResult);
    }
}
