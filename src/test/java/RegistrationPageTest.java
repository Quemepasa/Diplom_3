import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import pom.RegistrationPage;
import rules.BrowserRule;

import static org.junit.Assert.assertTrue;
import static utils.Utils.randomString;

public class RegistrationPageTest {
    @Rule
    public final BrowserRule browserRule = new BrowserRule();

    @DisplayName("Check password error message")
    @Test
    public void checkPasswordErrorMessage() {
        RegistrationPage registrationPage = new RegistrationPage(browserRule.getWebDriver());

        boolean actualResult = registrationPage
                .open()
                .inputUserPassword(randomString(5))
                .clickRegistrationButton()
                .checkPasswordErrorMessageIsDisplayed();

        assertTrue("Password error message is not displayed", actualResult);
    }
}
