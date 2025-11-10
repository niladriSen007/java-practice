package stream;

import dtos.Employee;
import dtos.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Stream3 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "John", "HR", 50000),
                new Employee(2, "Jane", "IT", 70000),
                new Employee(3, "Mike", "IT", 80000),
                new Employee(4, "Sara", "Finance", 60000),
                new Employee(5, "Paul", "HR", 55000)
        );

        List<Person> people = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 28),
                new Person("David", 35)
        );

        //1. Sort the list of employees by salary
        System.out.println(employees.stream().sorted(Comparator.comparing(x->x.getSalary())).toList());
        System.out.println(employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).toList());

        //2. calculate the average age of a list of persons
//        System.out.println(people.stream().mapToInt(x->x.getAge()).average().orElse(0.0));
        System.out.println(people.stream().mapToInt(Person::getAge).average().orElse(0.0));

        //3. Partition numbers in even or odd list
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        Map<Boolean, List<Integer>> collect = numbers.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
        Map<String, List<Integer>> collect = numbers.stream().collect(Collectors.groupingBy(x -> x % 2 == 0 ? "Even" : "Odd"));
        System.out.println(collect);

        //4. Group employees by department
        Map<String, List<Employee>> collect1 = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(collect1);

        //5. count occurances of each element in a list
        List<String> items = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        System.out.println(items.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));

        //6. Group a list of words by their length
        List<String> words = Arrays.asList("apple", "bat", "ball", "cat", "banana", "dog","goat");
        System.out.println(words.stream().collect(Collectors.groupingBy(x->x.length())));

        //7. group employees by department and calculate average salary of each department
        System.out.println(employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary))));

    }
}
