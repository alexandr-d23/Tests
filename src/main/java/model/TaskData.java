package model;

public class TaskData {
    String name;
    String description;

    public TaskData(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public TaskData() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
