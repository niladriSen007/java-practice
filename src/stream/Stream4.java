package stream;

import dtos.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Stream4 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "John", "HR", 50000),
                new Employee(2, "Jane", "IT", 70000),
                new Employee(3, "Mike", "IT", 80000),
                new Employee(4, "Sara", "Finance", 60000),
                new Employee(5, "Paul", "HR", 55000)
        );

        // find highest paid employee in each department
        System.out.println(employees.stream().
                collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(
                                Comparator.comparing(
                                        Employee::getSalary)))));

        //find the departments having more than 1 employee
        //Note - for converting map to stream use map.entrySet().stream() so it will convert map to set of entries and then stream of entries
        // ex -
        // Map<String, Long> deptCount = employees.stream()
        //         .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        // output - {Finance=1, HR=2, IT=2}
        // deptCount.entrySet()...
        // output - [Finance=1, HR=2, IT=2]
        System.out.println(employees.stream()
                .collect(Collectors.groupingBy
                        (Employee::getDepartment,
                                Collectors.counting()))
                .entrySet().stream()
                .filter(x -> x.getValue() > 1)
                .map(elem -> elem.getKey())
                .toList());


        // find department with the highest average salary
        System.out.println(employees.stream().collect(
                Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary))
        ).entrySet().stream().max(Comparator.comparing(x -> x.getValue())).orElseThrow());


        //find most frequent character in string
        String input = "banana";
        System.out.println(
                input.chars()
                        .mapToObj(c -> (char) c)
                        .collect(
                            Collectors.groupingBy(Function.identity(),Collectors.counting())
                        ).entrySet().stream().max(
                                Comparator.comparing(ch->ch.getValue())).get().getKey());


        //find first non repeating character in a string
        String inp = "array";
        System.out.println(inp.chars().mapToObj(c->(char) c).collect(
                Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                )
        ).entrySet().stream().min(Comparator.comparing(elem->elem.getValue())).get().getKey());
    }
}
