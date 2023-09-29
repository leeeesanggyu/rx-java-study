package stream.jsondata;

import java.util.List;

public class Users {
    private String name;
    private String content;
    private List<String> hobby;

    public Users(String name, String content, List<String> hobby) {
        this.name = name;
        this.content = content;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public List<String> getHobby() {
        return hobby;
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", hobby=" + hobby +
                '}';
    }
}
