package frontend.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private By loginInput = By.id("login");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-btn");
    private static By registerButton = By.id("register-btn");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://ta-bookrental-fe.onrender.com/login");
    }

    public RegisterPage navigateToRegisterPage() {
        driver.findElement(registerButton).click();
        return new RegisterPage(driver);
    }

    public void login(String username, String password) {
        driver.findElement(loginInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public boolean isFirstPageTitlesCatalogDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement firstPageTitlesCatalog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/h2")));
        return firstPageTitlesCatalog.isDisplayed() && firstPageTitlesCatalog.getText().equals("TITLES CATALOG");
    }
}
