package signin;

import common.TestBase;
import org.openqa.selenium.By;

public class SignInHelper extends TestBase {

    public void login(UserData data) {
        appManager.getNavigationHelper().openLoginPage();
        driver.findElement(By.id("user_login")).click();
        driver.findElement(By.id("user_login")).sendKeys(data.getLogin());
        driver.findElement(By.id("user_password")).click();
        driver.findElement(By.id("user_password")).sendKeys(data.getPassword());
        driver.findElement(By.cssSelector(".submit")).click();
    }

    protected void signIn(UserData data){
        appManager.getNavigationHelper().openHomePage();
        appManager.getNavigationHelper().openLoginPage();
        login(data);
    }
}
