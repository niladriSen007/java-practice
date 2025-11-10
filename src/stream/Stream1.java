package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Stream1 {
    public static void main(String[] args) {

        //1. Filter even numbers from a stream of integers
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 15, 6, 7, 8, 9, 10, 11);
        List<Integer> list1 = list.stream().filter(x -> x % 2 == 0).toList();
        System.out.println("1) Filter even numbers from the list: " + list1);

        //2. Converts numbers in list to squares
        List<Integer> list2 = list.stream().map(x -> x * x).toList();
        System.out.println("2) Squares of all numbers: " + list2);

        //3. Square even numbers from list
        List<Integer> list3 = list.stream().filter(x -> x % 2 == 0).map(x -> x * x).toList();
        System.out.println("3) Squares of even numbers: " + list3);

        //4. Find the first number greater than 10 in a list
        Optional<Integer> first = list.stream().filter(x -> x > 10).sorted().findFirst();
        System.out.println("4) First number greater than 10 (sorted): " + first.orElse(null));

        //5. Count how many numbers are > 5 in this list
        long count = list.stream().filter(x -> x > 5).count();
        System.out.println("5) Count of numbers greater than 5: " + count);

        //6. Find sum of all odd numbers in a list
        Integer reduce = list.stream().filter(x -> x % 2 != 0).reduce(0, (x, y) -> x + y);
        System.out.println("6) Sum of all odd numbers: " + reduce);

        //7. Find the maximum number in a list
        Optional<Integer> max = list.stream().max((x, y) -> x - y);
        System.out.println("7) Maximum number in the list: " + max.orElse(null));

        //8. Find the minimum number in a list
        Optional<Integer> min = list.stream().min((x, y) -> x - y);
        System.out.println("8) Minimum number in the list: " + min.orElse(null));

        //9. Sum of square of even numbers in a list
        System.out.println("9) Sum of square of even numbers: "+list.stream().filter(x -> x % 2 == 0).map(x -> x * x).reduce(0, (x, y) -> x + y));
    }
}
