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
        WebElement registerButton1 = driver.findElement(By.id("register-btn"));
        registerButton1.click();

        //Wait for page to reload
        Thread.sleep(5000);

        //Input new user login in text box
        WebElement newUserLogin = driver.findElement(By.id("login"));
        newUserLogin.sendKeys("Testing");
        Thread.sleep(2000);

        //Input password for new user in text box
        WebElement newUserPassword = driver.findElement(By.id("password"));
        newUserPassword.sendKeys("12345");
        Thread.sleep(2000);

        //Input repeat password for new user in text box
        WebElement newUserRepeatPassword = driver.findElement(By.id("password-repeat"));
        newUserRepeatPassword.sendKeys("12345");
        Thread.sleep(2000);

        //Click on register button
        WebElement registerButton2 = driver.findElement(By.id("register-btn"));
        registerButton2.click();
        Thread.sleep(2000);

        //Click login button after register
        WebElement loginButton = driver.findElement(By.id("login-btn"));
        loginButton.click();
        Thread.sleep(2000);

        //Wait to create user and reload page after click login button
        Thread.sleep(5000);

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
        Thread.sleep(2000);
    }
}
