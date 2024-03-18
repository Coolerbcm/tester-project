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

public class firstPageHappy {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\selenium-drivers\\Chrome\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testRegisterNewUser() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        RegisterPage registerPage = loginPage.navigateToRegisterPage();
        Thread.sleep(2000);
        registerPage.registerNewUser("Tester-Luki", "12345");
    }

    @Test
    public void testLoginWithCreatedUser() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("Tester-Luki", "12345");
        Thread.sleep(2000);
        Assertions.assertTrue(loginPage.isFirstPageTitlesCatalogDisplayed());
    }

    public class LoginPage {
        private WebDriver driver;
        private By loginInput = By.id("login");
        private By passwordInput = By.id("password");
        private By loginButton = By.id("login-btn");
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

        public void login(String username, String password) {
            driver.findElement(loginInput).sendKeys(username);
            driver.findElement(passwordInput).sendKeys(password);
            driver.findElement(loginButton).click();
        }

        public boolean isFirstPageTitlesCatalogDisplayed() {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement firstPageTitlesCatalog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/h2")));
            return firstPageTitlesCatalog.isDisplayed() && firstPageTitlesCatalog.getText().equals("TITLES CATALOG");
        }
    }

    public class RegisterPage {
        private WebDriver driver;
        private By loginInput = By.id("login");
        private By passwordInput = By.id("password");
        private By repeatPasswordInput = By.id("password-repeat");
        private By registerButton = By.id("register-btn");

        public RegisterPage(WebDriver driver) {
            this.driver = driver;
        }

        public void registerNewUser(String username, String password) {
            driver.findElement(loginInput).sendKeys(username);
            driver.findElement(passwordInput).sendKeys(password);
            driver.findElement(repeatPasswordInput).sendKeys(password);
            driver.findElement(registerButton).click();
        }
    }
}

