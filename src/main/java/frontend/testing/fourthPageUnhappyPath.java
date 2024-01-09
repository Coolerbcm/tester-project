package frontend.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class fourthPageUnhappyPath {
    public static void main(String[] args) throws InterruptedException {

        //Start eBook app website
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\selenium-drivers\\Chrome\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://ta-bookrental-fe.onrender.com/login");

//Login with created user
        //Input login into text box.
        WebElement login = driver.findElement(By.xpath("/html/body/div/div/form/div[1]/label/input"));
        login.sendKeys("Testing");
        Thread.sleep(2000);

        //Input password into password text box.
        WebElement password = driver.findElement(By.xpath("/html/body/div/div/form/div[2]/label/input"));
        password.sendKeys("12345");
        Thread.sleep(2000);

        //Submit with button input data.
        WebElement loginButton2 = driver.findElement(By.xpath("/html/body/div/div/form/div[3]/button"));
        loginButton2.click();
        Thread.sleep(5000);

        WebElement showCopiesButton = driver.findElement(By.xpath("/html/body/div/div/div/ul/li/div[2]/a/button"));
        showCopiesButton.click();
        Thread.sleep(5000);

        WebElement showHistoryButton = driver.findElement(By.xpath("/html/body/div/div/div/ul/li/div[2]/a/button"));
        showHistoryButton.click();
        Thread.sleep(5000);

//"customerName" field shouldn't be empty...
        WebElement rentThisCopyButton1 = driver.findElement(By.xpath("/html/body/div/div/div/button"));
        rentThisCopyButton1.click();
        Thread.sleep(1000);

        WebElement addCopyButton1 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/button"));
        addCopyButton1.click();
        Thread.sleep(5000);
    }
}