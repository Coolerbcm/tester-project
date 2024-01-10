package frontend.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class firstPageUnhappyPath {

    public static void main(String[] args) throws InterruptedException {

        //Start eBook app website
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\selenium-drivers\\Chrome\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://ta-bookrental-fe.onrender.com/login");

//Try to register new user with already existing login and password - FAIL
    //Click register button
        Thread.sleep(2000);
        driver.findElement(By.id("register-btn")).click();
    //Wait for page to reload
        Thread.sleep(3000);
//Try to sign up without password - FAIL - You can't leave fields empty
        driver.findElement(By.xpath("/html/body/div/div/form/div[2]/label/input")).sendKeys("Andrzej");
        Thread.sleep(1000);
        driver.findElement(By.id("register-btn")).click();
//Try to sign up without repeating password - FAIL -  You can't leave fields empty
        driver.findElement(By.id("password")).sendKeys("qwerty");
        Thread.sleep(2000);
        driver.findElement(By.id("register-btn")).click();
        driver.findElement(By.id("login-btn")).click();
        Thread.sleep(2000);
//Try to log in with wrong login - FAIL
        driver.findElement(By.xpath("/html/body/div/div/form/div[1]/label/input")).sendKeys("Andrzej");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div/form/div[2]/label/input")).sendKeys("qwerty");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div/form/div[3]/button")).click();
        Thread.sleep(2000);
        driver.get("https://ta-bookrental-fe.onrender.com/login");
        Thread.sleep(5000);
//Try to log in with wrong password data - FAIL
        driver.findElement(By.xpath("/html/body/div/div/form/div[1]/label/input")).sendKeys("Testing");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div/form/div[2]/label/input")).sendKeys("qwerty");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div/form/div[3]/button")).click();
        Thread.sleep(2000);
    }
}
