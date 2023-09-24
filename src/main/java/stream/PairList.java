package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 모든 숫자 쌍의 배열 리스트를 반환하여라. ex) numbers1 = [1,2,3], numbers2 = [3,4] -> [(1,3), (1,4), (2,3), (2,4), (3,3), (3,4)]
public class PairList {

    private static final List<Integer> numbers1 = Arrays.asList(1, 2, 3);
    private static final List<Integer> numbers2 = Arrays.asList(3, 4);

    public static void main(String[] args) {
        numbers1.stream()
                .flatMap(
                        number1 -> numbers2.stream()
                                .map(number2 -> new int[]{number1, number2})
                )
                .forEach(data -> System.out.println(Arrays.toString(data)));
    }
}
