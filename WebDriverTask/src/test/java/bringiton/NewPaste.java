package bringiton;

import icanwin.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewPaste extends AbstractPage {
    private final String BASE_URL = "https://pastebin.com";

    @FindBy(id = "paste_code")
    private WebElement inputNewPaste;

    @FindBy(name = "paste_format")
    private WebElement selectSyntax;

    @FindBy(name = "paste_expire_date")
    private WebElement selectPasteExpiration;

    @FindBy(name = "paste_name")
    private WebElement inputPasteNameOrTitle;

    @FindBy(id = "submit")
    private WebElement buttonSubmitPaste;

    public NewPaste(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public NewPaste createNewPaste(String pasteContent, String pasteSyntax, String pasteExpirationValue, String pasteName) {
        inputNewPaste.sendKeys(pasteContent);
        Select dropdownSelectSyntax = new Select(selectSyntax);
        dropdownSelectSyntax.selectByVisibleText(pasteSyntax);
        Select dropdownSelectExpirationDate = new Select(selectPasteExpiration);
        dropdownSelectExpirationDate.selectByVisibleText(pasteExpirationValue);
        inputPasteNameOrTitle.sendKeys(pasteName);
        buttonSubmitPaste.click();
        return this;
    }

    @Override
    public NewPaste openPage()
    {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public String getTitle() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("head")));
        return driver.getTitle();
    }

    public String getSyntaxHighlighting() {
        WebElement syntaxIndicator = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='code_buttons']/descendant::*[contains(text(),'Bash')]")));
        return syntaxIndicator.getText();
    }

    public String getPastedCode() {
        WebElement fieldWithPastedCode = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("paste_code")));
        return fieldWithPastedCode.getText();
    }
}
