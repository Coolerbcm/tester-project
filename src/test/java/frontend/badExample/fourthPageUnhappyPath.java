package frontend.badExample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class fourthPageUnhappyPath {
    @Test
    public void customerNameCannotBeEmpty() throws InterruptedException {
//Start eBook app website
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\selenium-drivers\\Chrome\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://ta-bookrental-fe.onrender.com/login");
//Login with created user
    //Input login into text box.
        driver.findElement(By.xpath("/html/body/div/div/form/div[1]/label/input")).sendKeys("Tester-Luki");
        Thread.sleep(2000);
    //Input password into password text box.
        driver.findElement(By.xpath("/html/body/div/div/form/div[2]/label/input")).sendKeys("12345");
        Thread.sleep(2000);
    //Submit with button input data.
        driver.findElement(By.xpath("/html/body/div/div/form/div[3]/button")).click();
        Thread.sleep(3000);
    //Assert successful login
        WebElement loginSuccess = driver.findElement(By.xpath("/html/body/div/div/div/h2"));
        Assertions.assertEquals("TITLES CATALOG", loginSuccess.getText());
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/ul/li/div[2]/a/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div/div/div/ul/li/div[2]/a/button")).click();
        Thread.sleep(5000);
//"customerName" field shouldn't be empty...
        driver.findElement(By.xpath("/html/body/div/div/div/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/button")).click();
        Thread.sleep(5000);
    //Assert that customer name field cannot be empty.
        WebElement removeFailErrorMessage = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/p"));
        Assertions.assertEquals("\"customerName\" field shouldn't be empty...", removeFailErrorMessage.getText());

        driver.quit();
    }
}