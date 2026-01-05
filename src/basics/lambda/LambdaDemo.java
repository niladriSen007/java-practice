package basics.lambda;

public class LambdaDemo {
    static void main() {
        LambdaInterface greet = name -> System.out.println(STR."Hello, \{name}!");
        greet.greet("Alice");
    }
}
