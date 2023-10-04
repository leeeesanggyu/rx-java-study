package stream.jsondata;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonReader {

    public static List<Users> read() {
        String filePath = "./src/main/java/stream/jsondata/data.json";

        JSONParser parser = new JSONParser();
        JSONArray jsonArray = null;
        try {
            jsonArray = (JSONArray) parser.parse(new FileReader(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        List<Users> result = new ArrayList<>();
        jsonArray.forEach(data -> {
            JSONObject jsonData = (JSONObject) data;
            Users users = new Users((String) jsonData.get("name"), (String) jsonData.get("content"), (JSONArray) jsonData.get("hobby"));
            result.add(users);
        });
        return result;
    }
}
