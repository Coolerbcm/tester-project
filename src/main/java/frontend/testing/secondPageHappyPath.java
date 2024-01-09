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

//Add first book
        WebElement addNewTitle1 = driver.findElement(By.xpath("/html/body/div/div/div/button"));
        addNewTitle1.click();
        Thread.sleep(1000);

        WebElement titleInput1 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/label/input"));
        titleInput1.sendKeys("Akademia Pana Kleksa");
        Thread.sleep(1000);

        WebElement authorInput1 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[2]/label/input"));
        authorInput1.sendKeys("Jan Brzechwa");
        Thread.sleep(1000);

        WebElement yearInput1 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[3]/label/input"));
        yearInput1.sendKeys("1946");
        Thread.sleep(1000);

        WebElement addTitleButton1 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/button"));
        addTitleButton1.click();
        Thread.sleep(5000);

//Add second book
        WebElement addNewTitle2 = driver.findElement(By.xpath("/html/body/div/div/div/button"));
        addNewTitle2.click();
        Thread.sleep(1000);

        WebElement titleInput2 = driver.findElement(By.xpath("/html/body/div/div/div/div/div/form/div[1]/label/input"));
        titleInput2.sendKeys("Podroze Pana Kleksa");
        Thread.sleep(1000);

        WebElement authorInput2 = driver.findElement(By.xpath("/html/body/div/div/div/div/div/form/div[2]/label/input"));
        authorInput2.sendKeys("Jan Brzechwa");
        Thread.sleep(1000);

        WebElement yearInput2 = driver.findElement(By.xpath("/html/body/div/div/div/div/div/form/div[3]/label/input"));
        yearInput2.sendKeys("1961");
        Thread.sleep(1000);

        WebElement addTitleButton2 = driver.findElement(By.xpath("/html/body/div/div/div/div/div/form/button"));
        addTitleButton2.click();
        Thread.sleep(5000);


//Edit Book number 2, change title of the book
        WebElement editBookButton = driver.findElement(By.xpath("/html/body/div/div/div/ul/li[2]/div[2]/button[1]"));
        editBookButton.click();
        Thread.sleep(1000);

        WebElement yearInput3 = driver.findElement(By.xpath("/html/body/div/div/div/div/div/form/div[3]/label/input"));
        yearInput3.clear();
        yearInput3.sendKeys("1963");
        Thread.sleep(1000);

        WebElement editTitleButton1 = driver.findElement(By.xpath("/html/body/div/div/div/div/div/form/button"));
        editTitleButton1.click();
        Thread.sleep(5000);

//Remove Book number 2
        WebElement removeTitleButton1 = driver.findElement(By.xpath("/html/body/div/div/div/ul/li[2]/div[2]/button[2]"));
        removeTitleButton1.click();
        Thread.sleep(1000);


    }
}
