package hertmeplenty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PricingCalculatorTest {
    private WebDriver driver;
    private String numberOfInstance = "4";
    private String instanceFor = "";

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testTotalPricePerMonthIsEqualsToExpected() {
        String totalPrice = new PricingCalculator(driver)
                .openPage()
                .goToPricingCalculatorPage()
                .fillPricingCalculatorForm(numberOfInstance, instanceFor)
                .getTotalPricePerMonth();
        Assert.assertEquals(totalPrice, "Total Estimated Cost: USD 1,187.77 per 1 month");
    }

    @Test
    public void testValueConformityOfVMClassField() {
        String fieldName = "VM class";
        String valueOfVMClassFromResultBlock = new PricingCalculator(driver)
                .openPage()
                .goToPricingCalculatorPage()
                .fillPricingCalculatorForm(numberOfInstance, instanceFor)
                .getElementFromResultBlock(fieldName)
                .getText();
        Assert.assertTrue(valueOfVMClassFromResultBlock.contains("regular"));
     }

     @Test
     public void testValueConformityOfInstanceType() {
        String fieldName = "Instance type";
         String valueOfVMClassFromResultBlock = new PricingCalculator(driver)
                 .openPage()
                 .goToPricingCalculatorPage()
                 .fillPricingCalculatorForm(numberOfInstance, instanceFor)
                 .getElementFromResultBlock(fieldName)
                 .getText();
         Assert.assertTrue(valueOfVMClassFromResultBlock.contains("n1-standard-8"));
     }

    @Test
    public void testValueConformityOfRegion() {
        String fieldName = "Region";
        String valueOfVMClassFromResultBlock = new PricingCalculator(driver)
                .openPage()
                .goToPricingCalculatorPage()
                .fillPricingCalculatorForm(numberOfInstance, instanceFor)
                .getElementFromResultBlock(fieldName)
                .getText();
        Assert.assertTrue(valueOfVMClassFromResultBlock.contains("Frankfurt"));
    }

    @Test
    public void testValueConformityOfLocalSSD() {
        String fieldName = "local SSD";
        String valueOfVMClassFromResultBlock = new PricingCalculator(driver)
                .openPage()
                .goToPricingCalculatorPage()
                .fillPricingCalculatorForm(numberOfInstance, instanceFor)
                .getElementFromResultBlock(fieldName)
                .getText();
        Assert.assertTrue(valueOfVMClassFromResultBlock.contains("2x375 GB"));
    }

    @Test
    public void testValueConformityOfCommitmentTerm() {
        String fieldName = "Commitment term";
        String valueOfVMClassFromResultBlock = new PricingCalculator(driver)
                .openPage()
                .goToPricingCalculatorPage()
                .fillPricingCalculatorForm(numberOfInstance, instanceFor)
                .getElementFromResultBlock(fieldName)
                .getText();
        Assert.assertTrue(valueOfVMClassFromResultBlock.contains("1 Year"));
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
