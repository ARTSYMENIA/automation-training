package hardcore.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TempMailPage extends AbstractPage {

    private final String PAGE_URL = "https://lroid.com/ru/";

    @FindBy(id = "eposta_adres")
    private WebElement mailAddress;

    @FindBy(xpath = "//*[@id='mobilepadding']/descendant::*[contains(text(),'USD')][3]")
    private WebElement totalPrice;

    private final By newMessageGot =By.xpath("//*[contains(@id,'mail')]/a");

    public String getPAGE_URL() {
        return PAGE_URL;
    }

    public TempMailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    public String getEmailAddress() {
        WebElement emailAddress = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(mailAddress));
        return emailAddress.getAttribute("value");
    }

    public TempMailPage openNewMessage() {
        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.presenceOfElementLocated(newMessageGot))
                .click();
        return new TempMailPage(driver);
    }

    public String getTotalPriceFromEmail() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframe")));
        return totalPrice.getText();
    }

    @Override
    public TempMailPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }
}
