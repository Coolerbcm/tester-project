package frontend.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class thirdPageHappyPath {

    @Test
    public void addNewEditRemoveCopy() throws InterruptedException {
//Start eBook app website
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\selenium-drivers\\Chrome\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://ta-bookrental-fe.onrender.com/login");
//Login with created user
    //Input login into text box.
        driver.findElement(By.xpath("/html/body/div/div/form/div[1]/label/input")).sendKeys("Tester-Luki");
        Thread.sleep(1000);
    //Input password into password text box.
        driver.findElement(By.xpath("/html/body/div/div/form/div[2]/label/input")).sendKeys("12345");
        Thread.sleep(1000);
    //Submit with button input data.
        driver.findElement(By.xpath("/html/body/div/div/form/div[3]/button")).click();
        Thread.sleep(5000);
//Enter to copies of Book 1
        driver.findElement(By.xpath("/html/body/div/div/div/ul/li[1]/div[2]/a/button")).click();
        Thread.sleep(5000);
//Add new copy
        driver.findElement(By.xpath("/html/body/div/div/div/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div/form/button")).click();
        Thread.sleep(5000);
    // Assert that the new copy has been added
        WebElement bookCopy = driver.findElement(By.xpath("/html/body/div/div/div/ul/li/div[1]/div[1]"));
        Assertions.assertEquals("1.", bookCopy.getText());
//Add another copy
        driver.findElement(By.xpath("/html/body/div/div/div/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/button")).click();
        Thread.sleep(5000);
    // Assert that the new copy has been added
        WebElement bookCopy2 = driver.findElement(By.xpath("/html/body/div/div/div/ul/li[2]/div[1]/div[1]"));
        Assertions.assertEquals("2.", bookCopy2.getText());
//Edit second copy of Book 2
        driver.findElement(By.xpath("/html/body/div/div/div/ul/li[2]/div[2]/button[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div/div/div/div[1]/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div/div/div/div[2]/div/span[18]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/button")).click();
        Thread.sleep(5000);
    // Assert that the edit has been successful
        WebElement editBook = driver.findElement(By.xpath("/html/body/div/div/div/ul/li[2]/div[1]/div[2]"));
        Assertions.assertEquals("2020-02-05", editBook.getText());
//Remove second copy of Book
        driver.findElement(By.xpath("/html/body/div/div/div/ul/li[2]/div[2]/button[2]")).click();
        Thread.sleep(3000);
// Assert that the book is removed successfully
        boolean isElementPresent = driver.findElements(By.xpath("/html/body/div/div/div/ul/li[2]/div[1]/div[1]")).size() > 0;
        Assertions.assertFalse(isElementPresent, "Element should not exist");

        driver.quit();
    }
}

