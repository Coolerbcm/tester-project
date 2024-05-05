package frontend.testing;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class firstPageUnhappy {

    private static WebDriver driver;
    private static LoginPage loginPage;
    private static WebDriverWait wait;

    @BeforeAll
    public static void setUp() {
        driver = WebDriverSetup.setUpWebDriver();
        loginPage = new LoginPage(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testRegistrationWithExistingCredentials() {
        loginPage.open();
        RegisterPage registerPage = loginPage.navigateToRegisterPage();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password-repeat")));
        registerPage.registerNewUser("Andrzej", "");
        WebElement registerErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert__content")));
        Assertions.assertTrue(registerErrorMessage.getText().contains("You can't leave fields empty"), "Error message is not as expected");
    }

    @Test
    public void testLoginWithWrongCredentials() {
        loginPage.open();
        loginPage.login("Andrzej", "qwerty");
        WebElement loginErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert__content")));
        Assertions.assertTrue(loginErrorMessage.getText().contains("Login failed"), "Login failed");
    }
}