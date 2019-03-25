package hardcore.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage extends AbstractPage {
    private final String PAGE_URL = "https://cloud.google.com/products/calculator/";

    @FindBy(xpath = "//md-tab-item/*[@title='Compute Engine']")
    private WebElement tabItemComputeEngine;

    @FindBy(id = "input_46")
    private WebElement inputNumberOfInstances;

    @FindBy(id = "input_47")
    private WebElement inputInstancesFor;

    @FindBy(id = "select_value_label_40")
    private WebElement dropdownOperatingSystem;

    //Operating System / Software: Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS
    @FindBy(id = "select_option_48")
    private WebElement optionOfOperatingSystem;

    @FindBy(id = "select_value_label_41")
    private WebElement dropdownVMClass;

    //VM Class: Regular
    @FindBy(id = "select_option_60")
    private WebElement optionOfVMClass;

    @FindBy(id = "select_value_label_42")
    private WebElement dropdownInstanceType;

    //Instance type: n1-standard-8    (vCPUs: 8, RAM: 30 GB)
    @FindBy(id = "select_option_70")
    private WebElement optionOfInstanceType;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement checkboxAddGPUs;

    @FindBy(id = "select_329")
    private WebElement dropdownNumberOfGPUs;

    //* Number of GPUs: 1
    @FindBy(id = "select_option_334")
    private WebElement optionOfNumberOfGPUs;

    @FindBy(id = "select_331")
    private WebElement dropdownGPUsType;

    //* GPU type: NVIDIA Tesla V100
    @FindBy(id = "select_option_341")
    private WebElement optionOfGPUsType;

    @FindBy(id = "select_95")
    private WebElement dropdownLocalSSD;

    //* Local SSD: 2x375 Gb
    @FindBy(id = "select_option_182")
    private WebElement optionOfLocalSSD;

    @FindBy(id = "select_97")
    private WebElement dropdownDatacenterLocation;

    //* Datacenter location: Frankfurt (europe-west3)
    @FindBy(id = "select_option_196")
    private WebElement optionOfDatacenterLocation;

    @FindBy(id = "select_102")
    private WebElement dropdownCommitedUsage;

    //* Commited usage: 1 Year
    @FindBy(id = "select_option_100")
    private WebElement optionOfCommitedUsage;

    @FindBy(xpath = "//button[text()='Add to Estimate']")
    private WebElement buttonAddToEstimate;

    @FindBy(id = "email_quote")
    private WebElement buttonEmailEstimate;

    @FindBy(xpath = "//form[@name='emailForm']//button[2]")
    private WebElement buttonSendEmailWithEstimateForm;

    @FindBy(xpath = "//form[@name='emailForm']//input[@type='email']")
    private WebElement inputEmail;

    private final By frameWithForm = By.id("idIframe");

    public CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    public void selectHiddenOptionFromDropdownList(WebElement dropdownList, WebElement option) {
        dropdownList.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(option))
                .click();
    }

    public CalculatorPage fillPricingCalculatorForm(String numberOfInstance, String instanceFor) {
        tabItemComputeEngine.click();
        inputNumberOfInstances.sendKeys(numberOfInstance);
        inputInstancesFor.sendKeys(instanceFor);
        selectHiddenOptionFromDropdownList(dropdownOperatingSystem, optionOfOperatingSystem);
        selectHiddenOptionFromDropdownList(dropdownVMClass, optionOfVMClass);
        selectHiddenOptionFromDropdownList(dropdownInstanceType, optionOfInstanceType);
        checkboxAddGPUs.click();
        selectHiddenOptionFromDropdownList(dropdownNumberOfGPUs, optionOfNumberOfGPUs);
        selectHiddenOptionFromDropdownList(dropdownGPUsType, optionOfGPUsType);
        selectHiddenOptionFromDropdownList(dropdownLocalSSD, optionOfLocalSSD);
        selectHiddenOptionFromDropdownList(dropdownDatacenterLocation, optionOfDatacenterLocation);
        selectHiddenOptionFromDropdownList(dropdownCommitedUsage, optionOfCommitedUsage);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(dropdownCommitedUsage));
        buttonAddToEstimate.click();
        return new CalculatorPage(driver);
    }

    public CalculatorPage invokeEmailForm() {
        buttonEmailEstimate.click();
        return new CalculatorPage(driver);
    }

    public CalculatorPage fillAndSendEmailFrom(String emailAddress) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameWithForm));
        inputEmail.sendKeys(emailAddress);
        buttonSendEmailWithEstimateForm.click();
        return new CalculatorPage(driver);
    }

    @Override
    public CalculatorPage openPage()
    {
        driver.navigate().to(PAGE_URL);
        return this;
    }
}
