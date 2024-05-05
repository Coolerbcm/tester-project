package frontend.testing;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class firstPageHappy {

    private static WebDriver driver;
    private static LoginPage loginPage;

    @BeforeAll
    public static void setUp() {
        driver = WebDriverSetup.setUpWebDriver();
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testRegisterNewUser() throws InterruptedException {
        loginPage.open();
        RegisterPage registerPage = loginPage.navigateToRegisterPage();
        Thread.sleep(2000);
        registerPage.registerNewUser("Tester-Luki", "12345");
    }

    @Test
    public void testLoginWithCreatedUser() throws InterruptedException {
        loginPage.open();
        loginPage.login("Tester-Luki", "12345");
        Thread.sleep(2000);
        Assertions.assertTrue(loginPage.isFirstPageTitlesCatalogDisplayed());
    }
}
