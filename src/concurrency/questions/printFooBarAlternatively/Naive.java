package concurrency.questions.printFooBarAlternatively;

import java.util.concurrent.atomic.AtomicBoolean;

public class Naive {
    private final int n;
    private final AtomicBoolean fooTurn = new AtomicBoolean(true);

    public Naive(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for(int i=0; i<n; i++) {
            // Spin until it's foo's turn
            while(!fooTurn.get()) {
                // Busy waiting - wastes CPU!
            }
            printFoo.run(); // Print "foo"
            fooTurn.set(false); // Signal bar's turn
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // Spin until it's bar's turn
            while (fooTurn.get()) {
                // Busy waiting - wastes CPU!
            }
            printBar.run();  // Print "bar"
            fooTurn.set(true);  // Signal foo's turn
        }
    }
}
