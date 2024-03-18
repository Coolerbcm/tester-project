package frontend.badExample;


import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.api.Assertions;

public class secondPageUnhappyPath {

    @Test
    public void successfulTestWrongInputs() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\selenium-drivers\\Chrome\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver.get("https://ta-bookrental-fe.onrender.com/login");
// Login with created user
    //Input login into text box.
        driver.findElement(By.xpath("/html/body/div/div/form/div[1]/label/input")).sendKeys("Tester-Luki");
        Thread.sleep(1000);
    //Input password into password text box.
        driver.findElement(By.xpath("/html/body/div/div/form/div[2]/label/input")).sendKeys("12345");
        Thread.sleep(1000);
    //Submit with button input data.
        driver.findElement(By.xpath("/html/body/div/div/form/div[3]/button")).click();
        Thread.sleep(5000);
    // Assert successful login
        WebElement loginSuccess = driver.findElement(By.xpath("/html/body/div/div/div/h2"));
        Assertions.assertEquals("TITLES CATALOG", loginSuccess.getText());
//You can't remove titles with copies!
        driver.findElement(By.xpath("/html/body/div/div/div/ul/li/div[2]/button[2]")).click();
        Thread.sleep(5000);
    // Assert that error shows up
        WebElement cannotRemove = driver.findElement(By.xpath("/html/body/div/div/div/div/p"));
        Assertions.assertEquals("You can't remove titles with copies!", cannotRemove.getText());
//"title" field shouldn't be empty...
        driver.findElement(By.xpath("/html/body/div/div/div/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/button")).click();
        Thread.sleep(5000);
    //Assert that the title cannot be empty
        WebElement titleEmpty = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/p"));
        Assertions.assertEquals("\"title\" field shouldn't be empty...", titleEmpty.getText());
//"author" field shouldn't be empty...
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[2]/label/input")).sendKeys("Podroze Pana Kleksa");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/button")).click();
        Thread.sleep(5000);
    //Assert that the author cannot be empty
        WebElement authorEmpty = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/p"));
        Assertions.assertEquals("\"author\" field shouldn't be empty...", authorEmpty.getText());
//"year" field shouldn't be empty...
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[3]/label/input")).sendKeys("Jan Brzechwa");
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/button")).click();
        Thread.sleep(5000);
    //Assert that the year cannot be empty
        WebElement yearEmpty = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/p"));
        Assertions.assertEquals("\"year\" field shouldn't be empty...", yearEmpty.getText());
    //Return to titles catalog
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/a")).click();
        Thread.sleep(5000);

        driver.quit();
    }
}