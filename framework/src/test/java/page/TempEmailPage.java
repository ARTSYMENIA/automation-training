package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TempEmailPage extends AbstractPage{

    private final String PAGE_URL = "https://lroid.com/ru/";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(id = "eposta_adres")
    private WebElement mailAddress;

    @FindBy(xpath = "//*[@id='mobilepadding']/descendant::*[contains(text(),'USD')][3]")
    private WebElement totalPrice;

    private final By newMessageGot = By.xpath("//*[contains(@id,'mail')]/a");

    public String getPAGE_URL() {
        return PAGE_URL;
    }

    public TempEmailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    public String getEmailAddress() {
        WebElement emailAddress = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(mailAddress));
        String tempEmail = emailAddress.getAttribute("value");
        logger.info("Temp email is got - "+tempEmail);
        return tempEmail;
    }

    public TempEmailPage openNewMessage() {
        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.presenceOfElementLocated(newMessageGot))
                .click();
        return this;
    }

    public String getTotalPriceFromEmail() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframe")));
        String totalPriceFromEmail = totalPrice.getText();
        logger.info("Total estimated price from email - "+totalPriceFromEmail);
        return totalPriceFromEmail;
    }

    @Override
    public TempEmailPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }
}
