package collections;

import java.util.HashMap;

public class HashmapDemo {
    public static void main(String[] args) {
        HashMap<Student, Integer> map = new HashMap<>();

        Student one = new Student(1, "Alice");
        Student two = new Student(2, "Bob");
        Student three = new Student(3, "Charlie");

        map.put(one, 85);
        map.put(two, 90);
        map.put(three, 78);

        System.out.println(map.get(one));
        System.out.println(map.get(two));
        System.out.println(map.get(three));

        Student four = new Student(1, "John");
        Student five = new Student(2, "Bob");
//        map.put(four,99);
        System.out.println(map.get(four));
        System.out.println(map.get(five));


        // The above outputs are null because the Student class does not override equals() and hashCode() methods.
        // To fix this, we need to override these methods in the Student class.
    }

}

record Student(int id, String name) {

    @Override
    public int hashCode() {
        return 10 * id ;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Student other = (Student) obj;
        return this.id == other.id && this.name.equals(other.name);
    }
}
