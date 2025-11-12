package companyWise.jpMorgan;

// 5. Suppose you have 2 threads.
// One of them prints (1,2,3…) and the other one prints (A,B,C,..).
// How will you ensure that they run in a sequence,
// so that it prints (1,A,2,B…)?

public class TrickyThread {

    private final Object lock = new Object(); // this is the common lock object which will be used for synchronization by the two threads
    public volatile boolean isNumberTurn = true;

    public static void main(String[] args) {
        TrickyThread trickyThread = new TrickyThread();
        Thread numberThread = new Thread(trickyThread::printNumbers);
        Thread letterThread = new Thread(()-> trickyThread.printLetters());

        numberThread.start();
        letterThread.start();
    }

    public void printNumbers() {
        for (int i = 1; i < 26; i++) {
            synchronized (lock) {
                while (!isNumberTurn) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println(i + " ");
                isNumberTurn = false;
                lock.notifyAll();
            }
        }
    }

    public void printLetters() {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            synchronized (lock) {
                while (isNumberTurn) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println(ch + " ");
                isNumberTurn = true;
                lock.notifyAll();
            }
        }
    }
}
