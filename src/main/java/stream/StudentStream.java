package stream;

import java.util.List;
import java.util.stream.Collectors;

public class StudentStream {

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Alice", false, 1, 1, 95),
                new Student("Bob", true, 1, 2, 88),
                new Student("Charlie", true, 2, 1, 75),
                new Student("David", true, 2, 2, 92),
                new Student("Eva", false, 3, 1, 84),
                new Student("Frank", true, 3, 2, 78),
                new Student("Grace", false, 1, 3, 91),
                new Student("Hank", true, 2, 3, 87),
                new Student("Ivy", false, 3, 3, 89),
                new Student("Jack", true, 3, 3, 94)
        );

        // stuArr에서 불합격(150점 미만)한 학생의 수를 남자와 여자로 구별하여라. (Boolean, List)
        students.stream()
                .filter(student -> student.getScore() >= 90)
                .collect(Collectors.groupingBy(Student::isMale))
                .entrySet()
                .forEach(System.out::println);

        // 각 반별 총점을 학년 별로 나누어 구하여라 (Map<Integer, Map<Integer, Integer>>)
        students.stream()
                .collect(
                        Collectors.groupingBy(
                                Student::getHak,
                                Collectors.groupingBy(Student::getBan, Collectors.summingInt(Student::getScore))
                        )
                )
                .entrySet()
                .forEach(System.out::println);

        // stuArr에서 불합격(150점 미만)한 학생의 수를 남자와 여자로 구별하여라. (Boolean, List)
        students.stream()
                .filter(student -> student.getScore() > 90)
                .collect(Collectors.groupingBy(student -> student.isMale()))
                .entrySet()
                .forEach(System.out::println);

        // 각 반별 총점을 학년 별로 나누어 구하여라 (Map<Integer, Map<Integer, Integer>>)
        students.stream()
                .collect(
                        Collectors.groupingBy(
                                Student::getHak,
                                Collectors.groupingBy(
                                        Student::getBan, Collectors.summingInt(Student::getScore)
                                )
                        )
                )
                .entrySet()
                .forEach(System.out::println);
    }

    public static class Student {
        private String name;
        private boolean isMale;
        private int hak;
        private int ban;
        private int score;

        public Student(String name, boolean isMale, int hak, int ban, int score) {
            this.name = name;
            this.isMale = isMale;
            this.hak = hak;
            this.ban = ban;
            this.score = score;
        }

        public boolean isMale() {
            return isMale;
        }

        public int getScore() {
            return score;
        }

        public String getName() {
            return name;
        }

        public int getHak() {
            return hak;
        }

        public int getBan() {
            return ban;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", isMale=" + isMale +
                    ", hak=" + hak +
                    ", ban=" + ban +
                    ", score=" + score +
                    '}';
        }
    }
}
