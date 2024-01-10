package frontend.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class secondPageHappyPath {
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
//Add first book
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
//Add second book
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
//Edit Book number 2, change title of the book
        driver.findElement(By.xpath("/html/body/div/div/div/ul/li[2]/div[2]/button[1]")).click();
        Thread.sleep(1000);
        WebElement yearInput3 = driver.findElement(By.xpath("/html/body/div/div/div/div/div/form/div[3]/label/input"));
        yearInput3.clear();
        yearInput3.sendKeys("1963");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div/div/form/button")).click();
        Thread.sleep(5000);
//Remove Book number 2
        driver.findElement(By.xpath("/html/body/div/div/div/ul/li[2]/div[2]/button[2]")).click();
        Thread.sleep(1000);


    }
}
