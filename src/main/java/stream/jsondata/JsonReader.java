package stream.jsondata;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonReader {

    public static List<Users> read() throws IOException, ParseException {
        String filePath = "./src/main/java/stream/jsondata/data.json";

        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(filePath));

        List<Users> result = new ArrayList<>();
        jsonArray.forEach(data -> {
            JSONObject jsonData = (JSONObject) data;
            JSONArray hobby = (JSONArray) jsonData.get("hobby");
            Users users = new Users((String) jsonData.get("name"), (String) jsonData.get("content"), hobby);
            result.add(users);
        });
        return result;
    }
}
