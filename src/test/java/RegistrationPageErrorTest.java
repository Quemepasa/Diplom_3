import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import pom.RegistrationPage;
import rules.BrowserRule;

import static constants.utils.Utils.randomString;
import static org.junit.Assert.assertEquals;

public class RegistrationPageErrorTest {
    @Rule
    public final BrowserRule browserRule = new BrowserRule();

    @DisplayName("Check password error message")
    @Test
    public void checkPasswordErrorMessage() {
        RegistrationPage registrationPage = new RegistrationPage(browserRule.getWebDriver());

        registrationPage
                .open()
                .waitForLoadRegistrationPage()
                .inputUserPassword(randomString(5))
                .clickRegistrationButton();
        String actualResult = registrationPage.getPasswordErrorMessageText();

        assertEquals("No error message was displayed",
                "Некорректный пароль", actualResult);
    }
}
