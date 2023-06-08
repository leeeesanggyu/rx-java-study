package lambda;

import java.util.List;
import java.util.function.Consumer;

/**
 * 함수 Descriptor Consumer 예제
 */
public class FunctionalDescriptorConsumer {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        around(numbers, number -> System.out.println(number));
        around(numbers, System.out::println);
    }

    public static <T> void around(List<T> parameters, Consumer<T> c) {
        for (T parameter : parameters) {
            c.accept(parameter);
        }
    }
}
