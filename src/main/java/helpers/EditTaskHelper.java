package helpers;

import model.TaskData;
import common.AppManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import model.UserData;

public class EditTaskHelper {
    private AppManager appManager;
    private ChromeDriver driver;

    public EditTaskHelper(AppManager appManager) {
        this.appManager = appManager;
        this.driver = appManager.getDriver();
    }

    public void setup() {
        appManager.getLoginHelper().login(new UserData(
                "d23.alexandr",
                "Test1"
        ));
    }

    public void editTask(TaskData data) {
        setup();
        edit(data);
    }

    private void edit(TaskData data) {
        driver.get("http://todolist.ru/todolist/edit/id/20081.html");
        driver.findElement(By.id("to_do_list_name")).click();
        driver.findElement(By.id("to_do_list_name")).clear();
        driver.findElement(By.id("to_do_list_name")).sendKeys(data.getName());
        driver.findElement(By.cssSelector(".submit")).click();
    }

    public String getName() {
        return driver.findElement(By.xpath("//a[@href='/task/list/id/20081.html']")).getText();
    }

    public void logout() {
        driver.get("http://todolist.ru/user/logout.html");
    }

}