package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 함수 Descriptor Predicate 예제
 */
public class FunctionalDescriptorPredicate {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 5, 6, 10, 11, 12);
        List<Integer> filterResult = filter(numbers, number -> number > 6);
        System.out.println("result => " + filterResult);
    }

    public static <T> List<T> filter(List<T> numbers, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T number : numbers) {
            if (p.test(number)) {
                result.add(number);
            }
        }
        return result;
    }
}
