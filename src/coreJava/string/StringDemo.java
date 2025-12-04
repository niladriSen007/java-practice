package coreJava.string;

public class StringDemo {
    static void main() {
        String s1 = "Hello";
        String s2="Hello";
        System.out.println(s1==s2); // true
        System.out.println(s1.equals(s2)); // true

        String s3 = new String("Hello");
        System.out.println(s1==s3); // false
        System.out.println(s1.equals(s3)); // true

        String s4 = new String("Hello");
        System.out.println(s3==s4); // false
        System.out.println(s3.equals(s4)); // true
    }
}
