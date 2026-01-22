package threads;

import java.util.concurrent.TimeUnit;

public class Main {
     public static void main(String[] args) {
          Runnable task = () -> {
               for (int i = 0; i < 5; i++) {
                    System.out.println("Thread " + Thread.currentThread().getName() + " - Count: " + i);
                    try {
                         TimeUnit.MILLISECONDS.sleep(500); // Simulate work
                    } catch (InterruptedException e) {
                         Thread.currentThread().interrupt();
                    }
               }
          };
          Thread thread1 = new Thread(task, "Worker-1");
          Thread thread2 = new Thread(task, "Worker-2");
          thread1.start();
          thread2.start();

          try {
               thread1.join();
               thread2.join();
          } catch (InterruptedException e) {
               Thread.currentThread().interrupt();
          }
     }
}
