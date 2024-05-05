package frontend.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListOfCopiesPage {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public ListOfCopiesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void navigateToBookDetails() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/ul/li[1]/div[2]/a/button"))).click();
    }

    public void waitForOverlayToDisappear() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='fog animated fadeIn']")));
    }

    public void addNewCopy() {
        waitForOverlayToDisappear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/h2")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add-item-button"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'btn btn--primary')]"))).click();
    }

    public String getFirstCopyNumber() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/ul/li/div[1]/div[1]"))).getText();
    }

    public String getSecondCopyNumber() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/ul/li[2]/div[1]/div[1]"))).getText();
    }

    public void editSecondCopy(String newDate) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/ul/li[2]/div[2]/button[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div/form/div/div/div/div[1]/input"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div/form/div/div/div/div[2]/div/span[18]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[2]/div/form/button"))).click();
    }

    public boolean isSecondCopyDateCorrect(String expectedDate) {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div/div/div/ul/li[2]/div[1]/div[2]"), expectedDate));
    }

    public void removeSecondCopy() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/ul/li[2]/div[2]/button[2]"))).click();
    }

    public boolean isSecondCopyPresent() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.findElements(By.xpath("/html/body/div/div/div/ul/li[2]/div[1]/div[1]")).size() > 0;
    }
    public static String getPageTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/h2")));
        return driver.findElement(By.xpath("/html/body/div/div/div/h2")).getText();
    }

    public String clickOnCopyDetailsButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/ul/li[1]/div[2]/a/button")));
        driver.findElement(By.xpath("/html/body/div/div/div/ul/li[1]/div[2]/a/button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div/h2")));
        return driver.findElement(By.xpath("/html/body/div/div/div/div/h2")).getText();
    }
    public void clickRemoveCopyButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/ul/li/div[2]/button[2]")));
        driver.findElement(By.xpath("/html/body/div/div/div/ul/li/div[2]/button[2]")).click();
    }

    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/p")));
        return driver.findElement(By.xpath("/html/body/div/div/div/div[2]/p")).getText();
    }
}
