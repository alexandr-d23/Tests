package helpers;

import create.CreateTaskHelper;
import kotlin.jvm.Volatile;
import org.openqa.selenium.chrome.ChromeDriver;
import signin.SignInHelper;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AppManager {
    private ChromeDriver driver;
    private String baseUrl;
    private String loginUrl;

    private NavigationHelper navigationHelper;
    private SignInHelper loginHelper;
    private CreateTaskHelper todoHelper;

    private AppManager() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        this.driver = new ChromeDriver();
        this.baseUrl = "http://todolist.ru/";
        this.loginUrl = "http://todolist.ru/user/login.html";
        this.navigationHelper = new NavigationHelper(this);
        this.loginHelper = new SignInHelper(this);
        this.todoHelper = new CreateTaskHelper(this);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Volatile
    private static AppManager appManager = null;

    public static AppManager getInstance() {
        synchronized(AppManager.class) {
            if(appManager == null){
                appManager = new AppManager();
            }
            return appManager;
        }
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
