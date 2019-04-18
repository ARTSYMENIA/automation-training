package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleCloudMainPage extends AbstractPage {
    private final String BASE_URL = "https://cloud.google.com/";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//*[@track-name='seeProducts']")
    private WebElement buttonSeeProducts;

    public GoogleCloudMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    public ProductsPage goToProductsPage() {
        buttonSeeProducts.click();
        return new ProductsPage(driver);
    }

    @Override
    public GoogleCloudMainPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }
}
