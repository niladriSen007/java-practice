package threads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class SharedCache {
    private Map<String, String> syncHashMap = new HashMap<>();

    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();

    public void put(String key, String value) {
        writeLock.lock();
        try {
            syncHashMap.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    public String get(String key) {
        readLock.lock();
        try {
            return syncHashMap.get(key);
        } finally {
            readLock.unlock();
        }

    }
}

public class ReadWriteLockExample {
    public static void main(String[] args) {
        Thread writerThread = new Thread(() -> {
            SharedCache cache = new SharedCache();
            for (int i = 0; i < 5; i++) {
                cache.put("key" + i, "value" + i);
                System.out.println("Written: key" + i + " -> value" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread readerThread = new Thread(() -> {
            SharedCache cache = new SharedCache();
            for (int i = 0; i < 5; i++) {
                String value = cache.get("key" + i);
                System.out.println("Read: key" + i + " -> " + value);
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        writerThread.start();
        readerThread.start();

        try {
            writerThread.join();
            readerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
