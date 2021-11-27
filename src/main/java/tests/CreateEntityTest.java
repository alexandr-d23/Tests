package tests;

import common.TestBase;
import generator.GeneratorTask;
import model.TaskData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.testng.Assert;

import java.util.stream.Stream;

public class CreateEntityTest extends TestBase {
    public static GeneratorTask generateData = new GeneratorTask();

    public static Stream<Arguments> getGeneratedData() {
        generateData.handleEntity("tasksData.xml");
        TaskData data = generateData.getEntity("tasksData.xml");
        System.out.println(data);
        return Stream.of(Arguments.of(data));
    }

    @BeforeEach
    public void init() {
        setup();
    }

    @ParameterizedTest
    @MethodSource("getGeneratedData")
    public void createTodoItem(TaskData data) {

        int sizeBefore = appManager
                .getTodoHelper()
                .createTask(
                        data
                );
        int sizeAfter = appManager.getTodoHelper().getSizeAfter();
        Assert.assertEquals(sizeBefore + 1, sizeAfter);
    }
}