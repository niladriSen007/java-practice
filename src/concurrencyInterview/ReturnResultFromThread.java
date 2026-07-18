package concurrencyInterview;

import java.util.concurrent.CompletableFuture;

public class ReturnResultFromThread {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 10);
        future.thenApply(sum -> sum * 3).thenAccept(System.out::println);
    }
}
