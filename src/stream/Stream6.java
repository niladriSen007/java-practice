package stream;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

enum SalaryRange {
    LOW,
    MEDIUM,
    HIGH
}

enum CharCategory {
    UPPERCASE,
    LOWERCASE,
    DIGIT,
    OTHER
}

class Transaction {
    private String id;
    private LocalDate date;
    private double amount;

    public Transaction(String id, LocalDate date, double amount) {
        this.id = id;
        this.date = date;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}

class Employee {
    private String name;
    private double salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class WorkRecord {
    private String employeeName;
    private String department;

    public WorkRecord(String employeeName, String department) {
        this.employeeName = employeeName;
        this.department = department;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "(" + employeeName + " - " + department + ")";
    }
}

public class Stream6 {
    public static void main(String[] args) {


        //from a list of transactions, find the day with the highest total spend
        List<Transaction> transactions = Arrays.asList(
                new Transaction("T1", LocalDate.of(2025, 1, 1), 300),
                new Transaction("T2", LocalDate.of(2025, 1, 1), 200),
                new Transaction("T3", LocalDate.of(2025, 1, 2), 500),
                new Transaction("T4", LocalDate.of(2025, 1, 2), 300),
                new Transaction("T5", LocalDate.of(2025, 1, 3), 100)
        );
        //individual transaction
        System.out.println(transactions.stream()
                .max(Comparator.comparing(Transaction::getAmount))
                .get().getDate());
        //total highest transaction of a day
        System.out.println(transactions.stream().collect(
                Collectors.groupingBy(
                        Transaction::getDate,
                        Collectors.summingDouble(Transaction::getAmount)
                )
        ).entrySet().stream().max(Comparator.comparing(elem -> elem.getValue())).get());


        //categorize employee by their salary (Low/Medium/High)
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 45000),
                new Employee("Bob", 78000),
                new Employee("Charlie", 120000),
                new Employee("David", 99000),
                new Employee("Eva", 30000),
                new Employee("Frank", 105000)
        );
        System.out.println(employees.stream().collect(
                Collectors.groupingBy(emp -> {
                    if (emp.getSalary() < 50000) return SalaryRange.LOW;
                    else if (emp.getSalary() < 100000) return SalaryRange.MEDIUM;
                    else return SalaryRange.HIGH;
                })
        ));


        //group characters by uppercase,lowercase,digits and others
        List<Character> chars = Arrays.asList(
                'A', 'b', '3', 'Z', 'x', '#', '7', 'm', '@'
        );
        System.out.println(chars.stream().collect(
                Collectors.groupingBy(
                        ch -> {
                            if (Character.isUpperCase(ch)) return CharCategory.UPPERCASE;
                            else if (Character.isLowerCase(ch)) return CharCategory.LOWERCASE;
                            else if (Character.isDigit(ch)) return CharCategory.DIGIT;
                            else return CharCategory.OTHER;
                        }
                )
        ));


        //find employees worked on 3 departments
        List<WorkRecord> records = List.of(
                new WorkRecord("John", "IT"),
                new WorkRecord("John", "Finance"),
                new WorkRecord("John", "HR"),
                new WorkRecord("Alice", "IT"),
                new WorkRecord("Alice", "HR"),
                new WorkRecord("Bob", "Finance"),
                new WorkRecord("David", "IT"),
                new WorkRecord("David", "Finance"),
                new WorkRecord("David", "HR"),
                new WorkRecord("David", "Admin")
        );
        System.out.println(records.stream().collect(
                        Collectors.groupingBy(
                                WorkRecord::getEmployeeName,
                                Collectors.counting()
                        )
                ).entrySet().stream().filter(elem -> elem.getValue() >= 3)
                .map(elem -> elem.getKey()).toList());


        //find bigram(pair of consecutive words) frequencies from a paragraph
        String p = "Java is great and java is fun, Java is powerful";
        String[] words = p.toLowerCase().replaceAll("[^a-z\\s]", "").split(" ");
        List<String> list = IntStream.range(0, words.length - 1)
                .mapToObj(index -> words[index] + " " + words[index + 1])
                .toList();
        System.out.println(list);
        System.out.println(list.stream().collect(
                Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                )
        ));

    }
}
