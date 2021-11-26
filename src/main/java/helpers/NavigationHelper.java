package helpers;

import common.AppManager;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(AppManager appManager) {
        this.driver = appManager.getDriver();
        this.baseUrl = appManager.getBaseUrl();
        this.loginUrl = appManager.getLoginUrl();
    }

    public void openHomePage() {
        driver.get(baseUrl);
    }

    public void openLoginPage() {
        // driver.findElement(By.linkText("Вход")).click();
        driver.get(loginUrl);
    }

}
