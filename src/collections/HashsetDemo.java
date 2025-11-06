package collections;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        return ((Person) o).name.equals(this.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}

public class HashsetDemo {
    public static void main(String[] args) {
        Set<Object> set = new HashSet<>();
        set.add(new Person("Nil"));
        set.add(new Person("Nil"));
        System.out.println(set.size());
    }
}
