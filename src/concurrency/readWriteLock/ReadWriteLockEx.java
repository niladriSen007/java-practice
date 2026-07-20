package concurrency.readWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockEx {
    // create the Read Write Lock
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock(true);

    // Extract the read and write locks for convenience
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();

    // The shared data we're protecting
    private Map<String, String> config = new HashMap<>();

    // Multiple threads can call get() simultaneously
    public String get(String key) {
        readLock.lock(); // Acquire read lock (shared)
        try {
            return config.get(key); // Safe to read while holding read lock
        } finally {
            readLock.unlock(); // Always release in finally block
        }
    }

    // Only one thread can write at a time, and no readers during write
    public void set(String key, String value) {
        writeLock.lock(); // Acquire write lock (exclusive)
        try {
            config.put(key, value); // Safe to modify while holding write lock
        } finally {
            writeLock.unlock();
        }
    }

    // Return a snapshot of all configuration
    public Map<String, String> getConfig() {
        readLock.lock();
        try {
            // Return a copy so caller can iterate without holding the lock
            return new HashMap<>(config);
        } finally {
            readLock.unlock();
        }
    }
}
