package common;

import create.TaskData;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import signin.UserData;

public class TestBase {

    protected ChromeDriver driver;
    protected String baseUrl;


    protected void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        this.driver = new ChromeDriver();
        this.baseUrl = "http://todolist.ru/";
    }

    public void login(UserData data) {
        openLoginPage();
        driver.findElement(By.id("user_login")).click();
        driver.findElement(By.id("user_login")).sendKeys(data.getLogin());
        driver.findElement(By.id("user_password")).click();
        driver.findElement(By.id("user_password")).sendKeys(data.getPassword());
        driver.findElement(By.cssSelector(".submit")).click();
    }

    protected void quitDriver() {
        driver.quit();
    }

    protected void openHomePage() {
        driver.get(baseUrl);
    }

    protected void openLoginPage() {
        // driver.findElement(By.linkText("Вход")).click();
        driver.get("http://todolist.ru/user/login.html");
    }

    protected void signIn(UserData data){
        openHomePage();
        openLoginPage();
        login(data);
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
