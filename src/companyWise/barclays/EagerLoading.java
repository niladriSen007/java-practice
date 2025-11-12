package companyWise.barclays;

class Address {
    private final String location;

    Address(String location) {
        this.location = location;
        System.out.println("Address created");
    }

    public String getLocation() {
        return location;
    }
}

class Employee {

    private final Address address;

    Employee() {
        this.address = new Address("Kolkata");
        System.out.println("Employee created with address eagerly loaded");
    }

    public Address getAddress() {
        return address;
    }
}

public class EagerLoading {
    public static void main(String[] args) {
        Employee employee = new Employee();
        System.out.println("Employee Address: " + employee.getAddress().getLocation());
    }
}
