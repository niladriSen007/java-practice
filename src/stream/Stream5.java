package stream;

import dtos.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stream5 {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(1, "John", "IT", 60000),
                new Employee(2, "Alice", "HR", 55000),
                new Employee(3, "Bob", "IT", 75000),
                new Employee(4, "Carol", "HR", 70000),
                new Employee(5, "David", "Finance", 65000),
                new Employee(6, "Eve", "IT", 80000),
                new Employee(7, "Frank", "Finance", 64000),
                new Employee(8, "Ala", "Operations", 44000)
        );

        //find the most common first letter among all employee names
        System.out.println(employees.stream().collect(
                        Collectors.groupingBy(emp -> emp.getName().toLowerCase().charAt(0),
                                Collectors.counting())
                ).entrySet().stream()
                .max(Comparator.comparing(ch -> ch.getValue())).get().getKey());


        //given a list of integers. compute the average of every window_size element sliding window
        List<Integer> list = Arrays.asList(4, 8, 15, 16, 23, 42);
        int WINDOW_SIZE = 5;
        System.out.println(IntStream.range(0, list.size() - (WINDOW_SIZE - 1))
                .mapToObj(index -> list.subList(index, index + WINDOW_SIZE))
                .map(elemWindow -> elemWindow.stream()
                        .mapToInt(elem -> elem).average().orElse(0.0))
                .toList()
        ); // TODO

        //find the longest word in a sentence innoring case and punctuation
        String sentence = "The quick, brown fox jumped over the lazy dog!";
        System.out.println(Arrays.stream(sentence.toLowerCase().replaceAll("[^a-z\\s]", "").split(" "))
                .max((x, y) -> x.length() - y.length()).orElse("")
        );

        //find top 3 most frequent words in a paragraph
        String paragraph = "Java is great great is. Java is object oriented. Java streams are powerful, and Java is fun!";
        System.out.println(Arrays.stream(paragraph.toLowerCase().replaceAll("[^a-z\\s]", "").split(" ")).collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                LinkedHashMap::new,
                                Collectors.counting())
                ).entrySet().stream().
                sorted((x, y) -> Math.toIntExact(x.getValue() - y.getValue()))
                .toList().reversed().stream().limit(3).toList());


        //reverse each word in a sentence
        String[] s = paragraph.toLowerCase().replaceAll("[^a-z\\s]", "").split(" ");
        System.out.println(String.join(" ", Arrays.stream(s).map(elem -> new StringBuilder(elem).reverse()).toList()));
        System.out.println(String.join(" ", Arrays.stream(s).map(elem ->
                Arrays.stream(elem.split("")).reduce("", (rev, ch) -> ch + rev)).toList()));


    }
}
