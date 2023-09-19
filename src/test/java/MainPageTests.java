import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import pom.MainPage;
import rules.BrowserRule;

import static org.junit.Assert.assertTrue;

public class MainPageTests {
    @Rule
    public final BrowserRule browserRule = new BrowserRule();

    @DisplayName("Check switching to buns section")
    @Test
    public void checkSwitchingToBunsSection() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());

        boolean actualResult = mainPage
                .open()
                .clickTabFillings()
                .clickTabBuns()
                .checkSectionBunsIsDisplayed();

        assertTrue("The buns section is not selected", actualResult);
    }

    @DisplayName("Check switching to sauces section")
    @Test
    public void checkSwitchingToSaucesSection() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());

        boolean actualResult = mainPage
                .open()
                .clickTabSauces()
                .checkSectionSaucesIsDisplayed();

        assertTrue("The sauces section is not selected", actualResult);
    }

    @DisplayName("Check switching to fillings section")
    @Test
    public void checkSwitchingToFillingsSection() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());

        boolean actualResult = mainPage
                .open()
                .clickTabFillings()
                .checkSectionFillingsIsDisplayed();

        assertTrue("The fillings section is not selected", actualResult);

    }
}