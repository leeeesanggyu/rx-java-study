package stream;

import stream.csv.CsvReader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// 취미별 인원 수를 구하라
public class HobbyCount {

    public static void main(String[] args) {
        List<List<String>> datas = CsvReader.read();
        System.out.println("data =>" + datas);

        HashMap<String, Integer> resultMap = new HashMap<>();
        datas.stream()
                .flatMap(data -> Arrays.stream(data.get(1).trim().split(":")))
                .forEach(hobby -> resultMap.merge(hobby, 1, (oldValue, newValue) -> ++oldValue));

//        datas.stream()
//                .flatMap(data -> Arrays.stream(data.get(1).trim().split(":")))
//                .forEach(hobby -> {
//                    resultMap.put(hobby, resultMap.containsKey(hobby) ? resultMap.get(hobby) + 1 : 1);
//                });

        resultMap.entrySet().forEach(System.out::println);
    }
}
