package stream;

import stream.jsondata.JsonReader;
import stream.jsondata.Users;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// '구'가 들어간 취미를 가진 각 사람의 수를 구해라
public class BallHobby {

    public static void main(String[] args) {
        List<Users> datas = JsonReader.read();
        System.out.println(datas);

        HashMap<String, Integer> hobbyMap = new HashMap<>();

        datas.stream()
                .flatMap(data -> Arrays.stream(data.getHobby().toArray()))
                .filter(hobby -> hobby.toString().contains("구"))
                .forEach(hobby -> hobbyMap.merge(hobby.toString(), 1, (oldValue, newValue) -> ++oldValue));

        hobbyMap.entrySet()
                .forEach(System.out::println);
    }
}
