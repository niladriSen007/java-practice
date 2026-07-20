package concurrency.questions.printFooBarAlternatively;

import java.util.concurrent.Semaphore;

public class Main {
    static final int N = 5;

    public static void main(String[] args) throws InterruptedException {
        StringBuilder sb = new StringBuilder();
        Semaphore fooSemaphore = new Semaphore(1);
        Semaphore barSemaphore = new Semaphore(0);
        Thread foo = new Thread(() -> {
            for (int i = 0; i < N; i++) {
                try {
                    fooSemaphore.acquire();
                    System.out.println("Foo ");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    barSemaphore.release();
                }

            }
        });
        Thread bar = new Thread(() -> {
            for (int i = 0; i < N; i++) {
                try {
                    barSemaphore.acquire();
                    System.out.println("Bar ");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    fooSemaphore.release();
                }
            }
        });
        foo.start();
        bar.start();
        foo.join();
        bar.join();
        System.out.println(sb.toString());
    }
}
