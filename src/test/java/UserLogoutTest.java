import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pom.LoginPage;
import pom.PageHeader;
import pom.PersonalAccountPage;
import user.UserApi;
import user.models.CreateUserRequest;
import user.models.UserSuccessResponse;

import static driver.WebDriverCreator.createWebDriver;
import static org.junit.Assert.assertTrue;
import static user.UserGenerator.randomUser;

public class UserLogoutTest {
    private UserApi userApi;
    private UserSuccessResponse userSuccessResponse;
    private WebDriver driver;
    private CreateUserRequest createUserRequest;

    @Before
    public void setUp() {
        driver = createWebDriver();
        createUserRequest = randomUser();
        userApi = new UserApi();
        Response response = userApi.createUser(createUserRequest);
        userSuccessResponse = response.as(UserSuccessResponse.class);
    }

    @DisplayName("Check that user logout")
    @Test
    public void checkUserLogout() {
        LoginPage loginPage = new LoginPage(driver);
        PageHeader pageHeader = new PageHeader(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);

        loginPage.open()
                .loginUser(createUserRequest.getEmail(), createUserRequest.getPassword());

        pageHeader.clickPersonalAccountButton();

        personalAccountPage.clickLogoutButton();

        boolean actualResult = loginPage
                .waitForLoadLoginPage()
                .checkLoginHeadingTextIsDisplayed();

        assertTrue("The user is not logged out", actualResult);
    }

    @After
    public void tearDown() {
         driver.quit();
         userApi.deleteUser(userSuccessResponse, createUserRequest);
    }
}
