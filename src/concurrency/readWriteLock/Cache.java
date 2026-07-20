package concurrency.readWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class CacheWithStats<K, V> {
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    private final Map<K, V> cache = new HashMap<>();

    // Use AtomicLong for thread-safe counting without additional locks
    private final AtomicLong readCount = new AtomicLong();
    private final AtomicLong writeCount = new AtomicLong();

    public V get(K key) {
        readLock.lock();
        try {
            readCount.incrementAndGet();
            return cache.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public void put(K key, V value) {
        writeLock.lock();
        try {
            writeCount.incrementAndGet();
            cache.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    public void clear() {
        writeLock.lock();
        try {
            cache.clear();
        } finally {
            writeLock.unlock();
        }
    }

    public int getCacheSize() {
        readLock.lock();
        try {
            return cache.size();
        } finally {
            readLock.unlock();
        }
    }

    public String getStats() {
        return String.format("Reads: %d, Writes: %d, Size: %d",
                readCount.get(), writeCount.get(), getCacheSize());
    }
}

public class Cache {
    public static void main(String[] args) throws InterruptedException {
        CacheWithStats<String, Integer> cache = new CacheWithStats();

        // First, populate the cache with 100 entries
        for (int i = 0; i < 100; i++) {
            cache.put("key" + i, i);
        }

        // Create 10 reader threads, each doing 1000 reads
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    cache.get("key" + j);
                }
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println(cache.getStats());
    }
}
