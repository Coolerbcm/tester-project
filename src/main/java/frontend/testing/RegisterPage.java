package frontend.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;
    private By loginInput = By.id("login");
    private By passwordInput = By.id("password");
    private By repeatPasswordInput = By.id("password-repeat");
    private By registerButton = By.id("register-btn");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void registerNewUser(String username, String password) {
        driver.findElement(loginInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(repeatPasswordInput).sendKeys(password);
        driver.findElement(registerButton).click();
    }
}
