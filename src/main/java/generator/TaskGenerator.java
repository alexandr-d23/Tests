package generator;

import model.TaskData;

public class TaskGenerator {

    public static TaskData mockEntity() {
        return new TaskData("Test1", "test2");
    }
}