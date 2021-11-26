package helpers;

import common.AppManager;
import model.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignInHelper {

    private AppManager appManager;
    private ChromeDriver driver;

    public SignInHelper(AppManager appManager){
        this.appManager = appManager;
        this.driver = appManager.getDriver();
    }

    public void login(UserData data) {
        appManager.getNavigationHelper().openLoginPage();
        driver.findElement(By.id("user_login")).click();
        driver.findElement(By.id("user_login")).sendKeys(data.getLogin());
        driver.findElement(By.id("user_password")).click();
        driver.findElement(By.id("user_password")).sendKeys(data.getPassword());
        driver.findElement(By.cssSelector(".submit")).click();
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
}
