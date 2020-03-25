import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompletableFuturePractice {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("Completable Future");
        System.out.println("=======================================================");

        Future<String> cf = asyncMethod();
//        cf.cancel(false);
        System.out.println("Blocking main thread: " + Thread.currentThread().getName());
        System.out.println("Unblocked and result: " + cf.get());

        System.out.println("=======================================================");

        CompletableFuture<String> cfAcceptApply = new CompletableFuture<>();
        cfAcceptApply.complete("Hello");
        cfAcceptApply = cfAcceptApply
                .thenApply(s -> s + ", World!");
        CompletableFuture<Integer> length = cfAcceptApply.thenApply(s -> s.length());
        CompletableFuture<String> newComp = createAnkush("Ankush")
                .thenCompose(s -> createAnkush(s + " Garg"));
        System.out.println("newComp: " + newComp.get());
        System.out.println("Length: " + length.join());

        CompletableFuture<Void> future = cfAcceptApply.thenAccept(s -> System.out.println(s));
        System.out.println(future);
        System.out.println(future.get());
        System.out.println(cfAcceptApply.get());

        System.out.println("=======================================================");

        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Joining second future with first.");

        CompletableFuture<String> joined = completableFuture
                .thenCompose(i -> CompletableFuture.supplyAsync(() -> i + " well"));
        System.out.println("Composed: " + joined.get());

        completableFuture = completableFuture
                .thenCombine(cfAcceptApply, (s1, s2) -> s1 + " " + s2);
        System.out.println("Combined: " + completableFuture.get());

        completableFuture.thenAcceptBoth(cfAcceptApply, (s1, s2) -> System.out.println("thenAcceptBoth: main: " + s1 + " other: " + s2));

        System.out.println("=======================================================");

        CompletableFuture<Void> future1 = completableFuture
                .thenRun(() -> System.out.println("Then run."));
        System.out.println(future1);
        System.out.println(future1.get());

        System.out.println("=======================================================");

        // When we need to execute multiple Futures in parallel,
        // We usually want to wait for all of them to execute and then process their combined results.
        CompletableFuture<String> future10 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future11 = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future12 = CompletableFuture.supplyAsync(() -> "World");
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future10, future11, future12);
        System.out.println("Combined future: " + combinedFuture);
        System.out.println(combinedFuture.get()); // void
        System.out.println(future10.isDone() + " " + future11.isDone() + " " + future12.isDone());

        System.out.println("Join");
        /**
         * Waits if necessary for this future to complete, and then
         * returns its result.
         *
         * @return the result value
         * @throws CancellationException if this future was cancelled
         * @throws ExecutionException if this future completed exceptionally
         * @throws InterruptedException if the current thread was interrupted
         * while waiting
        public T get() throws InterruptedException, ExecutionException {
        Object r;
        return reportGet((r = result) == null ? waitingGet(true) : r);
        }

         * Returns the result value when complete, or throws an
         * (unchecked) exception if completed exceptionally. To better
         * conform with the use of common functional forms, if a
         * computation involved in the completion of this
         * CompletableFuture threw an exception, this method throws an
         * (unchecked) {@link CompletionException} with the underlying
         * exception as its cause.
         *
         * @return the result value
         * @throws CancellationException if the computation was cancelled
         * @throws CompletionException if this future completed
         * exceptionally or a completion computation threw an exception
        public T join() {
        Object r;
        return reportJoin((r = result) == null ? waitingGet(false) : r);
        }
         */
        String combined = Stream.of(future10, future11, future12)
                .map(CompletableFuture::join)
                .collect(Collectors.joining(" "));
        System.out.println(combined);

        System.out.println("=======================================================");

        CompletableFuture<String> futureAny10 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "FutureAny10";
        });
        CompletableFuture<String> futureAny11 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "FutureAny11";
        });
        CompletableFuture<String> futureAny12 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "FutureAny12";
        });

        CompletableFuture<Object> anyFuture = CompletableFuture.anyOf(futureAny10, futureAny11, futureAny12);
        System.out.println(anyFuture.get());

        System.out.println("=======================================================");

        CompletableFuture<Integer> cff = new CompletableFuture<>();
        Future<Integer> ftr = cff.thenApply(d -> d * 2);
        cff.complete(7);
        System.out.println(cff.get());
        System.out.println(ftr.get());

        System.out.println("=======================================================");

    }

    private static CompletableFuture<String> createAnkush(String name) {
        return CompletableFuture.supplyAsync(() -> name);
    }

    private static Future<String> asyncMethod() {
        CompletableFuture<String> cf = new CompletableFuture<>();
        ExecutorService es = Executors.newCachedThreadPool();
        es.submit(() -> {
            System.out.println("Async Thread: " + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(1);
            cf.complete("Processing Finished");
            return null;
        });
        es.shutdown();
        return cf;
    }
}
