package create;

import helpers.AppManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import signin.UserData;

public class CreateTaskHelper {
    private AppManager appManager;
    private ChromeDriver driver;

    public CreateTaskHelper(AppManager appManager){
        this.appManager = appManager;
        this.driver = appManager.getDriver();
    }

    public void setup() {
        appManager.getLoginHelper().login(new UserData(
                "d23.alexandr",
                "Test1"
        ));
    }

    public void createTask(TaskData data){
        setup();
        driver.get("http://todolist.ru/todolist/index.html");
        driver.findElement(By.linkText("Создать список")).click();
        driver.findElement(By.id("to_do_list_name")).sendKeys(data.getName());
        driver.findElement(By.id("to_do_list_description")).click();
        driver.findElement(By.id("to_do_list_description")).sendKeys(data.getDescription());
        driver.findElement(By.cssSelector(".submit")).click();
    }

    public void logout(){
        driver.get("http://todolist.ru/user/logout.html");
    }

}
