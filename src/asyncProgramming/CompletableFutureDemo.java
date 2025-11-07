package asyncProgramming;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {
    public static void main(String[] args) {
//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
//            // Simulate a long-running computation
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return 42;
//        });
//        future.thenApplyAsync(res -> res * 2)
//                .thenAcceptAsync(result -> System.out.println("Final Result: " + result));

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            return 10;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            return 20;
        });

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(future1, future2);
        voidCompletableFuture.thenRun(()->{
            try{
                System.out.println("Future1: " + future1.get());
                System.out.println("Future2: " + future2.get());
                System.out.println("Sum: " + (future1.get() + future2.get()));
            } catch (RuntimeException | InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

    }
}
