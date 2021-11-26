package common;

import helpers.CreateTaskHelper;
import helpers.EditTaskHelper;
import helpers.NavigationHelper;
import helpers.SignInHelper;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AppManager {
    private ChromeDriver driver;
    private String baseUrl;
    private String loginUrl;

    private NavigationHelper navigationHelper;
    private SignInHelper loginHelper;
    private CreateTaskHelper todoHelper;
    private EditTaskHelper editHelper;

    private AppManager() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        this.driver = new ChromeDriver();
        this.baseUrl = "http://todolist.ru/";
        this.loginUrl = "http://todolist.ru/user/login.html";
        this.navigationHelper = new NavigationHelper(this);
        this.loginHelper = new SignInHelper(this);
        this.todoHelper = new CreateTaskHelper(this);
        this.editHelper = new EditTaskHelper(this);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }


    private static ThreadLocal<AppManager> threadLocal = new ThreadLocal<>();

    public static AppManager getInstance() {
        System.out.println("getInstance appmanager: " + threadLocal.get());
        synchronized(AppManager.class) {
            AppManager appManager = threadLocal.get();
            if(appManager == null){
                appManager = new AppManager();
                threadLocal.set(appManager);
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

    public EditTaskHelper getEditHelper() {
        return editHelper;
    }

    public CreateTaskHelper getTodoHelper() {
        return todoHelper;
    }
}
