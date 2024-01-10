package frontend.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class fourthPageHappyPath {
    public static void main(String[] args) throws InterruptedException {

//Start eBook app website
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\selenium-drivers\\Chrome\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://ta-bookrental-fe.onrender.com/login");

//Login with created user
    //Input login into text box.
        driver.findElement(By.xpath("/html/body/div/div/form/div[1]/label/input")).sendKeys("Testing");
        Thread.sleep(2000);
    //Input password into password text box.
        driver.findElement(By.xpath("/html/body/div/div/form/div[2]/label/input")).sendKeys("12345");
        Thread.sleep(2000);
    //Submit with button input data.
        driver.findElement(By.xpath("/html/body/div/div/form/div[3]/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div/div/div/ul/li/div[2]/a/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div/div/div/ul/li/div[2]/a/button")).click();
        Thread.sleep(5000);
    //Rent 1  of Book 1
        driver.findElement(By.xpath("/html/body/div/div/div/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div/form/div[1]/label/input")).sendKeys("Lukasz");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div/form/button")).click();
        Thread.sleep(3000);
    //Return Book 1
        driver.findElement(By.xpath("/html/body/div/div/div/ul/li/div[2]/button[2]")).click();
        Thread.sleep(3000);
    // Rent 2 of Book 1
        driver.findElement(By.xpath("/html/body/div/div/div/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div/form/div[1]/label/input")).sendKeys("Andrzej");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[3]/div/form/button")).click();
        Thread.sleep(5000);
//Edit rent 2 of Book 1
        driver.findElement(By.xpath("/html/body/div/div/div/ul/li/div[2]/button[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[3]/div/div/div[1]/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[3]/div/div/div[2]/div/span[39]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/button")).click();
        Thread.sleep(3000);
    }
}

