package frontend.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class firstPageUnhappyPath {

    @Test
    public void testRegistrationWithExistingCredentials() throws InterruptedException {
    // Start eBook app website
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\selenium-drivers\\Chrome\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://ta-bookrental-fe.onrender.com/login");
        // Click register button
        Thread.sleep(2000);
        driver.findElement(By.id("register-btn")).click();
        Thread.sleep(3000);
    // Try to sign up without password
        driver.findElement(By.xpath("/html/body/div/div/form/div[2]/label/input")).sendKeys("Andrzej");
        Thread.sleep(1000);
        driver.findElement(By.id("register-btn")).click();
        WebElement errorMessage = driver.findElement(By.className("alert__content"));
        Assertions.assertTrue(errorMessage.getText().contains("You can't leave fields empty"), "Error message is not as expected");

        driver.quit();
    }

    @Test
    public void testLoginWithWrongCredentials() throws InterruptedException {
    // Start eBook app website
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\selenium-drivers\\Chrome\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://ta-bookrental-fe.onrender.com/login");
    // Try to log in with wrong login
        driver.findElement(By.xpath("/html/body/div/div/form/div[1]/label/input")).sendKeys("Andrzej");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div/form/div[2]/label/input")).sendKeys("qwerty");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div/form/div[3]/button")).click();
        Thread.sleep(2000);
        WebElement loginErrorMessage = driver.findElement(By.className("alert__content"));
        Assertions.assertTrue(loginErrorMessage.getText().contains("Login failed"), "Login failed");

        driver.quit();
    }
}
