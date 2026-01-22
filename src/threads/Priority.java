package threads;

public class Priority {
    public static void main(String[] args) {
        Thread lowPriority = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Low Priority Thread - Count: " + i);
            }
        }, "LowPriorityThread");

        Thread highPriority = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("High Priority Thread - Count: " + i);
            }
        }, "HighPriorityThread");

        lowPriority.setPriority(Thread.MIN_PRIORITY);
        highPriority.setPriority(Thread.MAX_PRIORITY);

        lowPriority.start();
        highPriority.start();

        try {
            lowPriority.join();
            highPriority.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
