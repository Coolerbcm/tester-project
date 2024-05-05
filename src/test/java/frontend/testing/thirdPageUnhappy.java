package frontend.testing;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class thirdPageUnhappy {
    private static WebDriver driver;
    private static LoginPage loginPage;
    private static ListOfCopiesPage listOfCopiesPage;

    @BeforeAll
    public static void setUp() {
        driver = WebDriverSetup.setUpWebDriver();
        listOfCopiesPage = new ListOfCopiesPage(driver);
        loginPage = new LoginPage(driver);
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
        Assertions.assertEquals("TITLES CATALOG", listOfCopiesPage.getPageTitle());
    }
    @Test
    @Order(2)
    public void verifyEnterToListOfCopies() {
        Assertions.assertEquals("LIST OF COPIES", listOfCopiesPage.clickOnCopyDetailsButton());
    }
    @Test
    @Order(3)
    public void verifyErrorMessageWhenRemovingCopyWithRentHistory() {
        listOfCopiesPage.clickRemoveCopyButton();
        Assertions.assertEquals("You can't remove copy with the rents history!", listOfCopiesPage.getErrorMessage());
    }
}
