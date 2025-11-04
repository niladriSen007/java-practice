package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamEasy {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 6, 4, 3, 2, 6, 7, 9, 10);

        //1. Find all distinct elements from a list
        System.out.println("Distinct elements of the list is: " + list.stream().distinct().toList());
        //2. Find the average of all numbers in a list
        System.out.println(list.stream()
                .mapToInt(x -> x)
                .average()
                .orElse(0));

        //3. Sort a list of integers in descending order
        System.out.println(list.stream().sorted((a, b) -> b - a).toList());
        System.out.println(list.stream().sorted(Comparator.reverseOrder()).toList());

        // 4.List how many strings start with a specific letter
        List<String> names = Arrays.asList("Nil", "Ail", "Aya", "jhg");
        System.out.println(names.stream().filter(x -> x.toLowerCase().startsWith("a")).toList());

        //5. Join all strings into a list separated by a comma
        System.out.println(names.stream().collect(Collectors.joining(",")));

        //6. Check all elements are positive or not
        System.out.println(list.stream().allMatch(x -> x >= 0));

        //7. Check if any number is divisible by 3 or not
        System.out.println(list.stream().anyMatch(x -> x % 3 == 0));

        //8. Flatten a list of lists
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );
        System.out.println(listOfLists.stream().flatMap(x->x.stream()).toList());

        //9. Find the first non empty string
        List<String> strings = Arrays.asList("", "", "Hello", "World", "");
        System.out.println(strings.stream().filter(s->!s.isEmpty()).findFirst().orElse(null));

        //10. Find the second maximum number in a list
        System.out.println(list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());
    }
}
