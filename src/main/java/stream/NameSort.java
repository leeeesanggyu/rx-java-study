package stream;

import stream.data.CsvReader;

import java.util.Comparator;
import java.util.List;

// 취미가 "축구" 또는 "농구"인 사람들의 이름을 알파벳 순으로 정렬하여 출력하세요.
public class NameSort {
    public static void main(String[] args) {
        List<List<String>> datas = CsvReader.read();

        datas.stream()
                .filter(data -> (data.get(1).contains("농구") || data.get(1).contains("축구")))
                .sorted(Comparator.comparing(data -> data.get(0)))
                .forEach(data -> System.out.println(data.get(0)));
    }
}
