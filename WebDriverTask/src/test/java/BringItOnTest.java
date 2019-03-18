import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class BringItOnTest {

    private WebDriver driver;

    @BeforeTest
    public void testPreparations(){
        driver = new ChromeDriver();
        driver.get("https://pastebin.com");
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.id("header_new_paste")));
        driver.manage().window().maximize();
        WebElement searchTextAreaForCodePasting = driver.findElement(By.id("paste_code"));
        searchTextAreaForCodePasting.sendKeys(
                "git config --global user.name  \"New Sheriff in Town\"\n" +
                        "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                        "git push origin master --force");

        WebElement searchSyntaxHighlightingDropdownList = driver.findElement(By.name("paste_format"));
        Select syntaxList = new Select(searchSyntaxHighlightingDropdownList);
        syntaxList.selectByVisibleText("Bash");

        WebElement searchPasteExpiration = driver.findElement(By.name("paste_expire_date"));
        Select expirationList = new Select(searchPasteExpiration);
        expirationList.selectByVisibleText("10 Minutes");

        WebElement searchNameTitleInput = driver.findElement(By.xpath("//form[@id='myform']//input[@name=\"paste_name\"]"));
        searchNameTitleInput.sendKeys("how to gain dominance among developers");

        WebElement searchBtnSubmit = driver.findElement(By.id("submit"));
        searchBtnSubmit.click();
    }

    @Test
    public void testBrowserPageTitleEqualsToPastedNameTitle() {
        Assert.assertEquals("[Bash] how to gain dominance among developers - Pastebin.com", driver.getTitle());
    }

    @Test
    public void testSyntaxHighlightedForBash() {
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.id("code_frame")));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='code_frame']//*[text()='Bash']")).isDisplayed());
    }

    @Test
    public void testDisplayedCodIsEqualsToEntered() {
        ArrayList<String> stringsToCompare = new ArrayList<String>();
        List<WebElement> searchEnteredText = driver.findElements(By.xpath("//*[@id='selectable']//div[@class='de1']"));
        for (WebElement element : searchEnteredText) {
            stringsToCompare.add(element.getText());
        }

        Assert.assertEquals(stringsToCompare.toString().replace(", ", "\n").replace("[","").replace("]",""),driver.findElement(By.id("paste_code")).getText());
    }
    @AfterTest
    public void quit() {
        driver.quit();
    }
}
