package concurrencyInterview.threadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class MonitoredThreadFactory implements ThreadFactory {

    private final String poolName;
    private final AtomicInteger totalThreadCount = new AtomicInteger(0);
    private final AtomicInteger activeCount = new AtomicInteger(0);

    public MonitoredThreadFactory(String poolName) {
        this.poolName = poolName;
    }

    @Override
    public Thread newThread(Runnable r) {
        int num = totalThreadCount.incrementAndGet();
        String name = poolName + "-thread-" + num;

        Runnable runner = () -> {
            activeCount.incrementAndGet();
            System.out.println("Thread {} started" + name);

            try {
                r.run();
            } finally {
                activeCount.decrementAndGet();
                System.out.println("Thread {} finished" + name);
            }
        };
        Thread t = new Thread(runner, name);
        t.setUncaughtExceptionHandler((thread, ex) -> {
            System.out.println("Thread " + thread.getName() + " threw uncaught exception " + ex);
        });

        return t;
    }

    public int getTotalCreated() {
        return totalThreadCount.get();
    }

    public int getActiveCount() {
        return activeCount.get();
    }

}

public class ProductionThreadFactory {
    public static void main(String[] args) {

        ExecutorService  executorService = Executors.newFixedThreadPool(4, new MonitoredThreadFactory("orderprocessiing"));
    }
}
