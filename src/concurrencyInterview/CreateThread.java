package concurrencyInterview;

public class CreateThread {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Processing by thread -> " + Thread.currentThread().getName());
        });
        thread.start();
    }
}
