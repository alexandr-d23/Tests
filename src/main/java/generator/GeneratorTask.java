package generator;

import model.TaskData;

public class GeneratorTask {
    private XmlGenerator xmlSerializer;

    public GeneratorTask() {
        this.xmlSerializer = new XmlGenerator();
    }

    public void handleEntity(String fileName) {
        xmlSerializer.serialize(TaskGenerator.mockEntity(), fileName);
    }

    public TaskData getEntity(String fileName) {
        return xmlSerializer.deserialize(fileName);
    }
}