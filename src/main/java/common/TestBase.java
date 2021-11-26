package common;

import helpers.CreateTaskHelper;
import helpers.NavigationHelper;
import org.openqa.selenium.chrome.ChromeDriver;
import helpers.SignInHelper;

public class TestBase {
    protected AppManager appManager;
    protected ChromeDriver driver;

    public void setup() {
        System.out.println("setup");
        appManager = AppManager.getInstance();
        driver = appManager.getDriver();
    }

    protected void quitDriver() {
        driver.quit();
    }

    public NavigationHelper getNavigationHelper() {
        return appManager.getNavigationHelper();
    }

    public SignInHelper getLoginHelper() {
        return appManager.getLoginHelper();
    }

    public CreateTaskHelper getTodoHelper() {
        return appManager.getTodoHelper();
    }
}
