import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadDataFromJSONFile {

    public static void main(String[] args) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("C:\\Users\\v1nz\\WorkSpace\\JavaProjects\\Selenium Tests\\JSONDataDriven\\src\\test\\resources\\employee.json");
        Object object = jsonParser.parse(reader);
        JSONObject jsonObject = (JSONObject) object;
        String fname = (String) jsonObject.get("firstName");
        String lname = (String) jsonObject.get("lastName");
        System.out.println(fname);
        System.out.println(lname);

        JSONArray jsonArray = (JSONArray) jsonObject.get("address");
        for (Object o : jsonArray) {
            JSONObject address = (JSONObject) o;
            String street = (String) address.get("street");
            String city = (String) address.get("city");
            String state = (String) address.get("state");

            System.out.println("Address : " + street + "," + city + "," + state);
        }


        //Write JSON file
        try (FileWriter file = new FileWriter("Testdata1.json")) {
            file.append(jsonArray.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
