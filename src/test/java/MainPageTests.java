import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import pom.MainPage;
import rules.BrowserRule;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainPageTests {
    private final static String CURRENTLY_SELECTED_TAB = "tab_tab_type_current";

    @Rule
    public final BrowserRule browserRule = new BrowserRule();

    @DisplayName("Check switching to buns section")
    @Test
    public void checkSwitchingToBunsSection() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());

        String actualResult = mainPage
                .open()
                .clickTabFillings()
                .clickTabBuns()
                .checkBunsSectionIsSelected();

        assertThat("The buns section is not selected", actualResult, containsString(CURRENTLY_SELECTED_TAB));
    }

    @DisplayName("Check switching to sauces section")
    @Test
    public void checkSwitchingToSaucesSection() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());

        String actualResult = mainPage
                .open()
                .clickTabSauces()
                .checkSaucesSectionIsSelected();

        assertThat("The sauces section is not selected", actualResult, containsString(CURRENTLY_SELECTED_TAB));
    }

    @DisplayName("Check switching to fillings section")
    @Test
    public void checkSwitchingToFillingsSection() {
        MainPage mainPage = new MainPage(browserRule.getWebDriver());

        String actualResult = mainPage
                .open()
                .clickTabFillings()
                .checkFillingsSectionIsSelected();

        assertThat("The fillings section is not selected", actualResult, containsString(CURRENTLY_SELECTED_TAB));
    }
}