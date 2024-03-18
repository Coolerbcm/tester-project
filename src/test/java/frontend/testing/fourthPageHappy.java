package frontend.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class fourthPageHappy {
    @Test
    public void editRentBook() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\selenium-drivers\\Chrome\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);

        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://ta-bookrental-fe.onrender.com/login");

        loginPage.login("Tester-Luki", "12345");
        HomePage homePage = new HomePage(driver);
        homePage.navigateToBookList();

        BookListPage bookListPage = new BookListPage(driver);
        bookListPage.rentBook("Lukasz");

        Assertions.assertEquals("LUKASZ", bookListPage.getFirstBookRent());
        bookListPage.returnBook();

        Assertions.assertTrue(bookListPage.isReturnButtonPresent(), "Element should not exist");
        bookListPage.rentBook("Andrzej");

        Assertions.assertEquals("ANDRZEJ", bookListPage.getFirstBookRent());
        bookListPage.editRent();

        Assertions.assertEquals("(expiration: 2024-03-27)", bookListPage.getEditedBookRent());
        driver.quit();
    }

    class LoginPage {
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

    class HomePage {
        private WebDriverWait wait;

        public HomePage(WebDriver driver) {
            this.wait = new WebDriverWait(driver, 10);
        }

        public void navigateToBookList() throws InterruptedException {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/h2")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div/ul/li[1]/div[2]/a/button"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div/h2")));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div/ul/li/div[2]/a/button"))).click();
        }
    }

    class BookListPage {
        private WebDriver driver;
        private WebDriverWait wait;

        public BookListPage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, 10);
        }

        public void rentBook(String renterName) throws InterruptedException {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/h2")));
            Thread.sleep(2000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/button"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[3]/div/form/div[1]/label/input"))).sendKeys(renterName);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[3]/div/form/button"))).click();
        }

        public String getFirstBookRent() {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/ul/li/div[1]/div[1]"))).getText();
        }

        public void returnBook() {
            driver.findElement(By.xpath("/html/body/div/div/div/ul/li/div[2]/button[2]")).click();
        }

        public boolean isReturnButtonPresent() {

            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div/div/div/ul/li/div[1]/div[1]")));
            return driver.findElements(By.xpath("/html/body/div/div/div/ul/li/div[1]/div[1]")).isEmpty();
        }

        public void editRent() {
            driver.findElement(By.xpath("/html/body/div/div/div/ul/li/div[2]/button[1]")).click();
            driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[3]/div/div/div[1]/input")).click();
            driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[3]/div/div/div[2]/div/span[39]")).click();
            driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/button")).click();
        }

        public String getEditedBookRent() {
            WebElement editedBookRent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/ul/li/div[1]/div[3]")));
            wait.until(ExpectedConditions.textToBePresentInElement(editedBookRent, "(expiration: 2024-03-27)"));
            return editedBookRent.getText();
        }
    }
}