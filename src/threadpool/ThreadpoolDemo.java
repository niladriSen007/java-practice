package threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadpoolDemo {
    public static void main(String[] args) {
//        int threadCount = 5;
//        int numberOfTasks = 50;
//        var threadPool = Executors.newScheduledThreadPool(threadCount);
//        for (int i = 0; i < numberOfTasks; i++) {
//            String message = "Scheduled task started with " + i + " seconds delay";
//            threadPool.schedule(() -> System.out.println(message), i, TimeUnit.SECONDS);
//        }

        int threadCount = 3;
        long initialDelay = 5;
        long interval = 30;
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(threadCount);
        threadPool.scheduleAtFixedRate(
                () -> System.out.println("Every 30 seconds, with initial delay 5 seconds"),
                initialDelay,
                interval,
                TimeUnit.SECONDS);
    }
}
