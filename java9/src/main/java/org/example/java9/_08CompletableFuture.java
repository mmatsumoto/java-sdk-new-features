package org.example.java9;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 9) CompletableFuture
 * https://www.baeldung.com/java-9-completablefuture
 * more:
 * Executor defaultExecutor()
 * CompletableFuture<U> newIncompleteFuture()
 * CompletableFuture<T> copy()
 * CompletionStage<T> minimalCompletionStage()
 * CompletableFuture<T> completeAsync(Supplier<? extends T> supplier, Executor executor)
 * CompletableFuture<T> completeAsync(Supplier<? extends T> supplier)
 * CompletableFuture<T> orTimeout(long timeout, TimeUnit unit)
 * CompletableFuture<T> completeOnTimeout(T value, long timeout, TimeUnit unit)
 */
class _08CompletableFuture {
    public static CompletableFuture<String> execute(long sleep) {
        CompletableFuture<String> completableFuture
                = new CompletableFuture<>();

        Executors.newSingleThreadExecutor().submit(() -> {
            Thread.sleep(sleep);
            completableFuture.complete("Hallo Deutschland!");
            return null;
        });

        return completableFuture;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        try {
            String message = execute(200L).orTimeout(50L, TimeUnit.MILLISECONDS).get();
            System.out.println(message);
        } catch (Exception e) {
            System.out.println(e.getCause() instanceof java.util.concurrent.TimeoutException);
        }

        String message = execute(200L)
                .completeOnTimeout("default answer", 50L, TimeUnit.MILLISECONDS)
                .get();
        System.out.println(message);


        System.out.println("waiting to completablefutures terminate");
        Thread.sleep(600L);
        System.out.println("done");
    }
}
