package stream;

import stream.data.CsvReader;

import java.util.List;
import java.util.Optional;

// 소개 내용에 '좋아'가 몇 번 등장하는지 구하라
public class IntroduceCount {
    public static void main(String[] args) {
        List<List<String>> datas = CsvReader.read();
        datas.remove(0);
        System.out.println("datas =>" + datas);

        final String keyword = "좋아";

        Optional<Integer> result = datas.stream()
                .map(data -> countKeyword(data.get(2), keyword))
                .reduce(Integer::sum);
        System.out.println("result = " + result.get());
    }

    public static int countKeyword(String message, String keyword) {
        int index = message.indexOf(keyword);

        if (index == -1) {
            return 0;
        } else {
            return 1 + countKeyword(message.substring(index + keyword.length()), keyword);
        }
    }
}
