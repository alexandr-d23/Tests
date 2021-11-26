package helpers;

import common.AppManager;
import model.TaskData;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import model.UserData;

public class CreateTaskHelper {
    private AppManager appManager;
    private ChromeDriver driver;

    public CreateTaskHelper(AppManager appManager) {
        this.appManager = appManager;
        this.driver = appManager.getDriver();
    }

    public void setup() {
        appManager.getLoginHelper().login(new UserData(
                "d23.alexandr",
                "Test1"
        ));
    }

    public int createTask(TaskData data) {
        setup();
        return addTask(data);
    }

    private int addTask(TaskData data) {
        driver.get("http://todolist.ru/todolist/index.html");
        int beforeSize =  driver.findElement(By.id("cat_list")).findElements(By.xpath("//li")).size();
        driver.findElement(By.linkText("Создать список")).click();
        driver.findElement(By.id("to_do_list_name")).sendKeys(data.getName());
        driver.findElement(By.id("to_do_list_description")).click();
        driver.findElement(By.id("to_do_list_description")).sendKeys(data.getDescription());
        driver.findElement(By.cssSelector(".submit")).click();
        return beforeSize;
    }

    public int getSizeAfter() {
        driver.get("http://todolist.ru/todolist/index.html");
        return driver.findElement(By.id("cat_list")).findElements(By.xpath("//li")).size();
    }

    public void logout() {
        driver.get("http://todolist.ru/user/logout.html");
    }

}
