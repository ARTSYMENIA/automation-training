import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HurtMePlenty {
    private WebDriver driver;

    @BeforeTest
    public void testPreparations() {
        driver = new ChromeDriver();
        driver.get("https://cloud.google.com/");
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@track-name='exploreProducts']")));
        driver.manage().window().maximize();
        //2. Нажать на кнопку EXPLORE ALL PRODUCTS
        driver.findElement(By.xpath("//*[@track-name='exploreProducts']")).click();
        //3. Нажать на кнопку SEE PRICING
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@track-name='seePricing']")));
        driver.findElement(By.xpath("//*[@track-name='seePricing']")).click();
        //4. В панели слева выбрать Calculators
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@track-name='pricingNav/calculators']")));
        driver.findElement(By.xpath("//*[@track-name='pricingNav/calculators']")).click();
        //5. Активировать раздел COMPUTE ENGINE вверху страницы
        new WebDriverWait(driver,15).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("idIframe")));
        //presenceOfElementLocated(By.xpath("//md-tab-item/*[@title='Compute Engine']")));
        driver.findElement(By.xpath("//md-tab-item/*[@title='Compute Engine']")).click();
        //6. Заполнить форму следующими данными:
        //Number of instances: 4
        driver.findElement(By.id("input_46")).sendKeys("4");
        //What are these instances for?: оставить пустым
        driver.findElement(By.id("input_47")).sendKeys("");
        //Operating System / Software: Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS
        driver.findElement(By.id("select_value_label_40")).click();
        driver.findElement(By.xpath("//*[@id='select_option_48']/*[text()='Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS']")).click();
        //VM Class: Regular
        driver.findElement(By.id("select_value_label_41")).click();
        driver.findElement(By.xpath("//*[@id='select_option_60']/*[text()='Regular']")).click();
        //Instance type: n1-standard-8    (vCPUs: 8, RAM: 30 GB)
        driver.findElement(By.id("select_value_label_42")).click();
        driver.findElement(By.xpath("//*[@id='select_option_70']/*[contains(text(),'n1-standard-8')]")).click();
        //Выбрать Add GPUs
        driver.findElement(By.xpath("//md-checkbox[@aria-label='Add GPUs']")).click();
        //* Number of GPUs: 1
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//md-select[@placeholder='Number of GPUs']//md-select-value")));
        driver.findElement(By.xpath("//md-select[@placeholder='Number of GPUs']")).click();
        driver.findElement(By.xpath("//*[@id='select_container_330']/md-select-menu//*[@value='1']")).click();
        //* GPU type: NVIDIA Tesla V100
        driver.findElement(By.xpath("//md-select[@placeholder='GPU type']")).click();
        driver.findElement(By.id("select_option_341")).click();
        //* Local SSD: 2x375 Gb
        driver.findElement(By.xpath("//md-select[@placeholder='Local SSD']")).click();
        driver.findElement(By.id("select_option_183")).click();
        //* Datacenter location: Frankfurt (europe-west3)
        driver.findElement(By.xpath("//md-select[@placeholder='Datacenter location']")).click();
        driver.findElement(By.id("select_option_196")).click();
        //* Commited usage: 1 Year
        driver.findElement(By.xpath("//md-select[@placeholder='Committed usage']")).click();
        driver.findElement(By.id("select_option_100")).click();
        //7. Нажать Add to Estimate
        driver.findElement(By.xpath("//*[@id='mainForm']//button[text()='Add to Estimate']")).click();
        new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.id("compute")));
    }
    @Test
    public void testTotalPricePerMonthIsEqualsToExpected() {
        String expectedPricePerMonth = "Total Estimated Cost: USD 1,331.77 per 1 month";
        Assert.assertEquals(expectedPricePerMonth, driver.findElement(By.xpath("//*[@id='resultBlock']//*[contains(text(),'Total Estimated Cost')]")).getText());
    }

    @Test
    public void testValueOfVMClassField() {
        String valueOfVMClassField = driver.findElement(By.id("select_value_label_41")).getText().toLowerCase();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='resultBlock']//*[contains(text(),'"+valueOfVMClassField+"')]")).isDisplayed());
    }

    @Test
    public void testValueOfInstanceTypeField() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='resultBlock']//*[contains(text(),'Instance type: n1-standard-8')]")).isDisplayed());
    }

    @Test
    public void testValueOfRegionField() {
        String[] valueOfRegionField = " ".split(driver.findElement(By.id("select_option_196")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='resultBlock']//*[contains(text(),'"+valueOfRegionField[0]+"')]")).isDisplayed());
    }

    @Test
    public void testValueOfLocalSSDField() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='resultBlock']//*[contains(text(),'Total available local SSD space 3x375 GB')]")).isDisplayed());
    }

    @Test
    public void testValueOfCommitmentTermField() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='resultBlock']//*[contains(text(),'Commitment term: 1 Year')]")).isDisplayed());
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }
}
