package frontend.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.NoSuchElementException;



public class secondPageHappyPath {

    @Test
    public void testAddEditRemoveBook() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\selenium-drivers\\Chrome\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://ta-bookrental-fe.onrender.com/login");
// Login with created user
        driver.findElement(By.xpath("/html/body/div/div/form/div[1]/label/input")).sendKeys("Tester-Luki");
        driver.findElement(By.xpath("/html/body/div/div/form/div[2]/label/input")).sendKeys("12345");
        driver.findElement(By.xpath("/html/body/div/div/form/div[3]/button")).click();
        Thread.sleep(3000);
// Add first book
        driver.findElement(By.xpath("/html/body/div/div/div/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/label/input")).sendKeys("Akademia Pana Kleksa");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[2]/label/input")).sendKeys("Jan Brzechwa");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[3]/label/input")).sendKeys("1946");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/button")).click();
        Thread.sleep(5000);
    // Assert that the book is added successfully
        WebElement bookAuthor = driver.findElement(By.xpath("/html/body/div/div/div/ul/li/div[1]/div[1]"));
        Assertions.assertEquals("AKADEMIA PANA KLEKSA", bookAuthor.getText());
// Add second Book
        driver.findElement(By.xpath("/html/body/div/div/div/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div/div/form/div[1]/label/input")).sendKeys("Podroze Pana Kleksa");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div/div/form/div[2]/label/input")).sendKeys("Jan Brzechwa");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div/div/form/div[3]/label/input")).sendKeys("1961");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div/div/form/button")).click();
        Thread.sleep(5000);
    //Assert that the book is added successfully
        WebElement bookAuthor2 = driver.findElement(By.xpath("/html/body/div/div/div/ul/li[2]/div[1]/div[1]"));
        Assertions.assertEquals("PODROZE PANA KLEKSA", bookAuthor2.getText());
//Edit Book number 2, change year of the book
        driver.findElement(By.xpath("/html/body/div/div/div/ul/li[2]/div[2]/button[1]")).click();
        Thread.sleep(1000);
        WebElement yearInput3 = driver.findElement(By.xpath("/html/body/div/div/div/div/div/form/div[3]/label/input"));
        yearInput3.clear();
        yearInput3.sendKeys("1963");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div/div/form/button")).click();
        Thread.sleep(5000);
    // Assert that book is successfully edited
        WebElement bookYear = driver.findElement(By.xpath("/html/body/div/div/div/ul/li[2]/div[1]/div[3]"));
        Assertions.assertEquals("(1963)", bookYear.getText());
        Thread.sleep(3000);
//Remove Book number 2
        driver.findElement(By.xpath("/html/body/div/div/div/ul/li[2]/div[2]/button[2]")).click();
        Thread.sleep(3000);
    // Assert that the book is removed successfully
        boolean isElementPresent = driver.findElements(By.xpath("/html/body/div/div/div/ul/li[2]/div[1]/div[1]")).size() > 0;
        Assertions.assertFalse(isElementPresent, "Element should not exist");

        driver.quit();
    }
}
