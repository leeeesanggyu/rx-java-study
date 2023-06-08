package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionalDescriptorFunction {
    public static void main(String[] args) {
        List<Character> characters = List.of('a', 'b', 'c', 'd');
        List<Integer> result = map(characters, character -> (int) character);
        List<String> StringResult = map(characters, character -> String.valueOf(character));

        System.out.println("characters => " + characters);
        System.out.println("result => " + result);
        System.out.println("StringResult => " + StringResult);
    }

    public static <T, R> List<R> map(List<T> parameters, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T parameter : parameters) {
            result.add(f.apply(parameter));
        }
        return result;
    }
}
