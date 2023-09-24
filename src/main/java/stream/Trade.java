package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Trade {

    public static void main(String[] args) {
        Trader kyu = new Trader("Kyu", "Seoul");
        Trader ming = new Trader("Ming", "Gyeonggi");
        Trader hyuk = new Trader("Hyuk", "Incheon");
        Trader hwan = new Trader("Hwan", "Busan");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(kyu, 2019, 30000),
                new Transaction(kyu, 2020, 12000),
                new Transaction(ming, 2020, 40000),
                new Transaction(ming, 2020, 7100),
                new Transaction(hyuk, 2019, 5900),
                new Transaction(hwan, 2020, 4900)
        );

//        findSort(transactions);
//        cityDistinct(transactions);
//        filterSort(transactions);
//        mergeSort(transactions);
//        find(transactions);
//        sumValue(transactions);
        maxMin(transactions);
    }

    // 모든 거래 내역중에서 거래 금액의 최댓값과 최솟값을 구하라. 단, 최댓값은 reduce를 이용하고 최솟값은 stream의 min()을 이용하라.
    public static void maxMin(List<Transaction> transactions) {
        Integer max = transactions.stream()
                .map(transaction -> transaction.value)
                .reduce(Integer::max)
                .orElse(0);
        System.out.println(max);

        Integer min = transactions.stream()
                .map(transaction -> transaction.value)
                .min((o1, o2) -> o1 - o2)
                .orElse(0);
        System.out.println(min);
    }

    // 서울에 거주하는 거래자의 모든 거래 금액을 구하라.
    public static void sumValue(List<Transaction> transactions) {
        final String findCity = "Seoul";

        Integer result = transactions.stream()
                .filter(transaction -> transaction.trader.city.equals(findCity))
                .map(transaction -> transaction.value)
                .reduce(Integer::sum)
                .orElse(0);
        System.out.println(result);
    }

    // 부산에 거래자가 있는지를 확인하라.
    public static void find(List<Transaction> transactions) {
        final String findCity = "Busan";

        boolean result = transactions.stream()
                .map(transaction -> transaction.trader.city)
                .anyMatch(city -> city.equals(findCity));
        System.out.println(result);
    }

    // 모든 거래자의 이름을 구분자(",")로 구분하여 정렬하라.
    public static void mergeSort(List<Transaction> transactions) {
        final String separator = ",";

        String result = transactions.stream()
                .map(transaction -> transaction.trader.name)
                .distinct()
                .sorted()
                .collect(Collectors.joining(separator));
        System.out.println(result);
    }

    // 서울에서 근무하는 모든 거래자를 찾아서 이름순서대로 정렬하라.
    public static void filterSort(List<Transaction> transactions) {
        final String findCity = "Seoul";

        transactions.stream()
                .filter(transaction -> transaction.trader.city.equals(findCity))
                .map(transaction -> transaction.trader.name)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

    // 거래 내역이 있는 거래자가 근무하는 모든 도시를 중복 없이 나열하라.
    public static void cityDistinct(List<Transaction> transactions) {
        transactions.stream()
                .map(transaction -> transaction.trader.city)
                .distinct()
                .forEach(System.out::println);
    }

    // 2020년에 일어난 모든 거래 내역을 찾아 거래값을 기준으로 오름차순 정렬하라.
    public static void findSort(List<Transaction> transactions) {
        final int findYear = 2020;

        transactions.stream()
                .filter(transaction -> transaction.year == findYear)
                .sorted((o1, o2) -> o2.value - o1.value)
                .forEach(System.out::println);
    }

    public static class Trader {
        private String name;
        private String city;

        public Trader(String name, String city) {
            this.name = name;
            this.city = city;
        }

        @Override
        public String toString() {
            return "Trader{" +
                    "name='" + name + '\'' +
                    ", city='" + city + '\'' +
                    '}';
        }
    }

    public static class Transaction {
        private Trader trader;
        private int year;
        private int value;

        public Transaction(Trader trader, int year, int value) {
            this.trader = trader;
            this.year = year;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "trader=" + trader +
                    ", year=" + year +
                    ", value=" + value +
                    '}';
        }
    }
}
