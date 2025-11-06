package misc;

class Person{
     String name;

    public Person(String name){
        this.name=name;
    }

}

public class YouCanChangeFinal {
    public static void main(String[] args) {
        final int num = 12;
//        num=13; // Compilation Error: cannot assign a value to final variable num
        final Person person = new Person("Nil");
        person.name = "Changed Name"; // This is allowed, as we are not changing the reference of 'person', just modifying its internal state.
        System.out.println("Person's name: " + person.name);
    }
}
