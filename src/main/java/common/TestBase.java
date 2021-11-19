package common;

import create.CreateTaskHelper;
import helpers.AppManager;
import helpers.NavigationHelper;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import signin.SignInHelper;

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
