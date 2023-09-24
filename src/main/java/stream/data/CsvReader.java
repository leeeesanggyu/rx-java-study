package stream.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public static List<List<String>> read() {
        String csvFile = "./src/main/java/stream/data/data.csv"; // 실제 파일 경로로 변경해주세요.
        String line = "";
        String csvDelimiter = ",";

        List<List<String>> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                // CSV 파일에서 한 줄을 읽고 콤마로 분리
                String[] data = line.split(csvDelimiter);

                list.add(List.of(data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        list.remove(0);
        return list;
    }
}
