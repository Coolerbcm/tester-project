package frontend.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TitlesCatalogPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public TitlesCatalogPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void addBook(String title, String author, String year) {
        waitForOverlayToDisappear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/button"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='title']"))).sendKeys(title);
        driver.findElement(By.xpath("//input[@name='author']")).sendKeys(author);
        driver.findElement(By.xpath("//input[@name='year']")).sendKeys(year);
        driver.findElement(By.xpath("/html/body/div/div/div/div/div/form/button ")).click();
    }

    public boolean isBookAdded(String title) {
        WebElement bookElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/ul/li/div[1]/div[1]")));
        return bookElement.isDisplayed();
    }

    public void editBookYear(String title, String newYear) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(., '" + title + "')]/div[2]/button[1]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='year']"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='year']"))).sendKeys(newYear);
        driver.findElement(By.xpath("/html/body/div/div/div/div/div/form/button")).click();
    }

    public boolean isBookYearEdited(String expectedYear) {
        waitForOverlayToDisappear();
        WebElement bookYear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/ul/li[2]/div[1]/div[3]")));
        return bookYear.getText().equals(expectedYear);
    }

    public void waitForOverlayToDisappear() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='alert alert--info']")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='fog animated fadeIn']")));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='lds-ripple']")));
    }

    public void removeBook(String title) {
        waitForOverlayToDisappear();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(., '" + title + "')]/div[2]/button[2]"))).click();
    }

    public boolean isBookPresent(String title) {
        return driver.findElements(By.xpath("//li[contains(., '" + title + "')]")).size() > 0;
    }

    public String getPageTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/h2")));
        return driver.findElement(By.xpath("/html/body/div/div/div/h2")).getText();
    }

    public void removeTitleWithCopies() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/ul/li/div[2]/button[2]"))).click();
    }

    public String getAddErrorText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]")));
        return driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/p")).getText();
    }

    public String getRemoveErrorText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div/p")));
        return driver.findElement(By.xpath("/html/body/div/div/div/div/p")).getText();
    }

    public void addNewTitle(String title, String author, String year) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/button")));
        driver.findElement(By.xpath("/html/body/div/div/div/button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/label/input"))).sendKeys(title);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[2]/label/input")).sendKeys(author);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[3]/label/input")).sendKeys(year);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/p")));
    }
}

