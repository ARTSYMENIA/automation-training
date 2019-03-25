package hardcore.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage {

    private final String BASE_URL = "https://cloud.google.com/";
    private final By buttonExploreAllProducts = By.xpath("//*[@track-name='exploreProducts']");
    private final By buttonSeePricing = By.xpath("//*[@track-name='seePricing']");
    private final By buttonCalculator = By.xpath("//*[@track-name='pricingNav/calculators']");
    private final By frameWithForm = By.id("idIframe");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage goToCalculatorPage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(buttonExploreAllProducts))
                .click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(buttonSeePricing))
                .click();
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(buttonCalculator))
                .click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameWithForm));
        return new MainPage(driver);
    }

    @Override
    public MainPage openPage()
    {
        driver.navigate().to(BASE_URL);
        return this;
    }
}
