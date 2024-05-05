package frontend.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class secondPageHappy {
    private static WebDriver driver;
    private static LoginPage loginPage;
    private static TitlesCatalogPage titlesCatalogPage;

    @BeforeAll
    public static void setUp() {
        driver = WebDriverSetup.setUpWebDriver();
        loginPage = new LoginPage(driver);
        titlesCatalogPage = new TitlesCatalogPage(driver);
    }

    @Test
    public void testAddEditRemoveBook() {
        loginPage.open();
        loginPage.login("Tester-Luki", "12345");


        titlesCatalogPage.addBook("Akademia Pana Kleksa", "Jan Brzechwa", "1946");
        Assertions.assertTrue(titlesCatalogPage.isBookAdded("AKADEMIA PANA KLEKSA"));

        titlesCatalogPage.addBook("Podroze Pana Kleksa", "Jan Brzechwa", "1961");
        Assertions.assertTrue(titlesCatalogPage.isBookAdded("PODROZE PANA KLEKSA"));

        titlesCatalogPage.editBookYear("Podroze Pana Kleksa", "1963");
        Assertions.assertTrue(titlesCatalogPage.isBookYearEdited("(1963)"));

        titlesCatalogPage.removeBook("Podroze Pana Kleksa");
        Assertions.assertFalse(titlesCatalogPage.isBookPresent("PODROZE PANA KLEKSA"));
        driver.quit();
    }
}
