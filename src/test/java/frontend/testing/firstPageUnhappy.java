package frontend.testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class firstPageUnhappy {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = WebDriverSetup.setUpWebDriver();
    }


    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testRegistrationWithExistingCredentials() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        RegisterPage registerPage = loginPage.navigateToRegisterPage();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password-repeat")));
        registerPage.registerExistingUserWithoutPassword("Andrzej");
        WebElement registerErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert__content")));
        Assertions.assertTrue(registerErrorMessage.getText().contains("You can't leave fields empty"), "Error message is not as expected");
    }

    @Test
    public void testLoginWithWrongCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.loginWithWrongCredentials("Andrzej", "qwerty");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement loginErrorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert__content")));
        Assertions.assertTrue(loginErrorMessage.getText().contains("Login failed"), "Login failed");
    }

    public class RegisterPage {
        private WebDriver driver;
        private By usernameInput = By.id("login");
        private By registerButton = By.id("register-btn");

        public RegisterPage(WebDriver driver) {
            this.driver = driver;
        }

        public void registerExistingUserWithoutPassword(String username) {
            driver.findElement(usernameInput).sendKeys(username);
            driver.findElement(registerButton).click();
        }
    }

    public class LoginPage {
        private WebDriver driver;
        private By loginInput = By.xpath("/html/body/div/div/form/div[1]/label/input");
        private By passwordInput = By.xpath("/html/body/div/div/form/div[2]/label/input");
        private By loginButton = By.xpath("/html/body/div/div/form/div[3]/button");
        private By registerButton = By.id("register-btn");

        public LoginPage(WebDriver driver) {
            this.driver = driver;
        }

        public void open() {
            driver.get("https://ta-bookrental-fe.onrender.com/login");
        }

        public RegisterPage navigateToRegisterPage() {
            driver.findElement(registerButton).click();
            return new RegisterPage(driver);
        }

        public void loginWithWrongCredentials(String username, String password) {
            driver.findElement(loginInput).sendKeys(username);
            driver.findElement(passwordInput).sendKeys(password);
            driver.findElement(loginButton).click();
        }
    }
}