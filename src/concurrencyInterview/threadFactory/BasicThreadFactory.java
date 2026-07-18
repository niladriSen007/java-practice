package concurrencyInterview.threadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;


class NamedThreadFactory implements ThreadFactory {

    private final String namePrefix;
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final boolean isDaemon;

    public NamedThreadFactory(String namePrefix, boolean isDaemon) {
        this.namePrefix = namePrefix;
        this.isDaemon = isDaemon;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, namePrefix + "-" + threadNumber.getAndIncrement());
        t.setDaemon(isDaemon);
        t.setUncaughtExceptionHandler((thread, e) -> {
            System.err.println("Thread " + thread.getName() + " died: " + e.getMessage());
        });
        return t;
    }
}

public class BasicThreadFactory {
    public static void main(String[] args) {
        ExecutorService executorService =
                Executors.newFixedThreadPool(4, new NamedThreadFactory("OrderProcessor", false));
//        executorService.execute(() -> {
//
//        })
    }
}
