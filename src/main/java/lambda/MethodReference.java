package lambda;

import java.util.List;
import java.util.function.*;

public class MethodReference {
    public static void main(String[] args) {
        Predicate<String> p = String::isEmpty;
        Function<Integer, String> f = String::valueOf;
        BiPredicate<List<Integer>, Integer> bp = List::contains;
        Consumer<String> c = System.out::println;

        boolean pResult = p.test("asd");
        System.out.println("pResult : " + pResult);

        String fResult = f.apply(12345);
        System.out.println("fResult : " + fResult);

        boolean bpResult = bp.test(List.of(1, 2, 3), 2);
        System.out.println("bpResult : " + bpResult);

        c.accept("zzzz");
    }
}
