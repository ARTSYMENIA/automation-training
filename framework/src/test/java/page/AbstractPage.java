package page;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    WebDriver driver;
    final int WAIT_TIMEOUT_SECONDS = 10;

    AbstractPage(WebDriver driver)
    {
        this.driver = driver;
    }

    protected abstract AbstractPage openPage();
}
