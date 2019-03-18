import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.ArrayList;


public class Hardcore {
    private WebDriver driver;

    @BeforeTest
    public void testPreparations() {
        driver = new ChromeDriver();
        driver.get("https://cloud.google.com/");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@track-name='exploreProducts']")));
        driver.manage().window().maximize();
        //2. Нажать на кнопку EXPLORE ALL PRODUCTS
        driver.findElement(By.xpath("//*[@track-name='exploreProducts']")).click();
        //3. Нажать на кнопку SEE PRICING
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@track-name='seePricing']")));
        driver.findElement(By.xpath("//*[@track-name='seePricing']")).click();
        //4. В панели слева выбрать Calculators
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@track-name='pricingNav/calculators']")));
        driver.findElement(By.xpath("//*[@track-name='pricingNav/calculators']")).click();
        //5. Активировать раздел COMPUTE ENGINE вверху страницы
        new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("idIframe")));
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
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//md-select[@placeholder='Number of GPUs']//md-select-value")));
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
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("compute")));
        //8. Выбрать пункт EMAIL ESTIMATE
        driver.findElement(By.id("email_quote")).click();
        //9. В новой вкладке открыть https://10minutemail.com
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://10minutemail.com");
        //10. Скопировать почтовый адрес сгенерированный в 10minutemail
        String tempEmail = driver.findElement(By.id("mailAddress")).getAttribute("value");
        //11. Вернуться в калькулятор, в поле Email ввести адрес из предыдущего пункта
        driver.switchTo().window(tabs.get(0));
        new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("idIframe")));
        driver.findElement(By.xpath("//form[@name='emailForm']//input[@type='email']")).sendKeys(tempEmail);
        //12. Нажать SEND EMAIL
        driver.findElement(By.xpath("//form[@name='emailForm']//button[contains(text(),'Send Email')]")).click();
        //13. Дождаться письма с рассчетом стоимости и проверить что Total Estimated Monthly Cost в письме совпадает с тем, что отображается в калькуляторе
        driver.switchTo().window(tabs.get(1));
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.id("messagesList")));
        driver.findElement(By.id("messagesList")).click();
    }

    @Test
    public void testIfTotalPriceInEmailIsEqualsToCalculated() {
        String priceFromEmail = driver.findElement(By.cssSelector("#mobilepadding > td > table > tbody > tr:nth-child(2) > td:nth-child(2) > h3")).getText();
        String calculatedPrice = "USD 1,331.77";
        Assert.assertEquals(priceFromEmail, calculatedPrice);
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }
}

