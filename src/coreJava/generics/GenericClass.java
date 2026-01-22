package coreJava.generics;

class TwoGeneric<T, U> {
    private T first;
    private U second;

    public TwoGeneric(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
}

class Box<T> {
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}

public class GenericClass {

    static void main() {
        Box<Integer> integerBox = new Box<>();
        Box<String> stringBox = new Box<>();

        integerBox.set(10);
        stringBox.set("Hello Generics");

        System.out.println(STR."Integer Value: \{integerBox.get()}");
        System.out.println("String Value: " + stringBox.get());


        TwoGeneric<Integer, String> twoGeneric = new TwoGeneric<>(1, "One");
        System.out.println(STR."First: \{twoGeneric.getFirst()}, Second: \{twoGeneric.getSecond()}");
    }
}
