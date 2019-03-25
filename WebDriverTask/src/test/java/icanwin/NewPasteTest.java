package icanwin;
//Удалить после завершения след задания
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewPasteTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test(description = "To check first task")
    public void testIfPasted() {
        String pasteText = new NewPaste(driver)
                .openPage()
                .createNewPaste("Hello from WebDriver", "10 Minutes", "helloweb")
                .getPastedCode();
        Assert.assertEquals(pasteText, "Hello from WebDriver");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
