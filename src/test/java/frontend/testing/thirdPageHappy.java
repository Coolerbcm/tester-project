package frontend.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class thirdPageHappy {

    @Test
    public void addNewEditRemoveCopy() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\selenium-drivers\\Chrome\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://ta-bookrental-fe.onrender.com/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Tester-Luki", "12345");

        BookPage bookPage = new BookPage(driver);
        bookPage.navigateToBookDetails();
        Thread.sleep(5000);
        bookPage.addNewCopy();
        Assertions.assertEquals("1.", bookPage.getFirstCopyNumber());
        bookPage.addNewCopy();
        Assertions.assertEquals("2.", bookPage.getSecondCopyNumber());
        bookPage.editSecondCopy("2020-02-05");
        Assertions.assertTrue(bookPage.isSecondCopyDateCorrect("2020-02-05"));
        bookPage.removeSecondCopy();
        Assertions.assertFalse(bookPage.isSecondCopyPresent());

        driver.quit();
    }

    public class LoginPage {
        private WebDriverWait wait;

        public LoginPage(WebDriver driver) {
            this.wait = new WebDriverWait(driver, 10);
        }

        public void login(String username, String password) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/form/div[1]/label/input"))).sendKeys(username);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/form/div[2]/label/input"))).sendKeys(password);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/form/div[3]/button"))).click();
        }
    }

    public class BookPage {
        private WebDriver driver;
        private WebDriverWait wait;

        public BookPage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, 10);
        }

        public void navigateToBookDetails() {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/ul/li[1]/div[2]/a/button"))).click();
        }

        public void waitForOverlayToDisappear() {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='fog animated fadeIn']")));
        }

        public void addNewCopy() {
            waitForOverlayToDisappear();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/h2")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-item-button"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'btn btn--primary')]"))).click();
        }

        public String getFirstCopyNumber() {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/ul/li/div[1]/div[1]"))).getText();
        }

        public String getSecondCopyNumber() {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/ul/li[2]/div[1]/div[1]"))).getText();
        }

        public void editSecondCopy(String newDate) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/ul/li[2]/div[2]/button[1]"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div/form/div/div/div/div[1]/input"))).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div/form/div/div/div/div[2]/div/span[18]"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[2]/div/form/button"))).click();
        }

        public boolean isSecondCopyDateCorrect(String expectedDate) {
            return wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div/div/div/ul/li[2]/div[1]/div[2]"), expectedDate));
        }

        public void removeSecondCopy() {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/ul/li[2]/div[2]/button[2]"))).click();
        }

        public boolean isSecondCopyPresent() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return driver.findElements(By.xpath("/html/body/div/div/div/ul/li[2]/div[1]/div[1]")).size() > 0;
        }

    }
}
