package frontend.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class fourthPageHappy {
    private static WebDriver driver;
    private static LoginPage loginPage;
    private static RentsHistoryPage rentsHistoryPage;

    @BeforeAll
    public static void setUp() {
        driver = WebDriverSetup.setUpWebDriver();
        loginPage = new LoginPage(driver);
        rentsHistoryPage = new RentsHistoryPage(driver);
    }

    @Test
    public void editRentBook() throws InterruptedException {
        loginPage.open();

        loginPage.login("Tester-Luki", "12345");
        rentsHistoryPage.navigateToBookList();

        rentsHistoryPage.rentBook("Lukasz");

        Assertions.assertEquals("LUKASZ", rentsHistoryPage.getFirstBookRent());
        rentsHistoryPage.returnBook();

        Assertions.assertTrue(rentsHistoryPage.isReturnButtonPresent(), "Element should not exist");
        rentsHistoryPage.rentBook("Andrzej");

        Assertions.assertEquals("ANDRZEJ", rentsHistoryPage.getFirstBookRent());
        rentsHistoryPage.editRent();

        Assertions.assertEquals("(expiration: 2024-03-27)", rentsHistoryPage.getEditedBookRent());
        driver.quit();
    }
}
