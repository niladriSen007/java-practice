package staticEx;

public class StaticDemo {

    private static int staticCounter = assignCounter();

    static{
        System.out.println("Static block executed");
        System.out.println("staticCounter = " + staticCounter);
    }

    static int assignCounter(){
        System.out.println("Assigning staticCounter");
        return 12;
    }

    public static void main(String[] args) {
        System.out.println("Main method executed");
    }
}
