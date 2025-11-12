package companyWise.barclays;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class EmployeeDemo {
    String name;
    int age;

    public EmployeeDemo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "EmployeeDemo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class EmployeeAgeComparator implements Comparator<EmployeeDemo> {

    @Override
    public int compare(EmployeeDemo o1, EmployeeDemo o2) {
        return o2.getAge() - o1.getAge();
    }
}

public class ComparatorDemo {
    public static void main(String[] args) {
        List<EmployeeDemo> empList = new ArrayList<>();
        empList.add(new EmployeeDemo("Nil", 20));
        empList.add(new EmployeeDemo("Nil1", 220));
        empList.add(new EmployeeDemo("Nil2", 203));

        System.out.println("Employees sorted by age:");
//        System.out.println(empList.stream().sorted(Comparator.comparingInt(EmployeeDemo::getAge).reversed()).toList());
        empList.sort(new EmployeeAgeComparator());
        System.out.println(empList);
        System.out.println(empList.stream().sorted(Comparator.comparing(EmployeeDemo::getName).reversed()).toList());
    }

}
