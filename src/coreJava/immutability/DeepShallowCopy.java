package coreJava.immutability;

class Address {
    String city;

    Address(String city) {
        this.city = city;
    }
}

class GreatAddress implements Cloneable {
    String city;

    GreatAddress(String city) {
        this.city = city;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class GreatePerson implements Cloneable{
    String name;
    GreatAddress address;

    GreatePerson(String name, GreatAddress address) {
        this.name = name;
        this.address = address;
    }

    // Deep copy
    @Override
    protected Object clone() throws CloneNotSupportedException {
        GreatePerson cloned = (GreatePerson) super.clone();
        cloned.address = (GreatAddress) address.clone();
        return cloned;
    }
}

class Person implements Cloneable{
    String name;
    Address address;

    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Deep copy
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}



class ShallowCopy {
    String name;
    Address address;

    ShallowCopy(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}

public class DeepShallowCopy {
    static void main() throws CloneNotSupportedException {

        System.out.println("Shallow Copy Example: ------------------");

        Address a = new Address("Mumbai");


        // example using basic constructor for shallow copy
        ShallowCopy original = new ShallowCopy("John", a);
        ShallowCopy shallowCopy = new ShallowCopy("Nil", a);

        System.out.println("Before Modification:");
        System.out.println(original.address.city);
        System.out.println(shallowCopy.address.city);


        shallowCopy.address.city = "Pune";
        System.out.println("After Modification:");
        System.out.println(original.address.city);
        System.out.println(shallowCopy.address.city);

        //example using clone method
        Person person1=new Person("Nilay",a);
        Person person2= (Person) person1.clone();
        System.out.println("Before Modification using clone():");
        System.out.println(person1.address.city);
        System.out.println(person2.address.city);
        person2.address.city="Delhi";
        System.out.println("After Modification using clone():");
        System.out.println(person1.address.city);
        System.out.println(person2.address.city);



        System.out.println("Deep Copy Example: ------------------");
        GreatAddress ga = new GreatAddress("Mumbai");
        GreatePerson gperson1=new GreatePerson("Nilay",ga);
        GreatePerson gperson2= (GreatePerson) gperson1.clone();
        System.out.println("Before Modification using clone():");
        System.out.println(gperson1.address.city);
        System.out.println(gperson2.address.city);
        gperson2.address.city="Delhi";
        System.out.println("After Modification using clone():");
        System.out.println(gperson1.address.city);
        System.out.println(gperson2.address.city);
    }
}
