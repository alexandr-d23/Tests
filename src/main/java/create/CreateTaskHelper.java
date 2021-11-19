package create;

import common.TestBase;
import org.openqa.selenium.By;
import signin.UserData;

public class CreateTaskHelper extends TestBase {

    @Override
    public void setup() {
        super.setup();
        appManager.getLoginHelper().login(new UserData(
                "d23.alexandr",
                "Test1"
        ));
    }

    public void createTask(TaskData data){
        driver.get("http://todolist.ru/todolist/index.html");
        driver.findElement(By.linkText("Создать список")).click();
        driver.findElement(By.id("to_do_list_name")).sendKeys(data.getName());
        driver.findElement(By.id("to_do_list_description")).click();
        driver.findElement(By.id("to_do_list_description")).sendKeys(data.getDescription());
        driver.findElement(By.cssSelector(".submit")).click();
    }

}
