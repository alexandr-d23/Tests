package helpers;

import create.CreateTaskHelper;
import org.openqa.selenium.chrome.ChromeDriver;
import signin.SignInHelper;

public class AppManager {
    private ChromeDriver driver;
    private String baseUrl;
    private String loginUrl;

    private NavigationHelper navigationHelper;
    private SignInHelper loginHelper;
    private CreateTaskHelper todoHelper;

    public AppManager() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        this.driver = new ChromeDriver();
        this.baseUrl = "http://todolist.ru/";
        this.loginUrl = "http://todolist.ru/user/login.html";
        this.navigationHelper = new NavigationHelper(this);
        this.loginHelper = new SignInHelper();
        this.todoHelper = new CreateTaskHelper();
    }

    public ChromeDriver getDriver() {
        return driver;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public SignInHelper getLoginHelper() {
        return loginHelper;
    }

    public CreateTaskHelper getTodoHelper() {
        return todoHelper;
    }
}
