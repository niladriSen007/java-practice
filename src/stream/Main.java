package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        int[] arr = {1, 2, 3, 4, 5};
//        for (int i : arr) {
//            System.out.println(i);
//        }
//
//        int[] a = new int[5];
//        Thread t1 = new Thread(() -> {
//            System.out.println("Hii");
//        });
//        t1.start();
//        System.out.println("Hello");

        Calc sum = (a, b) -> a + b;
        Calc sub = (a, b) -> a - b;
        System.out.println(sum.operate(10, 20));
        System.out.println(sub.operate(10, 20));

        //Predicate -> Boolean predicate
        Predicate<Integer> predicate = x -> x % 2 == 0;
        System.out.println("Predicate will return true if the number is even -> " + predicate.test(10));
        Predicate<String> startName = val -> val.toLowerCase().startsWith("n");
        Predicate<String> endName = val -> val.toLowerCase().endsWith("i");
        System.out.println("Predicate will return true if the name starts with N and ends with I-> " +
                startName.and(endName).test("Niladri"));
        System.out.println("Predicate will return true if the name starts with N or ends with I-> " +
                startName.or(endName).test("Niladri"));


        //Function -> Integer function
        Function<Integer, Integer> triple = x -> x * x * x;
        Function<Integer, Integer> square = x -> x * x;
        System.out.println("Function will return the cube of the number -> " +
                triple.andThen(square).apply(10)
        );

        //Consumer -> Takes input and returns void
        Consumer<Integer> consumer = x -> System.out.println(x);
        consumer.accept(10);

        //Supplier -> Takes no input and returns output
        Supplier<Integer> supplier = () -> 10;
        System.out.println(supplier.get());

        //BiPredicate -> Boolean predicate
        BiPredicate<Integer, Integer> biPredicate = (x, y) -> x % y == 0;
        System.out.println("BiPredicate will return true if the number is even -> " + biPredicate.test(10, 2));

        //BiFunction -> Integer function
        BiFunction<Integer, Integer, Integer> biFunction = (x, y) -> x + y;
        System.out.println("BiFunction will return the sum of the numbers -> " + biFunction.apply(10, 20));

        //BiConsumer -> Takes input and returns void
        BiConsumer<Integer, Integer> biConsumer = (x, y) -> System.out.println(x + y);
        biConsumer.accept(10, 20);


        //UnaryOperator -> Integer operator(When input and output are same type)
        UnaryOperator<Integer> unaryOperator = x -> x * x;
        System.out.println("UnaryOperator will return the square of the number -> " + unaryOperator.apply(10));

        //BinaryOperator -> Integer operator(When input and output are same type)
        BinaryOperator<Integer> binaryOperator = (x, y) -> x + y;
        System.out.println("BinaryOperator will return the sum of the numbers -> " + binaryOperator.apply(10, 20));


        // Method Reference
        List<String> names = Arrays.asList("Ram", "Shyam");
//        names.forEach(x -> System.out.println(x));
        names.forEach(System.out::println);

        //Constructor References
    }
}