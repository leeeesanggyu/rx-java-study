package stream;

import stream.data.CsvReader;

import java.util.List;

// "축구"를 취미로 가지는 사람들 중에서 개발을 하지 않는 사람의 이름을 출력하세요.
public class NotIn {
    public static void main(String[] args) {
        List<List<String>> datas = CsvReader.read();

        datas.stream()
                .filter(data -> data.get(1).contains("축구"))
                .filter(data -> !data.get(1).contains("개발"))
                .forEach(data -> System.out.println(data.get(0)));
    }
}
