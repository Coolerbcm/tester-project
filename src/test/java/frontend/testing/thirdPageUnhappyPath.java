package frontend.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class thirdPageUnhappyPath {


    @Test
    public void cannotRemoveCopyWithRentHistory () throws InterruptedException {
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
    // Successful login
        WebElement loginSuccess = driver.findElement(By.xpath("/html/body/div/div/div/h2"));
        Assertions.assertEquals("TITLES CATALOG", loginSuccess.getText());
//Enter to copies of Book 1
        driver.findElement(By.xpath("/html/body/div/div/div/ul/li[1]/div[2]/a/button")).click();
        Thread.sleep(5000);
//You can't remove copy with the rent's history!
        driver.findElement(By.xpath("/html/body/div/div/div/ul/li/div[2]/button[2]")).click();
        Thread.sleep(5000);
    //Assert that you cannot remove copy with rent history.
        WebElement removeFailErrorMessage = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/p"));
        Assertions.assertEquals("You can't remove copy with the rents history!", removeFailErrorMessage.getText());

        driver.quit();
    }
}