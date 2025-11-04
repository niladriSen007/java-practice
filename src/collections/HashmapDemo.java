package collections;

import java.util.HashMap;
import java.util.Objects;

public class HashmapDemo {
    public static void main(String[] args) {
        HashMap<Student, Integer> map = new HashMap<>();
        map.put(new Student("Alice", 1), 85);
        map.put(new Student("Bob", 2), 90);
        map.put(new Student("Charlie", 3), 78);

        System.out.println(map.get(new Student("Alice", 1))); // Output: null
        System.out.println(map.get(new Student("Bob", 2)));   // Output: null
        System.out.println(map.get(new Student("Charlie", 3))); // Output: null

        // The above outputs are null because the Student class does not override equals() and hashCode() methods.
        // To fix this, we need to override these methods in the Student class.
    }

}

class Student {
    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student other = (Student) obj;
        return id == other.id && Objects.equals(name, other.name);
    }
}
