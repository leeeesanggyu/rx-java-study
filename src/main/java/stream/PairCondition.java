package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// 모든 숫자 쌍의 곱이 가장 큰 값을 반환하여라. ex) numbers1 = [1,2,3], numbers2 = [3,4] -> 12
public class PairCondition {

    private static final List<Integer> numbers1 = Arrays.asList(1, 2, 3);
    private static final List<Integer> numbers2 = Arrays.asList(3, 4);

    public static void main(String[] args) {
        int result = numbers1.stream()
                .flatMap(
                        number -> numbers2.stream()
                                .map(number2 -> new int[]{number, number2})
                )
                .mapToInt(pair -> pair[0] * pair[1])
                .max()
                .getAsInt();

        System.out.println(result);
    }
}
