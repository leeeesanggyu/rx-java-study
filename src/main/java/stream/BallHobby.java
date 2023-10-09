package stream;

import stream.jsondata.JsonReader;
import stream.jsondata.Users;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

// '구'가 들어간 취미를 가진 각 사람의 수를 구해라
public class BallHobby {

    public static void main(String[] args) {
        List<Users> datas = JsonReader.read();
        System.out.println(datas);

        HashMap<String, Integer> hobbyMap = new HashMap<>();

        datas.stream()
                .flatMap(data -> data.getHobby().stream())
                .filter(hobby -> hobby.contains("구"))
                .forEach(hobby -> hobbyMap.merge(hobby, 1, (oldValue, newValue) -> ++oldValue));

        hobbyMap.entrySet()
                .forEach(System.out::println);

        System.out.println("---------------------");

        datas.stream()
                .flatMap(data -> data.getHobby().stream())
                .filter(hobby -> hobby.contains("구"))
                .collect(Collectors.toMap(hobby -> hobby, hobby -> 1, (oldValue, newValue) -> ++oldValue))
                .entrySet().forEach(System.out::println);

        System.out.println("---------------------");

        datas.stream()
                .flatMap(data -> data.getHobby().stream())
                .filter(hobby -> hobby.contains("구"))
                .collect(Collectors.groupingBy(hobby -> hobby, Collectors.counting()))
                .entrySet()
                .forEach(System.out::println);
    }
}
