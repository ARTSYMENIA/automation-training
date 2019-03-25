package hertmeplenty;

import icanwin.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PricingCalculator extends AbstractPage {

    private final String BASE_URL = "https://cloud.google.com/";

    @FindBy(xpath = "//*[@track-name='exploreProducts']")
    private WebElement buttonExploreAllProducts;

    @FindBy(xpath = "//*[@track-name='seePricing']")
    private WebElement buttonSeePricing;

    @FindBy(xpath = "//*[@track-name='pricingNav/calculators']")
    private WebElement buttonCalculator;

    @FindBy(xpath = "//md-tab-item/*[@title='Compute Engine']")
    private WebElement tabItemComputeEngine;

    @FindBy(id = "input_46")
    private WebElement inputNumberOfInstances;

    @FindBy(id = "input_47")
    private WebElement inputInstancesFor;

    @FindBy(id = "select_value_label_40")
    private WebElement selectOperatingSystem;

    //Operating System / Software: Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS
    @FindBy(id = "select_option_48")
    private WebElement optionOfOperatingSystem;

    @FindBy(id = "select_value_label_41")
    private WebElement selectVMClass;

    //VM Class: Regular
    @FindBy(id = "select_option_60")
    private WebElement optionOfVMClass;

    @FindBy(id = "select_value_label_42")
    private WebElement selectInstanceType;

    //Instance type: n1-standard-8    (vCPUs: 8, RAM: 30 GB)
    @FindBy(id = "select_option_70")
    private WebElement optionOfInstanceType;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement checkboxAddGPUs;

    @FindBy(id = "select_329")
    private WebElement selectNumberOfGPUs;

    //* Number of GPUs: 1
    @FindBy(id = "select_option_334")
    private WebElement optionOfNumberOfGPUs;

    @FindBy(id = "select_331")
    private WebElement selectGPUsType;

    //* GPU type: NVIDIA Tesla V100
    @FindBy(id = "select_option_341")
    private WebElement optionOfGPUsType;

    @FindBy(id = "select_95")
    private WebElement selectLocalSSD;

    //* Local SSD: 2x375 Gb
    @FindBy(id = "select_option_182")
    private WebElement optionOfLocalSSD;

    @FindBy(id = "select_97")
    private WebElement selectDatacenterLocation;

    //* Datacenter location: Frankfurt (europe-west3)
    @FindBy(id = "select_option_196")
    private WebElement optionOfDatacenterLocation;

    @FindBy(id = "select_102")
    private WebElement selectCommitedUsage;

    //* Commited usage: 1 Year
    @FindBy(id = "select_option_100")
    private WebElement optionOfCommitedUsage;

    @FindBy(xpath = "//button[text()='Add to Estimate']")
    private WebElement buttonAddToEstimate;

    public PricingCalculator(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    public PricingCalculator goToPricingCalculatorPage() {
        buttonExploreAllProducts.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(buttonSeePricing));
        buttonSeePricing.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(buttonCalculator));
        buttonCalculator.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("idIframe")));
        return new PricingCalculator(driver);
    }

    public PricingCalculator fillPricingCalculatorForm(String numberOfInstance, String instanceFor) {
        tabItemComputeEngine.click();
        inputNumberOfInstances.sendKeys(numberOfInstance);
        inputInstancesFor.sendKeys(instanceFor);
        selectOperatingSystem.click();
        optionOfOperatingSystem.click();
        selectVMClass.click();
        optionOfVMClass.click();
        selectInstanceType.click();
        optionOfInstanceType.click();
        checkboxAddGPUs.click();
        selectNumberOfGPUs.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(optionOfNumberOfGPUs));
        optionOfNumberOfGPUs.click();
        selectGPUsType.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(optionOfGPUsType));
        optionOfGPUsType.click();
        selectLocalSSD.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(optionOfLocalSSD));
        optionOfLocalSSD.click();
        selectDatacenterLocation.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(optionOfDatacenterLocation));
        optionOfDatacenterLocation.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(selectCommitedUsage));
        selectCommitedUsage.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(optionOfCommitedUsage));
        optionOfCommitedUsage.click();
        buttonAddToEstimate.click();
        return new PricingCalculator(driver);
    }

    @Override
    public PricingCalculator openPage()
    {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public String getTotalPricePerMonth() {
        WebElement totalPrice = new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.
                        xpath("//*[@id='resultBlock']//*[contains(text(),'Total Estimated Cost')]")));
        return totalPrice.getText();
    }

    public WebElement getElementFromResultBlock (String fieldOfInstances) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .id("compute")));
        return driver.findElement(By.xpath("//*[@id='resultBlock']//*[contains(text(),'"+fieldOfInstances+"')]"));
    }
}
