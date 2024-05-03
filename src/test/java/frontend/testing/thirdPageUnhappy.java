package frontend.testing;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class thirdPageUnhappy {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = WebDriverSetup.setUpWebDriver();
        firstPageHappy.LoginPage loginPage = new firstPageHappy.LoginPage(driver);
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
        CatalogPage catalogPage = new CatalogPage(driver);
        Assertions.assertEquals("TITLES CATALOG", catalogPage.getPageTitle());
    }

    @Test
    @Order(2)
    public void verifyEnterToListOfCopies() {
        CatalogPage catalogPage = new CatalogPage(driver);
        Assertions.assertEquals("LIST OF COPIES", catalogPage.clickOnCopyDetailsButton());
    }

    @Test
    @Order(3)
    public void verifyErrorMessageWhenRemovingCopyWithRentHistory() {
        CopyDetailsPage copyDetailsPage = new CopyDetailsPage(driver);
        copyDetailsPage.clickRemoveCopyButton();
        Assertions.assertEquals("You can't remove copy with the rents history!", copyDetailsPage.getErrorMessage());
    }

    public static class LoginPage {
        private WebDriver driver;

        public LoginPage(WebDriver driver) {
            this.driver = driver;
        }

        public void login(String username, String password) {
            driver.findElement(By.xpath("/html/body/div/div/form/div[1]/label/input")).sendKeys(username);
            driver.findElement(By.xpath("/html/body/div/div/form/div[2]/label/input")).sendKeys(password);
            driver.findElement(By.xpath("/html/body/div/div/form/div[3]/button")).click();
        }
    }

    public static class CatalogPage {
        private WebDriver driver;
        private WebDriverWait wait;

        public CatalogPage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, 10);
        }

        public String getPageTitle() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/h2")));
            return driver.findElement(By.xpath("/html/body/div/div/div/h2")).getText();
        }

        public String clickOnCopyDetailsButton() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/ul/li[1]/div[2]/a/button")));
            driver.findElement(By.xpath("/html/body/div/div/div/ul/li[1]/div[2]/a/button")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div/h2")));
            return driver.findElement(By.xpath("/html/body/div/div/div/div/h2")).getText();
        }
    }

    public static class CopyDetailsPage {
        private WebDriver driver;
        private WebDriverWait wait;

        public CopyDetailsPage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, 10);
        }

        public void clickRemoveCopyButton() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/ul/li/div[2]/button[2]")));
            driver.findElement(By.xpath("/html/body/div/div/div/ul/li/div[2]/button[2]")).click();
        }

        public String getErrorMessage() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/p")));
            return driver.findElement(By.xpath("/html/body/div/div/div/div[2]/p")).getText();
        }
    }
}