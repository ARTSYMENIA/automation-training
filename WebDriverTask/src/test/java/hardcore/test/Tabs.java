package hardcore.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class Tabs {
    private WebDriver driver;

    public Tabs(WebDriver driver) {
        this.driver = driver;
    }

    public ArrayList<String> openNewTab(String url){
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(url);
        return tabs;
    }

    public void switchTab(ArrayList<String> tabs, int tabNumber){
        driver.switchTo().window(tabs.get(tabNumber));
    }
}
