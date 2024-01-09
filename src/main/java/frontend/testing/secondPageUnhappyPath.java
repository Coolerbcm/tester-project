package frontend.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class secondPageUnhappyPath {
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

        //You can't remove titles with copies!
        WebElement removeTitleButton = driver.findElement(By.xpath("/html/body/div/div/div/ul/li/div[2]/button[2]"));
        removeTitleButton.click();
        Thread.sleep(5000);

        //"title" field shouldn't be empty...
        WebElement addNewTitle1 = driver.findElement(By.xpath("/html/body/div/div/div/button"));
        addNewTitle1.click();
        Thread.sleep(1000);

        WebElement addTitleButton1 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/button"));
        addTitleButton1.click();
        Thread.sleep(5000);

        //"author" field shouldn't be empty...
        WebElement titleInput1 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[2]/label/input"));
        titleInput1.sendKeys("Podroze Pana Kleksa");
        Thread.sleep(1000);

        WebElement addTitleButton2 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/button"));
        addTitleButton2.click();
        Thread.sleep(5000);

        //"year" field shouldn't be empty...
        WebElement authorInput1 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[3]/label/input"));
        authorInput1.sendKeys("Jan Brzechwa");
        Thread.sleep(1000);

        WebElement addTitleButton3 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/button"));
        addTitleButton3.click();
        Thread.sleep(5000);

        //Return to titles catalog
        WebElement closeXButton = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/a"));
        closeXButton.click();
        Thread.sleep(5000);
    }
}
