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
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CostFromMessageTest extends CommonConditions {

    @Test
    public void testIfTotalPriceFromEmailEqualsToCalculated() {
        double expectedPrice = Double.parseDouble(TestDataReader.getTestData("testdata.engine.expected.price"));
        ComputeEngine testComputeEngine = ComputeEngineCreator.computeEngineForEstimating();

        EmailYourEstimateForm formToSend = new GoogleCloudMainPage(driver)
                .openPage()
                .goToProductsPage()
                .goToPricingPage()
                .goToCalculatorPage()
                .fillPricingCalculatorForm(testComputeEngine)
                .invokeEmailForm();

        TempEmailPage tempEmailPage = new TempEmailPage(driver);
        Tabs tabs = new Tabs(driver);

        tabs.openNewTab(tempEmailPage.getPageURL());       //open https://lroid.com/ru/ in a new tab

        String emailAddress = tempEmailPage.getEmailAddress();

        tabs.switchToTheFirstTab();     //switch to the tab with Email form

        formToSend.fillAndSendEmailFrom(emailAddress);

        tabs.switchToTheSecondTab();     //switch to the tab with temp mail

        String totalPriceFromEmail = tempEmailPage
                .openNewMessage()
                .getTotalPriceFromEmail();
        double actualTotalPrice = StringUtils.extractPriceFromString(totalPriceFromEmail);

        assertThat(actualTotalPrice, is(equalTo(expectedPrice)));
    }
}
