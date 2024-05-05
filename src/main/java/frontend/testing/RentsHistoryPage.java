package frontend.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RentsHistoryPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public RentsHistoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void rentBook(String renterName) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/h2")));
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/button"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[3]/div/form/div[1]/label/input"))).sendKeys(renterName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[3]/div/form/button"))).click();
    }


    public String getFirstBookRent() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/ul/li/div[1]/div[1]"))).getText();
    }

    public void returnBook() {
        driver.findElement(By.xpath("/html/body/div/div/div/ul/li/div[2]/button[2]")).click();
    }

    public boolean isReturnButtonPresent() {

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div/div/div/ul/li/div[1]/div[1]")));
        return driver.findElements(By.xpath("/html/body/div/div/div/ul/li/div[1]/div[1]")).isEmpty();
    }

    public void editRent() {
        driver.findElement(By.xpath("/html/body/div/div/div/ul/li/div[2]/button[1]")).click();
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[3]/div/div/div[1]/input")).click();
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[3]/div/div/div[2]/div/span[39]")).click();
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/button")).click();
    }

    public String getEditedBookRent() {
        WebElement editedBookRent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/ul/li/div[1]/div[3]")));
        wait.until(ExpectedConditions.textToBePresentInElement(editedBookRent, "(expiration: 2024-03-27)"));
        return editedBookRent.getText();
    }

    public void navigateToBookList() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/h2")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div/ul/li[1]/div[2]/a/button"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div/h2")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/div/ul/li/div[2]/a/button"))).click();
    }

    public void clickRentThisCopyAndAddCopyButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/button")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fog")));
        driver.findElement(By.xpath("/html/body/div/div/div/button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div/form/button")));
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/button")).click();
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/p")));
        return driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/p")).getText();
    }

    public String clickOnShowHistoryButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/ul/li[1]/div[2]/a/button")));
        driver.findElement(By.xpath("/html/body/div/div/div/ul/li[1]/div[2]/a/button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div/h2")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/ul/li/div[2]/a/button")));
        driver.findElement(By.xpath("/html/body/div/div/div/ul/li/div[2]/a/button")).click();
        wait.until(ExpectedConditions.textToBe(By.xpath("/html/body/div/div/div/div/h2"), "RENTS HISTORY"));
        return driver.findElement(By.xpath("/html/body/div/div/div/div/h2")).getText();
    }

    public String getPageTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/h2")));
        return driver.findElement(By.xpath("/html/body/div/div/div/h2")).getText();
    }
}
