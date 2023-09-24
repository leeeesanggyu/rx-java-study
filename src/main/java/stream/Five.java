package stream;

import java.util.Arrays;
import java.util.Random;

public class Five {

    public static void main(String[] args) {
        stringSum();
        longLength();
        lottoSort();
    }

    // 임의의 로또번호(1~45)를 정렬해서 출력하시오.
    public static void lottoSort() {
        new Random().ints(1, 45)
                .distinct()
                .limit(6)
                .sorted()
                .forEach(System.out::println);
    }

    // 문자열 배열 String[] strArr = {"aaa","bb","c","dddd"}의 문자열 중에서 가장 긴 것의 길이를 출력하시오.
    public static void longLength() {
        String[] strArr = {"aaa","bb","c","dddd"};

        Integer maxLength = Arrays.stream(strArr)
                .mapToInt(String::length)
                .max()
                .orElse(0);
        System.out.println(maxLength);
    }

    // 문자열 배열 String[] strArr = {"aaa","bb","c","dddd"}의 모든 문자열의 길이를 더한 결과를 출력하여라.
    public static void stringSum() {
        String[] strArr = {"aaa","bb","c","dddd"};

        int sum = Arrays.stream(strArr)
                .mapToInt(String::length)
                .sum();
        System.out.println(sum);
    }
}
