package basics.methodReference;

import java.util.List;

class Demo {
    public static String toUpper(String name) {
        return name.toUpperCase();
    }
}

public class StaticMethod {
    static void main() {
        List.of("alice", "bob", "charlie")
                .stream()
                .map(Demo::toUpper)
                .forEach(System.out::println);
    }
}
