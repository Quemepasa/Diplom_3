import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pom.LoginPage;
import pom.RegistrationPage;
import user.UserActions;
import user.models.CreateUserRequest;
import user.models.LoginUserRequest;
import user.models.UserSuccessResponse;

import static driver.WebDriverCreator.createWebDriver;
import static org.junit.Assert.assertEquals;
import static user.UserGenerator.randomUser;

public class UserRegistrationTest {
    private WebDriver driver;
    private CreateUserRequest createUserRequest;

    @Before
    public void setUp() {
        driver = createWebDriver();
        createUserRequest = randomUser();
    }

    @DisplayName("Register user with all required fields")
    @Test
    public void registerUserWithAllRequiredFields() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        registrationPage
                .open()
                .waitForLoadRegistrationPage()
                .registerUser(createUserRequest.getEmail(), createUserRequest.getEmail(), createUserRequest.getPassword());

        String actualResult = loginPage
                .waitForLoadLoginPage()
                .getLoginHeadingText();

        assertEquals("The user is not registered, must be on the login page",
                "Вход", actualResult);
    }

    @After
    public void tearDown() {
        UserActions userActions = new UserActions();
        LoginUserRequest loginUserRequest = new LoginUserRequest(createUserRequest.getEmail(), createUserRequest.getPassword());
        Response response = userActions.login(loginUserRequest);
        UserSuccessResponse userSuccessResponse = response.as(UserSuccessResponse.class);
        userActions.deleteUser(userSuccessResponse, createUserRequest);

        driver.quit();
    }
}
