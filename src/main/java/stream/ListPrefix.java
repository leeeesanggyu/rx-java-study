package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// List에 저장된 단어들의 접두사가 각각 몇개씩 있는지 Map<String, Integer>으로 변환하여라. ex) ("T", 1), ("a", 2) ...
public class ListPrefix {

    private final static List<String> WORDS = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");

    public static void main(String[] args) {
        Map<String, Integer> resultMap = WORDS.stream()
                .map(word -> word.substring(0, 1))
                .collect(Collectors.toMap(
                        word -> word, value -> 1, (oldValue, newValue) -> oldValue + newValue
                ));

        resultMap.entrySet()
                .forEach(System.out::println);
    }
}
