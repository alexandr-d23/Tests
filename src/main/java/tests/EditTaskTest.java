package tests;

import common.TestBase;
import helpers.EditTaskHelper;
import model.TaskData;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

public class EditTaskTest extends TestBase {

    @Before
    public void login() {
        setup();
    }


    @Test
    public void editTaskTest() {
        EditTaskHelper helper = appManager.getEditHelper();
        TaskData data = new TaskData(
                "Check18174",
                "test"
        );
        helper.editTask(
                data
        );
        Assert.assertEquals(helper.getName(), data.getName());
    }

    @After
    public void logout() {
        appManager.getTodoHelper().logout();
    }
}