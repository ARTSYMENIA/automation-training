package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends AbstractPage{
    private final String PAGE_URL = "https://cloud.google.com/products/";
    private final Logger logger = LogManager.getRootLogger();

    private final By buttonSeePricing = By.xpath("//*[@track-name='seePricing']");
    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    public PricingPage goToPricingPage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(buttonSeePricing))
                .click();
        logger.info("Pricing page opened");
        return new PricingPage(driver);
    }

    @Override
    public ProductsPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }
}
