package basics.methodReference;

import java.util.Arrays;
import java.util.List;

class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
    }
}

public class ConstructorCreation {
    static void main() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        List<Person> list = names.stream().map(Person::new).toList();
        list.forEach(System.out::println);

        //filter names start with "A"
        List<String> filteredList = names.stream()
                .filter(name -> name.startsWith("A"))
                .toList();
        System.out.println(filteredList);
    }
}
