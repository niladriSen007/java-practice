package coreJava.string;

public class WhyStringImmutable {
    static void main() {
        String str = "Hello";
        str.concat(" World");
        System.out.println(str); // Output: Hello
    }
}
