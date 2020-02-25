package org.example.module.one.java9;

import lombok.Value;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;


/**
 * 1) jshell - REPL
 * no semi-colon
 * use TABs to autocomplete
 */

/**
 * 2) private methods on interfaces
 */
interface Util {
    default void doSomething1() {
        System.out.println(privateMethod1());
    }

    static void doSomething2() {
        System.out.println(privateMethod2());
    }

    private int privateMethod1() {
        return 1;
    }

    private static int privateMethod2() {
        return 2;
    }
}

/**
 * 3) List.of, Set.of, Map.of
 */
class OfUtil {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7);

        // of returns immutable representation, the code bellow throw exceptions
        // integers.add(1);
        // integers.set(0, 1);

        System.out.println(integers);

        System.out.println(Set.of(1, 2, 3, 4));
        System.out.println(Map.of("k1", "v1", "k2", "v2"));
    }
}

/**
 * 4) TryWithResource - AutoCloseable
 */
class TryWithResource {
    static class Resource implements AutoCloseable {
        public Resource() {
            System.out.println("Resource created!");
        }

        public void op1() {
            System.out.println("op1 invoked");
        }

        @Override
        public void close() {
            System.out.println("Resource cleanup!");
        }
    }

    public static void main(String[] args) {
        try (Resource resource = new Resource()) {
            resource.op1();
        }
        // or
        // try(resource) { ... }
    }
}

/**
 * 5) Stream takeWhile, dropWhile
 */
class StreamUtil {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("takeWhile");
        // takeWhile
        numbers.stream()
                .takeWhile(e -> e < 5)
                .forEach(System.out::println);

        System.out.println("dropWhile");
        // dropWhile
        numbers.stream()
                .dropWhile(e -> e < 5)
                .forEach(System.out::println);
    }
}

/**
 * 6) IntStream.iterate
 */
class IntIterate {
    public static void main(String[] args) {
        System.out.println("iterate (seed, predicate, operator)");
        IntStream.iterate(0, i -> i < 5, i -> i + 1)
                .forEach(System.out::println);

        System.out.println("iterate infinite");
        IntStream.iterate(0, i -> i + 1)
                .limit(5)
//                .takeWhile(i -> i < 10)
                .forEach(System.out::println);
    }
}

/**
 * 7) Optional changes
 */
class OptionalUtil {
    public static void ifPresentOrElse() {
        printOptional(1);
        printOptional(null);
    }

    private static void printOptional(Integer value) {
        Optional<Integer> opt = Optional.ofNullable(value);
        System.out.println("Optional: " + opt);
        opt.ifPresentOrElse(
                e -> System.out.println("e: " + e),
                () -> System.out.println("I don't have value"));
    }

    public static void or() {
        System.out.println(Optional.of(10)
                .or(() -> Optional.of(1)));

        System.out.println(Optional.empty()
                .or(() -> Optional.of(1)));
    }

    public static void optionalStream() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.stream().filter(e -> e % 2 == 0)
                .findFirst() // return a optional
                .stream() // stream of one element
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        ifPresentOrElse();

        or();

        optionalStream();
    }
}

/**
 * 8) Collectors
 * https://www.baeldung.com/java9-stream-collectors
 */
class CollectorsUtil {
    public static void filtering() {
        List<Integer> numbers = List.of(1, 1, 2, 2, 3, 3, 3, 5, 5, 6);

        // no java 9, just to understand the difference from stream filter and Collectors filtering
        Map<Integer, Long> result = numbers.stream()
                .filter(val -> val > 3)
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        System.out.println(result);
        // prints {5=2, 6=1}

        result = numbers.stream()
                .collect(Collectors.groupingBy(i -> i,
                        Collectors.filtering(val -> {
                            System.out.println("val " + val);
                            return val > 3;
                        }, Collectors.counting())));
        System.out.println(result);
        // prints: {1=0, 2=0, 3=0, 5=2, 6=1}
        // the count on 1, 2, and 3 is not incremented because val > 3 is false
    }

    @Value
    static class ColorFruit {
        public String color;
        public List<String> fruits;
    }

    public static void flatMapping() {
        List<ColorFruit> colorFruits = List.of(
                new ColorFruit("red", asList("apple", "strawberry")),
                new ColorFruit("yellow", asList("banana", "manga"))
        );

        // without flatMapping - List of List<String>
        Map<String, List<List<String>>> colorFruits1 = colorFruits.stream()
                .collect(Collectors.groupingBy(ColorFruit::getColor,
                        Collectors.mapping(ColorFruit::getFruits, Collectors.toList())));
        System.out.println(colorFruits1);
        //prints: {red=[[apple, strawberry]], yellow=[[banana, manga]]}

        Map<String, List<String>> colorFruits2 = colorFruits.stream()
                .collect(Collectors.groupingBy(ColorFruit::getColor,
                        Collectors.flatMapping(c -> c.getFruits().stream(), Collectors.toList())));
        System.out.println(colorFruits2);
        // prints: {red=[apple, strawberry], yellow=[banana, manga]}
    }

    public static void main(String[] args) {
        filtering();

        flatMapping();
    }
}


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
class CompletableFutureUtil {
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

/**
 * 10) jigsaw - modules - check java9-module-one and java9-module-two
 */

public class ExamplesJava9 {
    public static void main(String[] args) {
        System.out.println("Halo java 9");
    }
}
