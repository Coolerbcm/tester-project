package frontend.testing;

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

public class secondPageHappy {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = WebDriverSetup.setUpWebDriver();
    }

    @Test
    public void testAddEditRemoveBook() {
        firstPageHappy.LoginPage loginPage = new firstPageHappy.LoginPage(driver);
        loginPage.open();
        loginPage.login("Tester-Luki", "12345");

        BooksPage booksPage = new BooksPage(driver);

        booksPage.addBook("Akademia Pana Kleksa", "Jan Brzechwa", "1946");
        Assertions.assertTrue(booksPage.isBookAdded("AKADEMIA PANA KLEKSA"));

        booksPage.addBook("Podroze Pana Kleksa", "Jan Brzechwa", "1961");
        Assertions.assertTrue(booksPage.isBookAdded("PODROZE PANA KLEKSA"));

        booksPage.editBookYear("Podroze Pana Kleksa", "1963");
        Assertions.assertTrue(booksPage.isBookYearEdited("(1963)"));

        booksPage.removeBook("Podroze Pana Kleksa");
        Assertions.assertFalse(booksPage.isBookPresent("PODROZE PANA KLEKSA"));
        driver.quit();
    }

    class BooksPage {
        private final WebDriver driver;
        private final WebDriverWait wait;

        public BooksPage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, 10);
        }

        public void addBook(String title, String author, String year) {
            waitForOverlayToDisappear();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/button"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='title']"))).sendKeys(title);
            driver.findElement(By.xpath("//input[@name='author']")).sendKeys(author);
            driver.findElement(By.xpath("//input[@name='year']")).sendKeys(year);
            driver.findElement(By.xpath("/html/body/div/div/div/div/div/form/button ")).click();
        }

        public boolean isBookAdded(String title) {
            WebElement bookElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/ul/li/div[1]/div[1]")));
            return bookElement.isDisplayed();
        }

        public void editBookYear(String title, String newYear) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(., '" + title + "')]/div[2]/button[1]"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='year']"))).clear();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='year']"))).sendKeys(newYear);
            driver.findElement(By.xpath("/html/body/div/div/div/div/div/form/button")).click();
        }

        public boolean isBookYearEdited(String expectedYear) {
            waitForOverlayToDisappear();
            WebElement bookYear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/ul/li[2]/div[1]/div[3]")));
            return bookYear.getText().equals(expectedYear);
        }

        public void waitForOverlayToDisappear() {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='alert alert--info']")));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='fog animated fadeIn']")));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='lds-ripple']")));
        }

        public void removeBook(String title) {
            waitForOverlayToDisappear();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(., '" + title + "')]/div[2]/button[2]"))).click();
        }

        public boolean isBookPresent(String title) {
            return driver.findElements(By.xpath("//li[contains(., '" + title + "')]")).size() > 0;
        }
    }
}