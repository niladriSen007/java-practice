package concurrency.mutex;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Mutex {
    private int counter = 0;

    //Approach 1 - Explicit LOCK
    private final Lock lock = new ReentrantLock();

    public void incrementCounterWithLock() {
        try {
            lock.lock();
            counter++;
        } finally {
            lock.unlock();
        }
    }

    //Approach 2 - Synchronized block
    public void incrementCounterWithBlock() {
        synchronized (this) {
            counter++;
        }
    }

    //Approach 3 - Synchronized function
    public synchronized void incrementCounterWithFunction() {
        counter++;

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
