package concurrency.mutex;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

class Counter {
    private int counter = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void incrementCount() {
        lock.lock();
        try {
            counter++;
        } finally {
            lock.unlock();
        }
    }

    public int getCounter() {
        lock.lock();
        try {
            return counter;
        } finally {
            lock.unlock();
        }
    }
}

public class ThreadSafeCounter {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    counter.incrementCount();
                }
            });
            threads.add(thread);
            thread.start();
        }

        // Wait for all threads
        for (Thread t : threads) {
            //The join() calls are equally important. They make the main thread wait until all worker threads have completed
            // before printing the final count. Without joins, you might print the count while threads are still incrementing.
            t.join();
        }

        System.out.println("Final count: " + counter.getCounter());
    }
}
