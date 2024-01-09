package frontend.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class thirdPageUnhappyPath {

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
        Thread.sleep(1000);

        //Input password into password text box.
        WebElement password = driver.findElement(By.xpath("/html/body/div/div/form/div[2]/label/input"));
        password.sendKeys("12345");
        Thread.sleep(1000);

        //Submit with button input data.
        WebElement loginButton2 = driver.findElement(By.xpath("/html/body/div/div/form/div[3]/button"));
        loginButton2.click();
        Thread.sleep(5000);
//Enter to copies of Book 1
        WebElement showCopiesButton = driver.findElement(By.xpath("/html/body/div/div/div/ul/li[1]/div[2]/a/button"));
        showCopiesButton.click();
        Thread.sleep(5000);

        //You can't remove copy with the rents history!
        WebElement removeCopyFromListButton = driver.findElement(By.xpath("/html/body/div/div/div/ul/li/div[2]/button[2]"));
        removeCopyFromListButton.click();
        Thread.sleep(5000);

        //
    }
}
