package trickyQuestions;

public class CanWeOverrideJava {
    public static void main(String[] args) {
        System.out.println("Hii");
    }

    public static void main(String args) {
        System.out.println("Hello");
    }
}

class Demo extends CanWeOverrideJava{
    public static void main(String[] args) {
        System.out.println("Bye");
    }
}

class NewCheck{
    public static void main(String[] args) {
        Demo.main("Huh");
    }
}
