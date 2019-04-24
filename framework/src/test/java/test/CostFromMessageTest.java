package test;

import model.ComputeEngine;
import org.testng.annotations.Test;
import page.EmailYourEstimateForm;
import page.GoogleCloudMainPage;
import page.TempEmailPage;
import service.ComputeEngineCreator;
import service.TestDataReader;
import util.StringUtils;
import util.Tabs;
import java.util.ArrayList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CostFromMessageTest extends CommonConditions {

    @Test
    public void testIfTotalPriceFromEmailEqualsToCalculated() {
        double expectedPrice = Double.parseDouble(TestDataReader.getTestData("testdata.engine.expected.price"));
//        double expectedPrice = 1187.77;
        ComputeEngine testComputeEngine = ComputeEngineCreator.computeEngineForEstimating();
        EmailYourEstimateForm formToSend = new GoogleCloudMainPage(driver)
                .openPage()
                .goToProductsPage()
                .goToPricingPage()
                .goToCalculatorPage()
                .fillPricingCalculatorForm(testComputeEngine)
                .invokeEmailForm();

        ArrayList<String> tabs = new Tabs(driver)
                .openNewTab(new TempEmailPage(driver).getPageURL());       //open https://lroid.com/ru/ in a new tab

        String emailAddress = new TempEmailPage(driver).getEmailAddress();

        new Tabs(driver).switchTab(tabs,0);     //switch to the tab with Email form

        formToSend.fillAndSendEmailFrom(emailAddress);

        new Tabs(driver).switchTab(tabs,1);     //switch to the tab with temp mail

        String totalPriceFromEmail = new TempEmailPage(driver)
                .openNewMessage()
                .getTotalPriceFromEmail();
        double actualTotalPrice = StringUtils.extractPriceFromString(totalPriceFromEmail);

        assertThat(actualTotalPrice, is(equalTo(expectedPrice)));
    }
}
