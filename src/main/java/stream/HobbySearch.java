package stream;

import stream.csv.CsvReader;

import java.util.List;

// 취미가 "농구" 또는 "축구"인 사람들을 출력하세요.
public class HobbySearch {
    public static void main(String[] args) {
        List<List<String>> datas = CsvReader.read();
        System.out.println("data =>" + datas);

        datas.stream()
                .filter(data -> (data.get(1).contains("농구") || data.get(1).contains("축구")))
                .forEach(data -> System.out.println(data.get(0)));
    }
}
