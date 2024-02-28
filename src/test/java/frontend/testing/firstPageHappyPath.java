package frontend.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class firstPageHappyPath {

    @Test
    public void testLoginAndRegisterNewUser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\selenium-drivers\\Chrome\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://ta-bookrental-fe.onrender.com/login");

        // Register a new user
        driver.findElement(By.id("register-btn")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("login")).sendKeys("Tester-Luki");
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys("12345");
        Thread.sleep(2000);
        driver.findElement(By.id("password-repeat")).sendKeys("12345");
        Thread.sleep(2000);
        driver.findElement(By.id("register-btn")).click();
        Thread.sleep(2000);

        WebElement successfullyRegistered = driver.findElement(By.className("alert__content"));
        Assertions.assertTrue(successfullyRegistered.getText().contains("You have been successfully registered!"), "You have been successfully registered!");

        driver.quit();
    }
    @Test
    public void testLoginWithCreatedUser() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\selenium-drivers\\Chrome\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://ta-bookrental-fe.onrender.com/login");

        // Login with created user
        driver.findElement(By.xpath("/html/body/div/div/form/div[1]/label/input")).sendKeys("Tester-Luki");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div/form/div[2]/label/input")).sendKeys("12345");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div/form/div[3]/button")).click();
        Thread.sleep(2000);

        // Assert that user is logged in
        WebElement firstPageTitlesCatalog = driver.findElement(By.xpath("/html/body/div/div/div/h2"));
        Assertions.assertTrue(firstPageTitlesCatalog.isDisplayed());
        Assertions.assertEquals("TITLES CATALOG", firstPageTitlesCatalog.getText());

        driver.quit();
    }
}
