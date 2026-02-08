package basics.lambda;

public class LambdaDemo {
    static void main() {
        LambdaInterface greet = name -> System.out.println("Hello, " + name + "!");
        greet.greet("Alice");
    }
}
