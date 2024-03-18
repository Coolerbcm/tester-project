package frontend.testing;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class secondPageUnhappy {
    private static WebDriver driver;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\selenium-drivers\\Chrome\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://ta-bookrental-fe.onrender.com/login");

        LoginPage loginPage = new LoginPage(driver);
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
    public void verifyCannotRemoveTitleWithCopies() {
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.removeTitleWithCopies();
        Assertions.assertEquals("You can't remove titles with copies!", catalogPage.getRemoveErrorText());
    }

    @Test
    @Order(3)
    public void verifyTitleCannotBeEmpty() throws InterruptedException {
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.addNewTitle("", "Podroze Pana Kleksa", "1963");
        Assertions.assertEquals("\"title\" field shouldn't be empty...", catalogPage.getAddErrorText());
    }

    @Test
    @Order(4)
    public void verifyAuthorCannotBeEmpty() throws InterruptedException {
        CatalogPage catalogPage = new CatalogPage(driver);
        driver.findElement(By.xpath("/html/body/div/div/div/div/a")).click();
        catalogPage.addNewTitle("Podroze Pana Kleksa", "", "1963");
        Assertions.assertEquals("\"author\" field shouldn't be empty...", catalogPage.getAddErrorText());
    }

    @Test
    @Order(5)
    public void verifyYearCannotBeEmpty() throws InterruptedException {
        CatalogPage catalogPage = new CatalogPage(driver);
        driver.findElement(By.xpath("/html/body/div/div/div/div/a")).click();
        catalogPage.addNewTitle("Podroze Pana Kleksa", "Podroze Pana Kleksa", "");
        Assertions.assertEquals("\"year\" field shouldn't be empty...", catalogPage.getAddErrorText());
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

    class CatalogPage {
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

        public void removeTitleWithCopies() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/ul/li/div[2]/button[2]"))).click();
        }

        public String getAddErrorText() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]")));
            return driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/p")).getText();
        }

        public String getRemoveErrorText() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div/p")));
            return driver.findElement(By.xpath("/html/body/div/div/div/div/p")).getText();
        }

        public void addNewTitle(String title, String author, String year) throws InterruptedException {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/button")));
            driver.findElement(By.xpath("/html/body/div/div/div/button")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/label/input"))).sendKeys(title);
            driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[2]/label/input")).sendKeys(author);
            driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[3]/label/input")).sendKeys(year);
            driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/button")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/p")));
        }
    }
}
