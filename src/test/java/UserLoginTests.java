import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pom.*;
import user.UserApi;
import user.models.CreateUserRequest;
import user.models.UserSuccessResponse;

import static driver.WebDriverCreator.createWebDriver;
import static org.junit.Assert.assertTrue;
import static user.UserGenerator.randomUser;

public class UserLoginTests {
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

    @DisplayName("Check user's login from main page")
    @Test
    public void checkLoginUserFromMainPage() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage
                .open()
                .waitForLoadMainPage()
                .clickLoginButton();

        loginPage
                .waitForLoadLoginPage()
                .loginUser(createUserRequest.getEmail(), createUserRequest.getPassword());

        boolean actualResult = mainPage
                .waitForLoadMainPage()
                .checkCheckoutButtonIsDisplayed();

        assertTrue("The user is not logged in, checkout button should be displayed", actualResult);
    }

    @DisplayName("Check user's login using personal account button")
    @Test
    public void loginUserFromLoginPage() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        PageHeader pageHeader = new PageHeader(driver);

        mainPage.open();

        pageHeader.clickPersonalAccountButton();

        loginPage.loginUser(createUserRequest.getEmail(), createUserRequest.getPassword());

        boolean actualResult = mainPage
                .waitForLoadMainPage()
                .checkCheckoutButtonIsDisplayed();

        assertTrue("The user is not logged in, checkout button should be displayed", actualResult);
    }

    @DisplayName("Check user's login from registration page")
    @Test
    public void checkLoginUserFromRegistrationPage() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);

        registrationPage
                .open()
                .clickLoginButton();

        loginPage.loginUser(createUserRequest.getEmail(), createUserRequest.getPassword());

        boolean actualResult = mainPage
                .waitForLoadMainPage()
                .checkCheckoutButtonIsDisplayed();

        assertTrue("The user is not logged in, checkout button should be displayed", actualResult);
    }

    @DisplayName("Check user's login from password recovery page")
    @Test
    public void checkLoginUserFromPasswordRecoveryPage() {
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);

        passwordRecoveryPage
                .open()
                .clickLoginButton();

        loginPage
                .waitForLoadLoginPage()
                .loginUser(createUserRequest.getEmail(), createUserRequest.getPassword());

        boolean actualResult = mainPage
                .waitForLoadMainPage()
                .checkCheckoutButtonIsDisplayed();

        assertTrue("The user is not logged in, checkout button should be displayed", actualResult);
    }

    @After
    public void tearDown() {
        driver.quit();
        userApi.deleteUser(userSuccessResponse, createUserRequest);
    }
}
