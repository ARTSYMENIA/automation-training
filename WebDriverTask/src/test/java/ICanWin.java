import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ICanWin {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://pastebin.com");
        driver.manage().window().maximize();
        WebElement searchTextAreaForCodePasting = driver.findElement(By.id("paste_code"));
        searchTextAreaForCodePasting.sendKeys("Hello from WebDriver");

        WebElement searchPasteExpiration = driver.findElement(By.name("paste_expire_date"));
        Select dropDown = new Select(searchPasteExpiration);
        dropDown.selectByVisibleText("10 Minutes");

        WebElement searchPasteElementInput = driver.findElement(By.xpath("//form[@id='myform']//input[@name=\"paste_name\"]"));
        searchPasteElementInput.sendKeys("helloweb");

        WebElement searchBtnSubmit = driver.findElement(By.id("submit"));
        searchBtnSubmit.click();

        Thread.sleep(3000);
        driver.quit();

    }
}
