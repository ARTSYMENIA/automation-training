package bringiton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewPasteTest {
    private WebDriver driver;
    private String newPaste = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private String syntaxHighlighting = "Bash";
    private String pasteExpiration = "10 Minutes";
    private String pasteNameOrTitle = "how to gain dominance among developers";

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testDisplayedCodeIsEqualsToEntered() {
        String pasteText = new NewPaste(driver)
                .openPage()
                .createNewPaste(newPaste, syntaxHighlighting, pasteExpiration, pasteNameOrTitle)
                .getPastedCode();
        Assert.assertEquals(pasteText, newPaste
                .replace(", ", "\n")
                .replace("[","")
                .replace("]",""));
    }

    @Test
    public void testPageTitleIsEqualsToEnteredPasteName() {
        String pageTitle = new NewPaste(driver)
                .openPage()
                .createNewPaste(newPaste, syntaxHighlighting, pasteExpiration, pasteNameOrTitle)
                .getTitle();
        Assert.assertEquals(pageTitle, pasteNameOrTitle);
    }

    @Test
    public void testSyntaxHighlightedForBash() {
        String syntax = new NewPaste(driver)
                .openPage()
                .createNewPaste(newPaste, syntaxHighlighting, pasteExpiration, pasteNameOrTitle)
                .getSyntaxHighlighting();
        Assert.assertEquals(syntax, syntaxHighlighting);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
