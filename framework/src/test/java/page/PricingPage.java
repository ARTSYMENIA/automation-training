package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PricingPage extends AbstractPage {
    private final String PAGE_URL = "https://cloud.google.com/pricing/";
    private final Logger logger = LogManager.getRootLogger();

    private final By calculators = By.xpath("//*[@track-name='pricingNav/calculators']");

    public PricingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public CalculatorPage goToCalculatorPage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(calculators))
                .click();
        logger.info("Calculator page opened");
        return new CalculatorPage(driver);
    }

    @Override
    public PricingPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }
}