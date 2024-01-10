package frontend.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class firstPageHappyPath {
    public static void main(String[] args) throws InterruptedException {

        //Start eBook app website
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\selenium-drivers\\Chrome\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://ta-bookrental-fe.onrender.com/login");

//Create user
    //Click register button
        Thread.sleep(2000);
        driver.findElement(By.id("register-btn")).click();
    //Wait for page to reload
        Thread.sleep(5000);
    //Input new user login in text box
        driver.findElement(By.id("login")).sendKeys("Testing");
        Thread.sleep(2000);
    //Input password for new user in text box
        driver.findElement(By.id("password")).sendKeys("12345");
        Thread.sleep(2000);
    //Input repeat password for new user in text box
        driver.findElement(By.id("password-repeat")).sendKeys("12345");
        Thread.sleep(2000);
    //Click on register button
        driver.findElement(By.id("register-btn")).click();
        Thread.sleep(2000);
    //Click login button after register
        driver.findElement(By.id("login-btn")).click();
        Thread.sleep(2000);
    //Wait to create user and reload page after click login button
        Thread.sleep(5000);
//Login with created user
    //Input login into text box.
        driver.findElement(By.xpath("/html/body/div/div/form/div[1]/label/input")).sendKeys("Testing");
        Thread.sleep(2000);
    //Input password into password text box.
        driver.findElement(By.xpath("/html/body/div/div/form/div[2]/label/input")).sendKeys("12345");
        Thread.sleep(2000);
    //Submit with button input data.
        driver.findElement(By.xpath("/html/body/div/div/form/div[3]/button")).click();
        Thread.sleep(2000);
    }
}
