package coreJava;

public class CanWeOverloadMain {
    public static void main(String[] args) {
        System.out.println("Main");
    }

    public static void main(String args) {
        System.out.println("Demo");
    }
}


class DemoClass extends CanWeOverloadMain{
    public static void main(String[] args) {
        System.out.println("Demo Main");
    }
}