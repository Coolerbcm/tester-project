package frontend.testing;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class secondPageUnhappy {
    private static WebDriver driver;
    private static TitlesCatalogPage titlesCatalogPage;
    private static LoginPage loginPage;

    @BeforeAll
    public static void setUp() {
        driver = WebDriverSetup.setUpWebDriver();
        loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("Tester-Luki", "12345");
        titlesCatalogPage = new TitlesCatalogPage(driver);
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
        Assertions.assertEquals("TITLES CATALOG", secondPageUnhappy.titlesCatalogPage.getPageTitle());
    }
    @Test
    @Order(2)
    public void verifyCannotRemoveTitleWithCopies() {
        secondPageUnhappy.titlesCatalogPage.removeTitleWithCopies();
        Assertions.assertEquals("You can't remove titles with copies!", secondPageUnhappy.titlesCatalogPage.getRemoveErrorText());
    }
    @Test
    @Order(3)
    public void verifyTitleCannotBeEmpty() throws InterruptedException {
        secondPageUnhappy.titlesCatalogPage.addNewTitle("", "Podroze Pana Kleksa", "1963");
        Assertions.assertEquals("\"title\" field shouldn't be empty...", secondPageUnhappy.titlesCatalogPage.getAddErrorText());
    }
    @Test
    @Order(4)
    public void verifyAuthorCannotBeEmpty() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div/div/div/div/a")).click();
        secondPageUnhappy.titlesCatalogPage.addNewTitle("Podroze Pana Kleksa", "", "1963");
        Assertions.assertEquals("\"author\" field shouldn't be empty...", secondPageUnhappy.titlesCatalogPage.getAddErrorText());
    }
    @Test
    @Order(5)
    public void verifyYearCannotBeEmpty() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div/div/div/div/a")).click();
        secondPageUnhappy.titlesCatalogPage.addNewTitle("Podroze Pana Kleksa", "Podroze Pana Kleksa", "");
        Assertions.assertEquals("\"year\" field shouldn't be empty...", secondPageUnhappy.titlesCatalogPage.getAddErrorText());
    }
}
