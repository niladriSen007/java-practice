package coreJava;

class First {
    int x = 10;

    void show() {
        System.out.println("First Parent");
    }
}

class Second extends First {
    int x = 20;

    void show() {
        System.out.println("Second Child");
    }
}

public class VariableResolution {
    static void main() {
        First first = new Second();
        System.out.println(first.x);
        first.show();
        Second second = new Second();
        System.out.println(second.x);
        second.show();

//        Method →executed from Child(runtime polymorphism).
//         Fields →executed from Parent(compile - time).
    }
}
