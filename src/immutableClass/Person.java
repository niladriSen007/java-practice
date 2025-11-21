package immutableClass;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

class Student {
    private final String name;
    private final int age;
    private final List<String> hobbies;

    Student(String name, int age, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.hobbies = Collections.unmodifiableList(hobbies != null ? List.copyOf(hobbies) : null);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public Object readResolve() {
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return age == student.age && name.equals(student.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobbies=" + hobbies +
                '}';
    }
}

public class Person {
    public static void main(String[] args) {

    }
}
