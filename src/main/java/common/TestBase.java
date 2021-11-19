package common;

import helpers.AppManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
    protected AppManager appManager;
    protected ChromeDriver driver;

    public void setup() {
        appManager = new AppManager();
        driver = appManager.getDriver();
    }

    protected void quitDriver() {
        driver.quit();
    }
}
