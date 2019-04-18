package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailYourEstimateForm extends AbstractPage {
    private final String BASE_URL = "https://lroid.com/ru/";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//form[@name='emailForm']//button[2]")
    private WebElement buttonSendEmailWithEstimateForm;

    @FindBy(xpath = "//form[@name='emailForm']//input[@type='email']")
    private WebElement inputEmail;

    private final By frameWithForm = By.id("idIframe");

    public EmailYourEstimateForm(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    public EmailYourEstimateForm fillAndSendEmailFrom(String emailAddress) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameWithForm));
        inputEmail.sendKeys(emailAddress);
        buttonSendEmailWithEstimateForm.click();
        return this;
    }

    @Override
    public AbstractPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }
}
