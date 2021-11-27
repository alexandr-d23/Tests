package generator;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import model.TaskData;

import java.io.*;

public class XmlGenerator {
    private static XmlMapper xmlMapper = new XmlMapper();

    public TaskData deserialize(String fileName) {
        try {
            File file = new File("src/main/java/generator/" + fileName);
            String xml = inputStreamToString(new FileInputStream(file));
            return xmlMapper.readValue(xml, TaskData.class);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public void serialize(TaskData entity, String fileName) {
        try {
            xmlMapper.writeValue(new File("src/main/java/generator/" + fileName), entity);
        } catch (IOException ex) {

        }
    }

    public String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }

    public static void main(String[] args) {
        XmlGenerator ser = new XmlGenerator();
        TaskData data = ser.deserialize("tasksData.xml");
        System.out.println(data);
    }
}