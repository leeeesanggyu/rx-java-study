package stream;

import stream.jsondata.JsonReader;
import stream.jsondata.Users;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HobbyList {
    public static void main(String[] args) {
        List<Users> users = JsonReader.read();

        // 모든 사람의 취미 목록을 중복 없이 추출하고, 취미 목록을 알파벳 순서로 정렬하여 출력하라.
        users.stream()
                .flatMap(user -> user.getHobby().stream())
                .distinct()
                .sorted()
                .forEach(System.out::println);

        // 각 취미별로 몇 명의 사람이 그 취미를 가지고 있는지 집계하여 출력하라.
        users.stream()
                .flatMap(user -> user.getHobby().stream())
                .collect(Collectors.groupingBy(hobby -> hobby, Collectors.counting()))
                .entrySet().forEach(System.out::println);

        // "축구" 취미를 가진 사람 중에서 가장 취미가 다양한(가장 많은 다른 취미를 가진) 사람의 이름을 추출하라.
        String result = users.stream()
                .filter(user -> user.getHobby().contains("축구"))
                .max(Comparator.comparing(user -> user.getHobby().size()))
                .get().getName();
        System.out.println("\"축구\" 취미를 가진 사람 중에서 가장 취미가 다양한(가장 많은 다른 취미를 가진) 사람의 이름 : " + result);

        // 각 취미가 몇 명의 사람에게서 발견되었는지 집계하여 출력하라.
        users.stream()
                .flatMap(user -> user.getHobby().stream())
                .collect(Collectors.groupingBy(hobby -> hobby, Collectors.counting()))
                .entrySet().forEach(System.out::println);
    }
}
