package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

// List에 저장된 단어들 중에서 단어의 길이가 2 이상인 경우에만, 모든 단어를 대문자로 변환하여 스페이스로 구분한 하나의 문자열로 합한 결과를 반환하여라.
public class FilterMergeUpper {

    private final static List<String> WORDS = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");

    public static void main(String[] args) {
        String result = WORDS.stream()
                .filter(word -> word.length() >= 2)
                .map(word -> word.toUpperCase(Locale.ROOT))
                .map(word -> word.substring(0, 1))
                .collect(Collectors.joining(" "));

        System.out.println(result);
    }
}
