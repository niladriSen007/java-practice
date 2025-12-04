package coreJava;

class Parent{
    void print(){
        System.out.println("Parent");
    }

    static void staticMethod(){
        System.out.println("I am static parent");
    }
}

class Child extends Parent{
    void print(){
        System.out.println("Child");
    }
    static void staticMethod(){
        System.out.println("I am static child");
    }
}


public class CanWeOverrideStatic {
    public static void main(String[] args) {
        Parent c = new Child();
        c.print();
        Child.staticMethod();
    }
}
