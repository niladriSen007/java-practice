package threads;

import java.util.concurrent.*;

public class FutureDemo {
    public static void main(String[] args) {

        Callable<String> task = () -> {
            Thread.sleep(2000);
            return "Task Completed";
        };

        ExecutorService executor = Executors.newFixedThreadPool(5);

        Future<String> submittedFuture = executor.submit(task);

        while (!submittedFuture.isDone()) {
            System.out.println("Task is still in progress...");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        try {
            String s = submittedFuture.get();
            System.out.println(s);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            executor.shutdown();
        }
    }
}
