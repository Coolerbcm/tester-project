package frontend.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class thirdPageHappy {
    private static WebDriver driver;
    private static LoginPage loginPage;
    private static ListOfCopiesPage listOfCopiesPage;

    @BeforeAll
    public static void setUp() {
        driver = WebDriverSetup.setUpWebDriver();
        loginPage = new LoginPage(driver);
        listOfCopiesPage = new ListOfCopiesPage(driver);
    }

    @Test
    public void addNewEditRemoveCopy() throws InterruptedException {
        loginPage.login("Tester-Luki", "12345");

        listOfCopiesPage.navigateToBookDetails();
        Thread.sleep(5000);
        listOfCopiesPage.addNewCopy();
        Assertions.assertEquals("1.", listOfCopiesPage.getFirstCopyNumber());
        listOfCopiesPage.addNewCopy();
        Assertions.assertEquals("2.", listOfCopiesPage.getSecondCopyNumber());
        listOfCopiesPage.editSecondCopy("2020-02-05");
        Assertions.assertTrue(listOfCopiesPage.isSecondCopyDateCorrect("2020-02-05"));
        listOfCopiesPage.removeSecondCopy();
        Assertions.assertFalse(listOfCopiesPage.isSecondCopyPresent());

        driver.quit();
    }
}
