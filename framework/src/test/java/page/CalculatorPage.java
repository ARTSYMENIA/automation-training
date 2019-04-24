package page;

import model.ComputeEngine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.ComputeEngineCreator;

public class CalculatorPage extends AbstractPage {
    private final String PAGE_URL = "https://cloud.google.com/products/calculator/";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//md-tab-item/*[@title='Compute Engine']")
    private WebElement tabItemComputeEngine;

    @FindBy(name = "quantity")
    private WebElement inputNumberOfInstances;

    @FindBy(name = "label")
    private WebElement inputInstancesFor;

    @FindBy(id = "select_61")
    private WebElement dropdownOperatingSystem;

    @FindBy(id = "select_65")
    private WebElement dropdownVMClass;

    @FindBy(id = "select_96")
    private WebElement dropdownInstanceType;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement checkboxAddGPUs;

    @FindBy(id = "select_332")
    private WebElement dropdownNumberOfGPUs;

    @FindBy(id = "select_334")
    private WebElement dropdownGPUsType;

    @FindBy(id = "select_98")
    private WebElement dropdownLocalSSD;

    @FindBy(id = "select_100")
    private WebElement dropdownDatacenterLocation;

    @FindBy(id = "select_105")
    private WebElement dropdownCommitedUsage;

    @FindBy(xpath = "//button[text()='Add to Estimate']")
    private WebElement buttonAddToEstimate;

    @FindBy(id = "email_quote")
    private WebElement buttonEmailEstimate;

    private final By frame = By.id("idIframe");

    public CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String buildLocator (String valueForChoosingFromDropdownList) {
        return  "//*[contains(text(),'"
                +valueForChoosingFromDropdownList+"')]/ancestor::md-option";
    }

    public void selectFromDropdownList(WebElement dropdownList, String option) {
        dropdownList.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                        .attributeToBe(dropdownList, "aria-expanded", "true"));
        int size = driver.findElements(By.xpath(buildLocator(option))).size();
        driver.findElements(By.xpath(buildLocator(option))).get(size-1).click();
    }

    public CalculatorPage fillPricingCalculatorForm(ComputeEngine computeEngine){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
        tabItemComputeEngine.click();
        inputNumberOfInstances.sendKeys(computeEngine.getNumberOfInstances());
        inputInstancesFor.sendKeys(computeEngine.getInstancesFor());
        selectFromDropdownList(dropdownOperatingSystem, computeEngine.getOperatingSystem());
        selectFromDropdownList(dropdownVMClass, computeEngine.getVmClass());
        selectFromDropdownList(dropdownInstanceType, computeEngine.getInstanceType());
        if (computeEngine.addGPUs()) {
            checkboxAddGPUs.click();
            selectFromDropdownList(dropdownNumberOfGPUs, computeEngine.getNumberOfGPUs());
            selectFromDropdownList(dropdownGPUsType, computeEngine.getGpuType());
        }
        selectFromDropdownList(dropdownLocalSSD, computeEngine.getLocalSSD());
        selectFromDropdownList(dropdownDatacenterLocation, computeEngine.getDatacenterLocation());
        selectFromDropdownList(dropdownCommitedUsage, computeEngine.getCommittedUsage());
        logger.info("Form filled with the following data\n"+computeEngine.toString());
        return this;
    }

    public EmailYourEstimateForm invokeEmailForm() {
        buttonAddToEstimate.click();
        buttonEmailEstimate.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.name("emailForm")));
        return new EmailYourEstimateForm(driver);
    }

    @Override
    public CalculatorPage openPage()
    {
        driver.navigate().to(PAGE_URL);
        return this;
    }
}
