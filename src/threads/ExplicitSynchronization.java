package threads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private int balance = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void deposit() {
        lock.lock();
        try {
            balance++;
        } finally {
            lock.unlock();
        }
    }

    public void withdraw() {
        lock.lock();
        try {
            balance--;
        } finally {
            lock.unlock();
        }
    }

    public int getBalance() {
        return balance;
    }
}

class TryLock {
    private final ReentrantLock lock = new ReentrantLock();

    public void safeMethod() throws InterruptedException {
        boolean isLockAcquired = lock.tryLock(100, TimeUnit.MILLISECONDS);
        if (isLockAcquired) {
            try {
                // Critical section
            } finally {
                lock.unlock();
            }
        } else {
            // Handle the case where the lock is not available
        }
    }
}

public class ExplicitSynchronization {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        Thread depositThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                account.deposit();
            }
            System.out.println("Final Balance after deposits: " + account.getBalance());
        });

        Thread withdrawThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                account.withdraw();
            }
            System.out.println("Final Balance after withdrawals: " + account.getBalance());
        });

        depositThread.start();
        withdrawThread.start();

        try {
            depositThread.join();
            withdrawThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
