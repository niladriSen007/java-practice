package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class StreamDemo {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> reduce = numbers.stream().reduce((x, y) -> x + y);
        System.out.println(reduce);

        //Counting occurances of a character in a string
        String message = "Hello World";
        IntStream chars = message.chars();
//        chars.forEach(System.out::println);
        System.out.println(chars.filter(ch -> ch == 'l').count());
    }
}
