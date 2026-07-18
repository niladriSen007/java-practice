package concurrency.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreEx {

    // Create a semaphore with 3 permits
    // Up to 3 threads can hold permits simultaneously
    private final Semaphore semaphore = new Semaphore(3);

    // Optional: fair=true ensures FIFO ordering
    // Threads acquire permits in the order they requested
    private final Semaphore fairSemaphore = new Semaphore(3, true);

    // blocking
    public void accessResourceBlocking() throws InterruptedException {
        // acquire() blocks the calling thread until a permit is available
        semaphore.acquire();
        try{
            // Critical section - only 3 threads can be here at once
            doWork();
        }finally {
            // ALWAYS release in a finally block!
            // This ensures the permit is returned even if doWork() throws
            semaphore.release();
        }
    }

    public boolean accessResourceNonBlocking() throws InterruptedException {
        // tryAcquire() returns false immediately if no permit available
        // Use this when you have a fallback option
        if(semaphore.tryAcquire()){
            try{
                doWork();
                return true;
            }finally {
                semaphore.release();
            }
        }else{
            // Do fallback
        }
        return false;
    }

    private void doWork() {
        System.out.println(Thread.currentThread().getName() + " working...");
    }
}
