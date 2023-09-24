package stream;

import stream.data.CsvReader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// 취미별 '새'씨 성을 갖는 멤버 수를 구하라
public class FirstNameHobby {
    public static void main(String[] args) {
        final String firstName = "죠";

        List<List<String>> datas = CsvReader.read();
        System.out.println("data =>" + datas);

        HashMap<String, Integer> resultMap = new HashMap<>();
        datas.stream()
                .filter(data -> data.get(0).startsWith(firstName))
                .flatMap(data -> Arrays.stream(data.get(1).trim().split(":")))
                .forEach(hobby -> resultMap.merge(hobby, 1, (oldValue, newValue) -> ++oldValue));

        resultMap.entrySet().forEach(System.out::println);
    }
}
