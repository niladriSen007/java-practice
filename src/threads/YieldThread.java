package threads;

public class YieldThread {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Yielding Thread - Count: " + i);
                Thread.yield();
            }
        });
        thread.start();
    }
}
