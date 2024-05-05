package frontend.testing;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class fourthPageUnhappy {
    private static WebDriver driver;
    private static RentsHistoryPage rentsHistoryPage;

    @BeforeAll
    public static void setUp() {
        driver = WebDriverSetup.setUpWebDriver();
        LoginPage loginPage = new LoginPage(driver);
        rentsHistoryPage = new RentsHistoryPage(driver);
        loginPage.open();
        loginPage.login("Tester-Luki", "12345");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @Order(1)
    public void verifySuccessfulLogin() {
        Assertions.assertEquals("TITLES CATALOG", rentsHistoryPage.getPageTitle());
    }

    @Test
    @Order(2)
    public void verifyEnterToListOfCopies() {
        Assertions.assertEquals("RENTS HISTORY", rentsHistoryPage.clickOnShowHistoryButton());
    }

    @Test
    @Order(3)
    public void verifyErrorMessageWhenRemovingCopyWithRentHistory() {
        rentsHistoryPage.clickRentThisCopyAndAddCopyButton();
        Assertions.assertEquals("\"customerName\" field shouldn't be empty...", rentsHistoryPage.getErrorMessage());
    }
}