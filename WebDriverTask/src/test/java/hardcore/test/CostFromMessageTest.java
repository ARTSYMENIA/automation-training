package hardcore.test;

import hardcore.page.CalculatorPage;
import hardcore.page.MainPage;
import hardcore.page.TempMailPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class CostFromMessageTest extends TestUtils {

    @Test
    public void testIfTotalPriceFromEmailEqualsToCalculated() {
        String calculatedPrice = "USD 1,187.77";
        String numberOfInstance = "4";
        String instanceFor = "";

        new MainPage(driver).openPage().goToCalculatorPage();
        CalculatorPage calculatorPage = new CalculatorPage(driver)
                .fillPricingCalculatorForm(numberOfInstance, instanceFor)
                .invokeEmailForm();
        //open https://lroid.com/ru/ in a new tab
        ArrayList<String> tabs = new Tabs(driver).openNewTab(new TempMailPage(driver).getPAGE_URL());
        String emailAddress = new TempMailPage(driver).getEmailAddress();
        //switch to the tab with Email form
        new Tabs(driver).switchTab(tabs,0);
        calculatorPage.fillAndSendEmailFrom(emailAddress);
        //switch to the tab with temp mail
        new Tabs(driver).switchTab(tabs,1);
        String totalPriceFromEmail = new TempMailPage(driver).openNewMessage().getTotalPriceFromEmail();

        Assert.assertEquals(totalPriceFromEmail, calculatedPrice);
    }
}
