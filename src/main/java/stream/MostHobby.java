package stream;

import stream.csv.CsvReader;

import java.util.*;

// 각 사람이 가장 좋아하는 취미를 찾아 출력하세요.
public class MostHobby {
    public static void main(String[] args) {
        List<List<String>> datas = CsvReader.read();
        System.out.println("data =>" + datas);

        HashMap<String, Integer> hobbyCountMap = new HashMap<>();

        datas.stream()
                .flatMap(data -> Arrays.stream(data.get(1).trim().split(":")))
                .forEach(hobby -> hobbyCountMap.merge(hobby, 1, (oldValue, newValue) -> ++oldValue));
        System.out.println("result => " + hobbyCountMap);

        String key = hobbyCountMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get().getKey();
        System.out.println("result => " + key);
    }
}
