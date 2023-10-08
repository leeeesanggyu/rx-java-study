package stream;

import stream.jsondata.JsonReader;
import stream.jsondata.Users;

import java.util.List;

// "축구" 취미를 가진 사람들 중 "새로운"이라는 이름을 가진 사람의 수를 세라.
public class CountCliming {
    public static void main(String[] args) {
        List<Users> users = JsonReader.read();

        long count = users.stream()
                .filter(user -> user.getHobby().stream().anyMatch(hobby -> hobby.equals("축구")))
                .filter(user -> user.getName().contains("새로운"))
                .count();
        System.out.println(count);
    }
}
