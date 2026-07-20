package concurrency.questions.printFooBarAlternatively;

import java.util.concurrent.Semaphore;

public class SemaphoreBased {
    private final int n;
    private final Semaphore fooSemaphore = new Semaphore(1);  // Foo goes first
    private final Semaphore barSemaphore = new Semaphore(0);  // Bar waits

    public SemaphoreBased(int n){
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for(int i = 0; i < n; i++){
            fooSemaphore.acquire();
            printFoo.run();
            fooSemaphore.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for(int i = 0; i < n; i++){
            barSemaphore.acquire();
            printBar.run();
            barSemaphore.release();
        }
    }
}
