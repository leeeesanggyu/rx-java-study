package stream;

import stream.jsondata.JsonReader;
import stream.jsondata.Users;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// "축구" 취미를 가진 사람들 중에서 각 취미의 수를 세어 취미별로 그룹화하여 출력하라.
public class HobbyGroup {
    public static void main(String[] args) {
        List<Users> users = JsonReader.read();
        users.stream()
                .filter(user -> user.getHobby().stream().anyMatch(hobby -> hobby.equals("축구")))
                .flatMap(user -> user.getHobby().stream())
                .collect(Collectors.groupingBy(hobby -> hobby, Collectors.counting()))
                .entrySet()
                .forEach(System.out::println);
    }
}
