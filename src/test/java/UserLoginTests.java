import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pom.MainPage;
import pom.LoginPage;
import pom.PasswordRecoveryPage;
import pom.RegistrationPage;
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

    @DisplayName("Check login user from main page")
    @Test
    public void loginUserFromMainPage() {
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

        assertTrue("The user is not logged in, the checkout button should be displayed", actualResult);
    }

    @DisplayName("Check login user from login page")
    @Test
    public void loginUserFromLoginPage() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        loginPage
                .open()
                .waitForLoadLoginPage()
                .loginUser(createUserRequest.getEmail(), createUserRequest.getPassword());

        boolean actualResult = mainPage
                .waitForLoadMainPage()
                .checkCheckoutButtonIsDisplayed();

        assertTrue("The user is not logged in, the checkout button should be displayed", actualResult);
    }

    @DisplayName("Check login user from registration page")
    @Test
    public void checkLoginUserFromRegistrationPage() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);

        registrationPage
                .open()
                .waitForLoadRegistrationPage()
                .clickLoginButton();

        loginPage
                .waitForLoadLoginPage()
                .loginUser(createUserRequest.getEmail(), createUserRequest.getPassword());

        boolean actualResult = mainPage
                .waitForLoadMainPage()
                .checkCheckoutButtonIsDisplayed();

        assertTrue("The user is not logged in, the checkout button should be displayed", actualResult);
    }

    @DisplayName("Check login user from password recovery page")
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

        assertTrue("The user is not logged in, the checkout button should be displayed", actualResult);
    }

    @After
    public void tearDown() {
        driver.quit();
        userApi.deleteUser(userSuccessResponse, createUserRequest);
    }
}
