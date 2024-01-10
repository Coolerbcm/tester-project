package frontend.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class thirdPageHappyPath {
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
//Add another copy
        driver.findElement(By.xpath("/html/body/div/div/div/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/button")).click();
        Thread.sleep(5000);
//Edit second copy of Book 2
        driver.findElement(By.xpath("/html/body/div/div/div/ul/li[2]/div[2]/button[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div/div/div/div[1]/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div/div/div/div[2]/div/span[18]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/button")).click();
        Thread.sleep(5000);
//Remove second copy of Book
        driver.findElement(By.xpath("/html/body/div/div/div/ul/li[2]/div[2]/button[2]")).click();
        Thread.sleep(3000);
//Enter to history of copy
        driver.findElement(By.xpath("/html/body/div/div/div/ul/li/div[2]/a/button")).click();
    }
}
