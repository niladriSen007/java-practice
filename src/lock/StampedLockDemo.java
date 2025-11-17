package lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

class ReEntrantReadWriteLock {
    Map<String, String> syncMap = new HashMap<>();
    ReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    Lock readLock = reentrantReadWriteLock.readLock();
    Lock writeLock = reentrantReadWriteLock.writeLock();

    void put(String key, String value) {
        try {
            writeLock.lock();
            syncMap.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    void get(String key) {
        try {
            readLock.lock();
            syncMap.get(key);
        } finally {
            readLock.unlock();
        }
    }
}


class StampedReadWriteLock {
    Map<String, String> syncMap = new HashMap<>();
    private StampedLock stampedLock = new StampedLock();

    public void put(String key, String value) {
        long stamp = stampedLock.writeLock();
        try {
            syncMap.put(key, value);
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }

    public String readWithOptimisticLock(String key) {
        long stamp = stampedLock.tryOptimisticRead();
        String value = syncMap.get(key);
        if (!stampedLock.validate(stamp)) {
            stamp = stampedLock.readLock();
            try {
                value = syncMap.get(key);
            } finally {
                stampedLock.unlockRead(stamp);
            }
        }
        return value;
    }

}

public class StampedLockDemo {
    public static void main(String[] args) {


    }


}
