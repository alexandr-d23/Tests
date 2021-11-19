package create;// Generated by Selenium IDE

import common.TestBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import signin.UserData;

public class CreateTaskTest extends CreateTaskHelper {

    @Before
    public void login() {
        setup();
    }

    @After
    public void tearDown() {
        quitDriver();
    }

    @Test
    public void createTaskTest() {
        createTask(
                new TaskData(
                        "Test",
                        "test"
                )
        );
    }
}
